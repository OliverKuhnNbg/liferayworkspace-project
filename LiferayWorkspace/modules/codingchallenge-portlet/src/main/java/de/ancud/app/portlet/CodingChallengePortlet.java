package de.ancud.app.portlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import de.ancud.app.constants.CodingChallengePortletKeys;
import de.ancud.app.portlet.helpers.DateConverter;
import de.ancud.app.service.model.Task;
import de.ancud.app.service.service.TaskLocalService;
import de.ancud.app.service.service.TaskLocalServiceUtil;


/**
 * @author Oliver
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CodingChallenge",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CodingChallengePortletKeys.CODINGCHALLENGE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CodingChallengePortlet extends MVCPortlet {
	
	private DateConverter dateConverter = new DateConverter();
	
	@Reference
	private TaskLocalService taskLocalService;

	@Reference
	private CounterLocalService counterLocalService;
	
	private List<Task> allTaskEntrys = new ArrayList<>();
	private long userId = 0;
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
	    throws IOException, PortletException {
		allTaskEntrys = new ArrayList<>();

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Task.class.getName(), renderRequest);
			int taskEntysCount = taskLocalService.getTasksCount();
			
			/* userId */
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			userId = themeDisplay.getUserId();
			
			/* TODO try to get entrys over finders I guess finders are located in the Utils */
			/* all entrys */
			allTaskEntrys = TaskLocalServiceUtil.getTasks(0, taskEntysCount);
			/* filter list */
			allTaskEntrys = filterAllTasksByUserId(allTaskEntrys);
			
			/*map entries to request*/
			List<String> allDatesConverted = dateConverter.getDateAsStringList(allTaskEntrys);
			renderRequest.setAttribute("tasks", allTaskEntrys);
			renderRequest.setAttribute("convertedDateList", allDatesConverted);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.render(renderRequest, renderResponse);
	}
	
	public void addEntry(ActionRequest request, ActionResponse response) {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		
		String taskEntry = ParamUtil.getString(request, "task");
		String dateStr = ParamUtil.getString(request, "duedate");
		
		if(!taskEntry.equals("") && !dateStr.equals("")) {
			Date date = dateConverter.convertDateStrToDate(dateStr);
			
			Task task = taskLocalService.createTask(counterLocalService.increment());
			task.setUserId(userId);
			task.setToDoTask(taskEntry);
			task.setDueDate(date);
			task.setDone(false);
			
			taskLocalService.addTask(task);
		}
	}
	
	public void markDone(ActionRequest request, ActionResponse response) {
		String taskFormInput = "";
		
		for (int i = 0; i < allTaskEntrys.size(); i++) {
			Task taskItem = allTaskEntrys.get(i);
			long taskId = taskItem.getTaskId();
			taskFormInput = ParamUtil.getString(request, "taskCheckBox_" + taskId);
			
			if(taskFormInput == "") {
				taskItem.setDone(false);
			} else {
				taskItem.setDone(true);
			}
			taskLocalService.updateTask(taskItem);
		}
	}
	
	private List<Task> filterAllTasksByUserId(List<Task> allTasks) {
		for (Task task:allTasks) {
			if (task.getUserId() != userId) {
				allTasks.remove(task);
			}
		}
		
		return allTasks;
	}
}