/**
 * 
 */
package pagecode;

import javax.faces.component.UIParameter;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;

import org.springframework.ws.client.core.WebServiceTemplate;

import com.ibm.faces.component.UIColumnEx;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.ibm.faces.component.html.HtmlDataTableEx;
import com.ibm.faces.component.html.HtmlRequestLink;
import com.ibm.faces.component.html.HtmlScriptCollector;
import com.springbank.service.core.BankingService;
import com.springbank.service.ws.schema.SearchCustomerRequest;
import com.springbank.service.ws.schema.SearchCustomerResponse;
import com.springbank.ui.bean.CustomerBean;

/**
 * @author IS95592
 *
 */
public class CustomerList extends PageCodeBase {

	protected HtmlScriptCollector scriptCollector1;
	protected HtmlForm form1;
	protected HtmlRequestLink link1;
	protected HtmlOutputText text1;
	protected UIColumnEx columnEx1;
	protected HtmlOutputText text2;
	protected HtmlOutputText text3;
	protected HtmlOutputText text4;
	protected HtmlOutputText text5;
	protected HtmlDataTableEx tableEx1;
	protected HtmlOutputText textCustomerNumber1;
	protected UIColumnEx columnEx2;
	protected HtmlOutputText textCustomerName1;
	protected UIColumnEx columnEx3;
	protected HtmlOutputText textCustomerSurname1;
	protected UIColumnEx columnEx4;
	protected HtmlOutputText textCustomerAddress1;
	protected HtmlOutputText text6;
	protected UIColumnEx column1;
	protected HtmlOutputText text7;
	protected HtmlRequestLink link2;
	protected HtmlOutputText text8;
	protected HtmlRequestLink link3;
	protected UIParameter param1;
	protected UIParameter param2;
	protected HtmlOutputText space;
	protected HtmlInputText customerNumber;
	protected HtmlCommandExButton searchBtn;	
	protected CustomerBean customerBean;
	private BankingService bankingService;
	private WebServiceTemplate webServiceTemplate;
	public void setBankingService(BankingService bankingService) {
		this.bankingService = bankingService;
	}
	public void setWebServiceTemplate(WebServiceTemplate webServiceTemplate) {
		this.webServiceTemplate = webServiceTemplate; 
	}	

	protected HtmlScriptCollector getScriptCollector1() {
		if (scriptCollector1 == null) {
			scriptCollector1 = (HtmlScriptCollector) findComponentInRoot("scriptCollector1");
		}
		return scriptCollector1;
	}

	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
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

	protected HtmlOutputText getText4() {
		if (text4 == null) {
			text4 = (HtmlOutputText) findComponentInRoot("text4");
		}
		return text4;
	}

	protected HtmlOutputText getText5() {
		if (text5 == null) {
			text5 = (HtmlOutputText) findComponentInRoot("text5");
		}
		return text5;
	}

	protected HtmlDataTableEx getTableEx1() {
		if (tableEx1 == null) {
			tableEx1 = (HtmlDataTableEx) findComponentInRoot("tableEx1");
		}
		return tableEx1;
	}

	protected HtmlOutputText getTextCustomerNumber1() {
		if (textCustomerNumber1 == null) {
			textCustomerNumber1 = (HtmlOutputText) findComponentInRoot("textCustomerNumber1");
		}
		return textCustomerNumber1;
	}

	protected UIColumnEx getColumnEx2() {
		if (columnEx2 == null) {
			columnEx2 = (UIColumnEx) findComponentInRoot("columnEx2");
		}
		return columnEx2;
	}

	protected HtmlOutputText getTextCustomerName1() {
		if (textCustomerName1 == null) {
			textCustomerName1 = (HtmlOutputText) findComponentInRoot("textCustomerName1");
		}
		return textCustomerName1;
	}

	protected UIColumnEx getColumnEx3() {
		if (columnEx3 == null) {
			columnEx3 = (UIColumnEx) findComponentInRoot("columnEx3");
		}
		return columnEx3;
	}

	protected HtmlOutputText getTextCustomerSurname1() {
		if (textCustomerSurname1 == null) {
			textCustomerSurname1 = (HtmlOutputText) findComponentInRoot("textCustomerSurname1");
		}
		return textCustomerSurname1;
	}

	protected UIColumnEx getColumnEx4() {
		if (columnEx4 == null) {
			columnEx4 = (UIColumnEx) findComponentInRoot("columnEx4");
		}
		return columnEx4;
	}

	protected HtmlOutputText getTextCustomerAddress1() {
		if (textCustomerAddress1 == null) {
			textCustomerAddress1 = (HtmlOutputText) findComponentInRoot("textCustomerAddress1");
		}
		return textCustomerAddress1;
	}

	protected HtmlOutputText getText6() {
		if (text6 == null) {
			text6 = (HtmlOutputText) findComponentInRoot("text6");
		}
		return text6;
	}

	protected UIColumnEx getColumn1() {
		if (column1 == null) {
			column1 = (UIColumnEx) findComponentInRoot("column1");
		}
		return column1;
	}

	public void onPageLoadBegin(FacesContext facescontext) {
		// Type Java code to handle page load begin event here
		getCustomerBean().setCustomers(bankingService.getCustomerList());
	}

	public String doLink1Action() {
		// Type Java code that runs when the component is clicked
	
		// TODO: Return outcome that corresponds to a navigation rule
		getCustomerBean().resetCustomer();
		return "edit";
	}

	protected HtmlOutputText getText7() {
		if (text7 == null) {
			text7 = (HtmlOutputText) findComponentInRoot("text7");
		}
		return text7;
	}

	protected HtmlRequestLink getLink2() {
		if (link2 == null) {
			link2 = (HtmlRequestLink) findComponentInRoot("link2");
		}
		return link2;
	}

	protected HtmlOutputText getText8() {
		if (text8 == null) {
			text8 = (HtmlOutputText) findComponentInRoot("text8");
		}
		return text8;
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

	protected HtmlOutputText getSpace() {
		if (space == null) {
			space = (HtmlOutputText) findComponentInRoot("space");
		}
		return space;
	}

	public String doLink2Action() {
		// Type Java code that runs when the component is clicked
	
		// TODO: Return outcome that corresponds to a navigation rule
		long currentCustomerId = Long.parseLong(((String)getRequestParam().get("currentCustomerId")));
		getCustomerBean().setCustomer(bankingService.getCustomer(currentCustomerId));		
		return "edit";		 
	}

	public String doLink3Action() {
		// Type Java code that runs when the component is clicked
	
		// TODO: Return outcome that corresponds to a navigation rule
		long currentCustomerId = Long.parseLong(((String)getRequestParam().get("currentCustomerId")));
		bankingService.removeCustomer(currentCustomerId);
		return "";
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
	protected HtmlInputText getCustomerNumber() {
		if (customerNumber == null) {
			customerNumber = (HtmlInputText) findComponentInRoot("customerNumber");
		}
		return customerNumber;
	}
	protected HtmlCommandExButton getSearchBtn() {
		if (searchBtn == null) {
			searchBtn = (HtmlCommandExButton) findComponentInRoot("searchBtn");
		}
		return searchBtn;
	}
	public String doSearchBtnAction() {
		// Type Java code that runs when the component is clicked
	
		// TODO: Return outcome that corresponds to a navigation rule
		SearchCustomerRequest searchCustomerRequest = new SearchCustomerRequest();
		searchCustomerRequest.setCustomerNumber(getCustomerNumber().getValue().toString());
		try {
			SearchCustomerResponse searchCustomerResponse = (SearchCustomerResponse)webServiceTemplate.marshalSendAndReceive(searchCustomerRequest);
			getCustomerBean().setCustomer(searchCustomerResponse.getCustomer());
			return "edit";			
		} catch (Exception ex) {
			return "";
		}
	}

}