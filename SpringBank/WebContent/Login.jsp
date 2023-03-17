<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Login.java" --%><%-- /jsf:pagecode --%>
<%@page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<html>
<head>
<title>Spring Bank</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-9">
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1254">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/theme/Master.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/theme/stylesheet.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/util.js"></script>
</head>
<f:view>
	<body onload="$('form1:operatorAlias').focus();">
	<hx:scriptCollector id="scriptCollector1">
		<h:form id="form1" styleClass="form">
			<table width="940" height="100%" cellpadding="0" cellspacing="0"
				align="center" border="0">
				<tr height="80">
					<td class="Top" colspan="2">Spring Bank&nbsp;</td>
				</tr>
				<tr>
					<td width="12%" class="Middle-Left">&nbsp;</td>
					<td width="88%" class="Middle-Right" align="center">

					<table>
						<tbody>
							<tr>
								<td colspan="2" align="left"><h:messages id="messages1"
									styleClass="messages" globalOnly="true"></h:messages></td>
							</tr>
							<tr>
								<td class="Caption" aling="left">Kullanıcı Adı :</td>
								<td><h:inputText id="operatorAlias" styleClass="inputText" size="20" required="true" value="#{loginBean.operator.operatorAlias}"></h:inputText><h:message
									for="operatorAlias" styleClass="message"></h:message></td>
							</tr>
							<tr>
								<td class="Caption" align="left">Parola :</td>
								<td><h:inputSecret id="operatorPassword"
									styleClass="inputSecret" size="20" required="true" value="#{loginBean.operator.operatorPassword}"></h:inputSecret><h:message
									for="operatorPassword" styleClass="message"></h:message></td>
							</tr>
							<tr>
								<td></td>
								<td><hx:commandExButton type="submit" value="Login"
									id="loginBtn" styleClass="commandExButton" action="#{pc_Login.doLoginBtnAction}"></hx:commandExButton></td>
							</tr>
						</tbody>
					</table>
					</td>
				</tr>
				<tr height="30">
					<td class="Bottom" colspan="2">Copyright © 2009, Spring Bank Version 1.0</td>
				</tr>
			</table>
		</h:form>
	</hx:scriptCollector>
	</body>
</f:view>
</html>
