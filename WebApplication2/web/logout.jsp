<%
session.setAttribute("userid", null);
session.invalidate();
response.sendRedirect("mainframe.html");
%>