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
	
	@Reference
	private TaskLocalService taskLocalService;

	@Reference
	private CounterLocalService counterLocalService;
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
	    throws IOException, PortletException {
		System.out.println("test render method");
		List<Task> allTaskEntrys = new ArrayList<>();

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Task.class.getName(), renderRequest);
			int taskEntysCount = taskLocalService.getTasksCount();
			
			/* userId */
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			
			/* TODO try to get entrys over finders I guess finders are located in the Utils */
			/* all entrys */
			allTaskEntrys = TaskLocalServiceUtil.getTasks(0, taskEntysCount);
			/* filter list */
			for (Task task:allTaskEntrys) {
				if (task.getUserId() != userId) {
					allTaskEntrys.remove(task);
				}
			}
			
			/*map entries to request*/
			List<String> allDatesConverted = getDateAsStringList(allTaskEntrys);
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
			Date date = convertDateStrToDate(dateStr);
			
			Task task = taskLocalService.createTask(counterLocalService.increment());
			task.setUserId(userId);
			task.setToDoTask(taskEntry);
			task.setDueDate(date);
			task.setDone(false);
			
			taskLocalService.addTask(task);
		}
	}
	
	private List<String> getDateAsStringList(List<Task> tasks) {
		List<String> dateStringyfiedList = new ArrayList<>();
		for (Task task : tasks) {
			String dateStr = convertDateToDateString(task.getDueDate());
			dateStringyfiedList.add(dateStr);
		}
		return dateStringyfiedList;
	}
	
	private Date convertDateStrToDate(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
		LocalDate localDate = LocalDate.parse(dateString, formatter);
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
		
		return date;
	}
	
	private String convertDateToDateString(Date d) {  
        DateFormat dateFormat = new SimpleDateFormat("dd. MMMM yyyy");
        String strDate = dateFormat.format(d); 
        
		return strDate;
	}
}