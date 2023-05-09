package de.ancud.app.portlet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import de.ancud.app.constants.CodingChallengePortletKeys;

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
	
	public void addEntry(ActionRequest request, ActionResponse response) {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		
		String taskEntry = ParamUtil.getString(request, "task");
		String dateStr = ParamUtil.getString(request, "duedate");
		
		/* checks empty inputs */
		if(!taskEntry.equals("") && !dateStr.equals("")) {
			LocalDate date = convertDateStrToDate(dateStr);
			System.out.println("\nBest");
			System.out.println(userId);
			System.out.println(taskEntry);
			System.out.println(date);
			System.out.println(false);
			
//			Task task = TaskLocalServiceUtil.createTask(CounterLocalServiceUtil.increment());
//			task.setToDoTask(taskEntry);
//			task.setDone(false);
//			
//			System.out.println("********\nTasKOBJ:\n\n" +task.getTaskId());
//			System.out.println(task.getTaskId());
//			TaskLocalServiceUtil.addTask(null)
		}
		
	}
	
	private LocalDate convertDateStrToDate(String date) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
		LocalDate localDate = LocalDate.parse(date, formatter);
		
		return localDate;
	}
}