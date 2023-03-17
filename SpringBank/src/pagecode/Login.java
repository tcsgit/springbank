/**
 * 
 */
package pagecode;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlMessages;

import com.ibm.faces.component.html.HtmlCommandExButton;
import com.ibm.faces.component.html.HtmlScriptCollector;
import com.springbank.entity.Operator;
import com.springbank.service.core.AuthenticationService;
import com.springbank.ui.bean.LoginBean;

/**
 * @author IS95592
 *
 */
public class Login extends PageCodeBase {

	protected HtmlScriptCollector scriptCollector1;
	protected HtmlMessages messages1;
	protected HtmlInputText operatorAlias;
	protected HtmlForm form1;
	protected HtmlInputSecret operatorPassword;
	protected HtmlCommandExButton loginBtn;
	protected LoginBean loginBean;
	private AuthenticationService authenticationService ;
	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService; 
	}

	protected HtmlScriptCollector getScriptCollector1() {
		if (scriptCollector1 == null) {
			scriptCollector1 = (HtmlScriptCollector) findComponentInRoot("scriptCollector1");
		}
		return scriptCollector1;
	}

	protected HtmlMessages getMessages1() {
		if (messages1 == null) {
			messages1 = (HtmlMessages) findComponentInRoot("messages1");
		}
		return messages1;
	}

	protected HtmlInputText getOperatorAlias() {
		if (operatorAlias == null) {
			operatorAlias = (HtmlInputText) findComponentInRoot("operatorAlias");
		}
		return operatorAlias;
	}

	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	protected HtmlInputSecret getOperatorPassword() {
		if (operatorPassword == null) {
			operatorPassword = (HtmlInputSecret) findComponentInRoot("operatorPassword");
		}
		return operatorPassword;
	}

	protected HtmlCommandExButton getLoginBtn() {
		if (loginBtn == null) {
			loginBtn = (HtmlCommandExButton) findComponentInRoot("loginBtn");
		}
		return loginBtn;
	}

	public String doLoginBtnAction() {
		// Type Java code that runs when the component is clicked
	
		// TODO: Return outcome that corresponds to a navigation rule
		Operator authenticatedOperator = authenticationService.authenticateOperator(getLoginBean().getOperator().getOperatorAlias(), getLoginBean().getOperator().getOperatorPassword());
		if (authenticatedOperator != null) {
			getLoginBean().setOperator(authenticatedOperator);		
			return "customer";
		} else {
			getLoginBean().setOperator(new Operator());
			addMessage("Login failed : Unauthorized user !");
			return "";
		}

	}

	/** 
	 * @managed-bean true
	 */
	protected LoginBean getLoginBean() {
		if (loginBean == null) {
			loginBean = (LoginBean) getFacesContext().getApplication()
					.createValueBinding("#{loginBean}").getValue(
							getFacesContext());
		}
		return loginBean;
	}

	/** 
	 * @managed-bean true
	 */
	protected void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

}