package de.ancud.app.angular.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import de.ancud.app.angular.constants.AngularLiferayPortletKeys;
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
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AngularLiferayPortletKeys.AngularLiferay,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.header-portlet-css=/css/main.scss",
	},
	service = Portlet.class
)
public class AngularLiferayPortlet extends MVCPortlet {
	
	@Reference
	private NPMResolver _npmResolver;
	
	@Reference
	private TaskLocalService taskLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		System.out.println("\n test portlet doView() new");
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
			System.out.println(allTaskEntrys.size());
			/* filter list */
			for (Task task:allTaskEntrys) {
				System.out.println(task.getToDoTask());
				if (task.getUserId() != userId) {
					allTaskEntrys.remove(task);
				}
			}
			
			/*map entries to request*/
			PortletSession session = renderRequest.getPortletSession();
			session.setAttribute("tasks", allTaskEntrys);
			renderRequest.setAttribute("tasks", allTaskEntrys);
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		renderRequest.setAttribute(
			"mainRequire",
			_npmResolver.resolveModuleName("angular-liferay-portlet") + " as main");

		super.doView(renderRequest, renderResponse);
	}
}