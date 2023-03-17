/**
 * 
 */
package pagecode;

import javax.faces.component.UIParameter;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlMessages;
import javax.faces.component.html.HtmlOutputText;

import com.ibm.faces.component.UIColumnEx;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.ibm.faces.component.html.HtmlDataTableEx;
import com.ibm.faces.component.html.HtmlRequestLink;
import com.ibm.faces.component.html.HtmlScriptCollector;
import com.springbank.service.core.BankingService;
import com.springbank.ui.bean.CustomerBean;

/**
 * @author IS95592
 *
 */
public class CustomerEdit extends PageCodeBase {

	protected HtmlScriptCollector scriptCollector1;
	protected HtmlMessages messages1;
	protected HtmlInputText customerNumber;
	protected HtmlForm form1;
	protected HtmlInputText customerName;
	protected HtmlInputText customerSurname;
	protected HtmlInputText customerAddress;
	protected HtmlCommandExButton saveBtn;
	protected HtmlCommandExButton cancelBtn;
	protected CustomerBean customerBean;
	protected HtmlRequestLink link1;
	protected HtmlOutputText text1;
	protected HtmlInputText customerPassword;
	protected UIColumnEx columnEx1;
	protected HtmlOutputText text2;
	protected HtmlOutputText text3;
	protected HtmlDataTableEx tableEx1;
	protected HtmlOutputText textAccountNumber1;
	protected UIColumnEx columnEx2;
	protected HtmlOutputText textAccountBalance1;
	protected HtmlOutputText text4;
	protected UIColumnEx column1;
	protected HtmlOutputText text5;
	protected HtmlRequestLink link2;
	protected HtmlOutputText space;
	protected HtmlOutputText text6;
	protected HtmlRequestLink link3;
	protected UIParameter param1;
	protected UIParameter param2;
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
	protected HtmlInputText getCustomerNumber() {
		if (customerNumber == null) {
			customerNumber = (HtmlInputText) findComponentInRoot("customerNumber");
		}
		return customerNumber;
	}
	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}
	protected HtmlInputText getCustomerName() {
		if (customerName == null) {
			customerName = (HtmlInputText) findComponentInRoot("customerName");
		}
		return customerName;
	}
	protected HtmlInputText getCustomerSurname() {
		if (customerSurname == null) {
			customerSurname = (HtmlInputText) findComponentInRoot("customerSurname");
		}
		return customerSurname;
	}
	protected HtmlInputText getCustomerAddress() {
		if (customerAddress == null) {
			customerAddress = (HtmlInputText) findComponentInRoot("customerAddress");
		}
		return customerAddress;
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

	public String doCancelBtnAction() {
		// Type Java code that runs when the component is clicked
	
		// TODO: Return outcome that corresponds to a navigation rule
		return "customer"; // global 

	}
	public String doSaveBtnAction() {
		// Type Java code that runs when the component is clicked
	
		// TODO: Return outcome that corresponds to a navigation rule
		bankingService.saveCustomer(getCustomerBean().getCustomer());
		return "customer"; // global 

	}

	protected HtmlRequestLink getLink1() {
		if (link1 == null) {
			link1 = (HtmlRequestLink) findComponentInRoot("link1");
		}
		return link1;
	}

	protected HtmlOutputText getText1() {
		if (text1 == null) {
			text1 = (HtmlOutputText) findComponentInRoot("text1");
		}
		return text1;
	}

	protected HtmlInputText getCustomerPassword() {
		if (customerPassword == null) {
			customerPassword = (HtmlInputText) findComponentInRoot("customerPassword");
		}
		return customerPassword;
	}

	protected UIColumnEx getColumnEx1() {
		if (columnEx1 == null) {
			columnEx1 = (UIColumnEx) findComponentInRoot("columnEx1");
		}
		return columnEx1;
	}

	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
	}

	protected HtmlOutputText getText3() {
		if (text3 == null) {
			text3 = (HtmlOutputText) findComponentInRoot("text3");
		}
		return text3;
	}

	protected HtmlDataTableEx getTableEx1() {
		if (tableEx1 == null) {
			tableEx1 = (HtmlDataTableEx) findComponentInRoot("tableEx1");
		}
		return tableEx1;
	}

	protected HtmlOutputText getTextAccountNumber1() {
		if (textAccountNumber1 == null) {
			textAccountNumber1 = (HtmlOutputText) findComponentInRoot("textAccountNumber1");
		}
		return textAccountNumber1;
	}

	protected UIColumnEx getColumnEx2() {
		if (columnEx2 == null) {
			columnEx2 = (UIColumnEx) findComponentInRoot("columnEx2");
		}
		return columnEx2;
	}

	protected HtmlOutputText getTextAccountBalance1() {
		if (textAccountBalance1 == null) {
			textAccountBalance1 = (HtmlOutputText) findComponentInRoot("textAccountBalance1");
		}
		return textAccountBalance1;
	}

	protected HtmlOutputText getText4() {
		if (text4 == null) {
			text4 = (HtmlOutputText) findComponentInRoot("text4");
		}
		return text4;
	}

	protected UIColumnEx getColumn1() {
		if (column1 == null) {
			column1 = (UIColumnEx) findComponentInRoot("column1");
		}
		return column1;
	}

	protected HtmlOutputText getText5() {
		if (text5 == null) {
			text5 = (HtmlOutputText) findComponentInRoot("text5");
		}
		return text5;
	}

	protected HtmlRequestLink getLink2() {
		if (link2 == null) {
			link2 = (HtmlRequestLink) findComponentInRoot("link2");
		}
		return link2;
	}

	protected HtmlOutputText getSpace() {
		if (space == null) {
			space = (HtmlOutputText) findComponentInRoot("space");
		}
		return space;
	}

	protected HtmlOutputText getText6() {
		if (text6 == null) {
			text6 = (HtmlOutputText) findComponentInRoot("text6");
		}
		return text6;
	}

	protected HtmlRequestLink getLink3() {
		if (link3 == null) {
			link3 = (HtmlRequestLink) findComponentInRoot("link3");
		}
		return link3;
	}

	protected UIParameter getParam1() {
		if (param1 == null) {
			param1 = (UIParameter) findComponentInRoot("param1");
		}
		return param1;
	}

	protected UIParameter getParam2() {
		if (param2 == null) {
			param2 = (UIParameter) findComponentInRoot("param2");
		}
		return param2;
	}

	public String doLink3Action() {
		// Type Java code that runs when the component is clicked
	
		// TODO: Return outcome that corresponds to a navigation rule
		long currentAccountId = Long.parseLong(((String)getRequestParam().get("currentAccountId")));
		bankingService.removeAccount(currentAccountId);
		return "";
	}

	public String doLink2Action() {
		// Type Java code that runs when the component is clicked
	
		// TODO: Return outcome that corresponds to a navigation rule
		long currentCustomerId = getCustomerBean().getCustomer().getCustomerId();
		long currentAccountId = Long.parseLong(((String)getRequestParam().get("currentAccountId")));
		getCustomerBean().setAccount(bankingService.getAccount(currentAccountId));
		getCustomerBean().setOtherAccountsOfCustomer(bankingService.getOtherAccountsOfCustomer(currentAccountId, currentCustomerId));		
		getCustomerBean().resetTransfer();
		return "edit";
	}

	public String doLink1Action() {
		// Type Java code that runs when the component is clicked
	
		// TODO: Return outcome that corresponds to a navigation rule
		getCustomerBean().resetAccount();
		getCustomerBean().resetTransfer();
		return "edit";
	}

}