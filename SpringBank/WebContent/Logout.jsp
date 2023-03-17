<%
session.removeAttribute("loginData");
session.invalidate();
response.sendRedirect(request.getContextPath());
%>	
