package de.ancud.app.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

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
	
	//view form method
	@ProcessAction(name="formSubmit")
	public void formSubmit(ActionResponse response, ActionRequest request) {
		System.out.println("\ntest call: employeeSubmit()");
//		String name = ParamUtil.getString(request, "name");
//		String mobile = ParamUtil.getString(request, "dueday");
//		System.out.println(name);
	}
	
	public void doSomething(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		System.out.println("gold");
	}
}