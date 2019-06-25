<%-- 
    Document   : r1
    Created on : 2 Nov, 2012, 10:37:15 PM
    Author     : Nested code
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%@ page language="java" %>
        <%@ page import="java.sql.*" %>
         <%@ page import="java.sql.DriverManager.*" %>
       
        <%
        String m=null, mn=null;
        String s=request.getParameter("name");
        String s1=request.getParameter("userid");
        String s2=request.getParameter("password");
        String s3=request.getParameter("male");
        String s4=request.getParameter("contact");
        PreparedStatement ps;
        Connection con;
        ResultSet rs= null;
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ru", "root", "");
      
         Statement st=con.createStatement();
       
          ps= con.prepareStatement("insert into register values (?,?,?,?,?)");
            ps.setString(1,s);
            ps.setString(2, s1);
            ps.setString(3,s2);
            ps.setString(4,s3);
            ps.setString(5,s4);
           
               int insertResult = ps.executeUpdate();
             if (insertResult!=0)
            {
                 out.println("Successfully registered");
               
            }
    
         
           
        %>
        <br><hr>
               To Login <a href="login.jsp">Click Here</a>
                <hr>
          
    </body>
</html>
