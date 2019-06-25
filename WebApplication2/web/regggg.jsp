<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%
String name=request.getParameter("name");
String userid=request.getParameter("userid"); 
session.putValue("userid",userid); 
String password=request.getParameter("password"); 
String male=request.getParameter("male"); 
String contact=request.getParameter("contact"); 
String image=request.getParameter("image"); 
Class.forName("com.mysql.jdbc.Driver"); 
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/share1","root",""); 
Statement st= con.createStatement(); 
ResultSet rs; 
int i = st.executeUpdate("insert into name values ('"+name+"','"+userid+"','"+password+"','"+male+"','"+contact+"','"+image+"')"); 
out.println("Registered Successfully");
out.println("<a href='mainframe.html'>HOME</a>");

%>