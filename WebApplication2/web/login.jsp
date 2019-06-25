<%@ page import ="java.sql.*" %>
<%
    String userid = request.getParameter("userid");    
    String password = request.getParameter("password");
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/share1","root",""); 

    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from name where userid='" + userid + "' and password='" + password + "'");
    if (rs.next()) {
        session.setAttribute("userid", userid);
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        response.sendRedirect("success.jsp");
    } else {
        out.println("Invalid password <a href='Loginn.html'>try again</a>");
    }
%>