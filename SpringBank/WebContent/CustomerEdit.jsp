<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/CustomerEdit.java" --%><%-- /jsf:pagecode --%>
<%@page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<html>
<head>
<title>Spring Bank</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-9">
<meta http-equiv="Content-Type"	content="text/html; charset=windows-1254">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/theme/Master.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/theme/stylesheet.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/util.js"></script>
<link rel="stylesheet" type="text/css" href="theme/stylesheet.css"
	title="Style">
</head>
<f:view>
	<body onload="$('form1:customerNumber').focus();">
	<hx:scriptCollector id="scriptCollector1">
		<h:form id="form1" styleClass="form">
			<table width="940" height="100%" cellpadding="0" cellspacing="0"
				align="center" border="0">
				<tr height="80">
					<td class="Top" colspan="2">Spring Bank&nbsp;</td>
				</tr>
				<tr>
					<td width="12%" class="Middle-Left"><%@include
						file="Menu.jspf"%></td>
					<td width="88%" class="Middle-Right">
					<table>
						<tbody>
							<tr>
								<td colspan="2"><h:messages id="messages1"
									styleClass="messages" globalOnly="true"></h:messages></td>
							</tr>
							<tr>
								<td class="Caption">Customer Number :</td>
								<td><h:inputText id="customerNumber" styleClass="inputText"
									value="#{customerBean.customer.customerNumber}" size="25" required="true"></h:inputText><h:message
									for="customerNumber" styleClass="message"></h:message></td>
							</tr>
							<tr>
								<td class="Caption">Customer Password :</td>
								<td><h:inputText id="customerPassword"
									styleClass="inputText"
									value="#{customerBean.customer.customerPassword}" size="25" required="true"></h:inputText><h:message
									for="customerPassword" styleClass="message"></h:message></td>
							</tr>
							<tr>
								<td class="Caption">Customer Name :</td>
								<td><h:inputText id="customerName" styleClass="inputText"
									value="#{customerBean.customer.customerName}" size="25" required="true"></h:inputText><h:message
									for="customerName" styleClass="message"></h:message></td>
							</tr>
							<tr>
								<td class="Caption">Customer Surname :</td>
								<td><h:inputText id="customerSurname" styleClass="inputText"
									value="#{customerBean.customer.customerSurname}" size="25" required="true"></h:inputText><h:message
									for="customerSurname" styleClass="message"></h:message></td>
							</tr>
							<tr>
								<td class="Caption">Customer Address :</td>
								<td><h:inputText id="customerAddress" styleClass="inputText"
									value="#{customerBean.customer.customerAddress}" size="50" required="true"></h:inputText><h:message
									for="customerAddress" styleClass="message"></h:message></td>
							</tr>
							<tr>
								<td></td>
								<td><hx:commandExButton type="submit" value="Save" id="saveBtn"
									styleClass="commandExButton" action="#{pc_CustomerEdit.doSaveBtnAction}"></hx:commandExButton>&nbsp;<hx:commandExButton
									type="submit" value="Cancel" id="cancelBtn"
									styleClass="commandExButton" immediate="true" action="#{pc_CustomerEdit.doCancelBtnAction}"></hx:commandExButton></td>
							</tr>
						</tbody>
					</table>
					<br>
					<br>
					<hx:requestLink id="link1" styleClass="requestLink" rendered="#{customerBean.customer.customerId != 0}" action="#{pc_CustomerEdit.doLink1Action}">
						<h:outputText id="text1" styleClass="outputText"
							value="Add Account"></h:outputText>
					</hx:requestLink>
					<br>
					<br>
					<hx:dataTableEx id="tableEx1" value="#{customerBean.accounts}"
						var="varaccounts" rendered="#{customerBean.accountsRendered}"
						styleClass="List" headerClass="Header" footerClass="Footer"
						columnClasses="Line" border="0" cellpadding="2" cellspacing="0">
						<hx:columnEx id="columnEx1">
							<f:facet name="header">
								<h:outputText styleClass="outputText" value="Account Number"
									id="text2"></h:outputText>
							</f:facet>
							<h:outputText id="textAccountNumber1"
								value="#{varaccounts.accountNumber}" styleClass="outputText">
							</h:outputText>
						</hx:columnEx>
						<hx:columnEx id="columnEx2">
							<f:facet name="header">
								<h:outputText styleClass="outputText" value="Account Balance"
									id="text3"></h:outputText>
							</f:facet>
							<h:outputText id="textAccountBalance1"
								value="#{varaccounts.accountBalance}" styleClass="outputText">
							</h:outputText>
						</hx:columnEx>
						<hx:columnEx id="column1">
							<f:facet name="header">
								<h:outputText id="text4" styleClass="outputText" value="Action"></h:outputText>
							</f:facet>
							<hx:requestLink id="link2" styleClass="requestLink"
								action="#{pc_CustomerEdit.doLink2Action}">
								<h:outputText id="text5" styleClass="outputText" value="Edit"></h:outputText>
								<f:param name="currentAccountId" id="param1"
									value="#{varaccounts.accountId}"></f:param>
							</hx:requestLink>
							<h:outputText id="space" value="  " styleClass="outputText"></h:outputText>
							<hx:requestLink id="link3" styleClass="requestLink"
								onclick="return window.confirm('Are you sure to remove this record ?');" action="#{pc_CustomerEdit.doLink3Action}">
								<h:outputText id="text6" styleClass="outputText" value="Remove"></h:outputText>
								<f:param id="param2" value="#{varaccounts.accountId}"
									name="currentAccountId"></f:param>
							</hx:requestLink>
						</hx:columnEx>
					</hx:dataTableEx>
</td>
				</tr>
				<tr height="30">
					<td class="Bottom" colspan="2">Copyright © 2009, Spring Bank
					Version 1.0</td>
				</tr>
			</table>
		</h:form>
	</hx:scriptCollector>
	</body>
</f:view>
</html>
