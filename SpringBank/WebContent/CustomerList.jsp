<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/CustomerList.java" --%><%-- /jsf:pagecode --%>
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
	<hx:scriptCollector id="scriptCollector1" preRender="#{pc_CustomerList.onPageLoadBegin}">
		<h:form id="form1" styleClass="form">
			<table width="940" height="100%" cellpadding="0" cellspacing="0"
				align="center" border="0">
				<tr height="80">
					<td class="Top" colspan="2">Spring Bank&nbsp;</td>
				</tr>
				<tr>
					<td width="12%" class="Middle-Left"><%@include
						file="Menu.jspf"%></td>
					<td width="88%" class="Middle-Right"><table>
						<tbody>
							<tr>
								<td class="Caption">Customer Number :</td>
								<td>&nbsp;<h:inputText id="customerNumber" styleClass="inputText" size="25"></h:inputText></td>
								<td>&nbsp;<hx:commandExButton type="submit" value="SearchWS"
									id="searchBtn" styleClass="commandExButton" action="#{pc_CustomerList.doSearchBtnAction}"></hx:commandExButton></td>
							</tr>
						</tbody>
					</table>
					<br>
					<hx:requestLink id="link1"
						styleClass="requestLink" action="#{pc_CustomerList.doLink1Action}">
						<h:outputText id="text1" styleClass="outputText"
							value="Add Customer"></h:outputText>
					</hx:requestLink><br>
					<br>
					<hx:dataTableEx id="tableEx1" value="#{customerBean.customers}"
						var="varcustomers" rendered="#{customerBean.customersRendered}" styleClass="List" headerClass="Header"
						footerClass="Footer" columnClasses="Line" border="0"
						cellpadding="2" cellspacing="0" width="600">
						<hx:columnEx id="columnEx1">
							<f:facet name="header">
								<h:outputText styleClass="outputText" value="Customer Number"
									id="text2"></h:outputText>
							</f:facet>
							<h:outputText id="textCustomerNumber1"
								value="#{varcustomers.customerNumber}" styleClass="outputText">
							</h:outputText>
						</hx:columnEx>
						<hx:columnEx id="columnEx2">
							<f:facet name="header">
								<h:outputText styleClass="outputText" value="Customer Name"
									id="text3"></h:outputText>
							</f:facet>
							<h:outputText id="textCustomerName1"
								value="#{varcustomers.customerName}" styleClass="outputText">
							</h:outputText>
						</hx:columnEx>
						<hx:columnEx id="columnEx3">
							<f:facet name="header">
								<h:outputText styleClass="outputText" value="Customer Surname"
									id="text4"></h:outputText>
							</f:facet>
							<h:outputText id="textCustomerSurname1"
								value="#{varcustomers.customerSurname}" styleClass="outputText">
							</h:outputText>
						</hx:columnEx>
						<hx:columnEx id="columnEx4">
							<f:facet name="header">
								<h:outputText styleClass="outputText" value="Customer Address"
									id="text5"></h:outputText>
							</f:facet>
							<h:outputText id="textCustomerAddress1"
								value="#{varcustomers.customerAddress}" styleClass="outputText">
							</h:outputText>
						</hx:columnEx>
						<hx:columnEx id="column1">
							<f:facet name="header">
								<h:outputText id="text6" styleClass="outputText" value="Action"></h:outputText>
							</f:facet>
							<hx:requestLink id="link2" styleClass="requestLink" action="#{pc_CustomerList.doLink2Action}">
								<h:outputText id="text7" styleClass="outputText" value="Edit"></h:outputText>
								<f:param name="currentCustomerId" id="param1"
									value="#{varcustomers.customerId}"></f:param>
							</hx:requestLink>
							<h:outputText id="space" value="  " styleClass="outputText"></h:outputText>
							<hx:requestLink id="link3" styleClass="requestLink" onclick="return window.confirm('Are you sure to remove this record ?');" action="#{pc_CustomerList.doLink3Action}">
								<h:outputText id="text8" styleClass="outputText" value="Remove"></h:outputText>
								<f:param name="currentCustomerId" id="param2"
									value="#{varcustomers.customerId}"></f:param>
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
