/**
 * 
 */
package pagecode;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlMessages;
import javax.faces.component.html.HtmlSelectOneMenu;

import com.ibm.faces.component.html.HtmlCommandExButton;
import com.ibm.faces.component.html.HtmlJspPanel;
import com.ibm.faces.component.html.HtmlScriptCollector;
import com.springbank.service.core.BankingService;
import com.springbank.service.core.BusinessException;
import com.springbank.ui.bean.CustomerBean;

/**
 * @author is95592
 *
 */
public class AccountEdit extends PageCodeBase {

	protected HtmlScriptCollector scriptCollector1;
	protected HtmlMessages messages1;
	protected HtmlInputText accountNumber;
	protected HtmlForm form1;
	protected HtmlInputText accountBalance;
	protected HtmlCommandExButton saveBtn;
	protected HtmlCommandExButton cancelBtn;
	protected HtmlJspPanel jspPanel1;	
	protected HtmlSelectOneMenu transferAccountId;
	protected HtmlInputText transferAmount;
	protected HtmlCommandExButton sendBtn;
	protected CustomerBean customerBean;
	private BankingService bankingService;
	public void setBankingService(BankingService bankingService) {
		this.bankingService = bankingService;
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

	protected HtmlInputText getAccountNumber() {
		if (accountNumber == null) {
			accountNumber = (HtmlInputText) findComponentInRoot("accountNumber");
		}
		return accountNumber;
	}

	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	protected HtmlInputText getAccountBalance() {
		if (accountBalance == null) {
			accountBalance = (HtmlInputText) findComponentInRoot("accountBalance");
		}
		return accountBalance;
	}

	protected HtmlCommandExButton getSaveBtn() {
		if (saveBtn == null) {
			saveBtn = (HtmlCommandExButton) findComponentInRoot("saveBtn");
		}
		return saveBtn;
	}

	protected HtmlCommandExButton getCancelBtn() {
		if (cancelBtn == null) {
			cancelBtn = (HtmlCommandExButton) findComponentInRoot("cancelBtn");
		}
		return cancelBtn;
	}

	public String doCancelBtnAction() {
		// Type Java code that runs when the component is clicked
	
		// TODO: Return outcome that corresponds to a navigation rule
		return "back";

	}

	public String doSaveBtnAction() {
		// Type Java code that runs when the component is clicked
	
		// TODO: Return outcome that corresponds to a navigation rule
		long currentCustomerId = getCustomerBean().getCustomer().getCustomerId();
		bankingService.saveAccount(getCustomerBean().getAccount());
		getCustomerBean().setCustomer(bankingService.getCustomer(currentCustomerId));
		return "back";

	}

	protected HtmlJspPanel getJspPanel1() {
		if (jspPanel1 == null) {
			jspPanel1 = (HtmlJspPanel) findComponentInRoot("jspPanel1");
		}
		return jspPanel1;
	}

	protected HtmlSelectOneMenu getTransferAccountId() {
		if (transferAccountId == null) {
			transferAccountId = (HtmlSelectOneMenu) findComponentInRoot("transferAccountId");
		}
		return transferAccountId;
	}

	protected HtmlInputText getTransferAmount() {
		if (transferAmount == null) {
			transferAmount = (HtmlInputText) findComponentInRoot("transferAmount");
		}
		return transferAmount;
	}

	protected HtmlCommandExButton getSendBtn() {
		if (sendBtn == null) {
			sendBtn = (HtmlCommandExButton) findComponentInRoot("sendBtn");
		}
		return sendBtn;
	}

	public String doSendBtnAction() {
		// Type Java code that runs when the component is clicked
	
		// TODO: Return outcome that corresponds to a navigation rule
		long currentCustomerId = getCustomerBean().getCustomer().getCustomerId();
		long currentAccountId = getCustomerBean().getAccount().getAccountId();
		long transferAccountId = getCustomerBean().getTransferAccountId();
		double transferAmount =  getCustomerBean().getTransferAmount();		
		
		try {
			bankingService.transferMoney(currentAccountId, transferAccountId, transferAmount);
			getCustomerBean().setCustomer(bankingService.getCustomer(currentCustomerId));
			return "back";			
		} catch (BusinessException ex) {
			addMessage(ex.getMessage());
			return "";
		}		
	}

	/** 
	 * @managed-bean true
	 */
	protected CustomerBean getCustomerBean() {
		if (customerBean == null) {
			customerBean = (CustomerBean) getFacesContext().getApplication()
					.createValueBinding("#{customerBean}").getValue(
							getFacesContext());
		}
		return customerBean;
	}

	/** 
	 * @managed-bean true
	 */
	protected void setCustomerBean(CustomerBean customerBean) {
		this.customerBean = customerBean;
	}

}