<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9" isErrorPage="true"%>
<html>
<head>
<title>Spring Bank</title>
 <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-9">
 <meta http-equiv="Content-Type" content="text/html; charset=windows-1254">
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/theme/Master.css">  
</head>
<body>
<table width="940" height="100%" cellpadding="0" cellspacing="0" align="center" border="0">
	<tr height="80">
		<td class="Top" colspan="2">Spring Bank&nbsp;</td>
	</tr>
	<tr>
	 <td width="12%" class="Middle-Left">&nbsp;</td>
	 <td width="88%" class="Middle-Right" align="center">
	   <% 
	      java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss" );
	      String time = formatter.format(java.util.Calendar.getInstance().getTime());
	   	  System.err.println("***********   SYSTEM MESSAGE   ***********");
		  System.err.println(time + " : " + exception.getMessage());
		  System.err.println("******************************************");
	   %>
	   <font color="#FF0000">System error. Please try agin later ...</font><br><br>
	   <a href="javascript:history.back()">Back</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/Logout.jsp">Exit</a>
	 </td>
	</tr>
	<tr height="30">
		<td class="Bottom" colspan="2">Copyright © 2009, Spring Bank Version 1.0</td>
	</tr>
</table>
</body>
</html>