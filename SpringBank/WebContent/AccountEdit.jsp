<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/AccountEdit.java" --%><%-- /jsf:pagecode --%>
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
	<body onload="$('form1:accountNumber').focus();">
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
								<td class="Caption">Account Number :</td>
								<td><h:inputText id="accountNumber" styleClass="inputText" size="25" value="#{customerBean.account.accountNumber}" required="true"></h:inputText><h:message
									for="accountNumber" styleClass="message"></h:message></td>
							</tr>
							<tr>
								<td class="Caption">Account Balance :</td>
								<td><h:inputText id="accountBalance" styleClass="inputText" size="25" value="#{customerBean.account.accountBalance}" required="true">

									<hx:convertNumber />
								</h:inputText><h:message for="accountBalance" styleClass="message"></h:message></td>
							</tr>
							<tr>
								<td></td>
								<td><hx:commandExButton type="submit" value="Save" id="saveBtn"
									styleClass="commandExButton" action="#{pc_AccountEdit.doSaveBtnAction}"></hx:commandExButton>&nbsp;<hx:commandExButton
									type="submit" value="Cancel" id="cancelBtn" styleClass="commandExButton" immediate="true" action="#{pc_AccountEdit.doCancelBtnAction}">
								</hx:commandExButton></td>
							</tr>
						</tbody>
					</table>
					<br>
					<br>
					<hx:jspPanel id="jspPanel1" rendered="#{customerBean.otherAccountsOfCustomerRendered}">
						<fieldset style="width: 350px;">
							<legend class="Caption">Money Transfer</legend>
						<table>
							<tbody>
								<tr>
									<td colspan="2"><h:message for="transferAmount" styleClass="message"></h:message></td>
								</tr>
								<tr>
									<td class="Caption">Account Number :</td>
									<td><h:selectOneMenu id="transferAccountId"
										styleClass="selectOneMenu" value="#{customerBean.transferAccountId}">
										<f:selectItems value="#{customerBean.otherAccountsOfCustomer}" />
									</h:selectOneMenu></td>
								</tr>
								<tr>
									<td class="Caption">Amount :</td>
									<td><h:inputText id="transferAmount" styleClass="inputText"
										size="25" required="true" value="#{customerBean.transferAmount}">

										
									</h:inputText></td>
								</tr>
								<tr>
									<td></td>
									<td><hx:commandExButton type="submit" value="Send" id="sendBtn"
										styleClass="commandExButton" action="#{pc_AccountEdit.doSendBtnAction}"></hx:commandExButton></td>
								</tr>
							</tbody>
						</table>						
						</fieldset>					
					</hx:jspPanel></td>
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
