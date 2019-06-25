<%@page import="java.io.InputStream"%>
<%@page import="java.sql.DriverManager"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%
            try {
                System.out.println("inside jsp try");
                String userid=request.getParameter("userid");
                Class.forName("com.mysql.jdbc.Driver"); 
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/share1","root",""); 
Statement st= con.createStatement(); 
ResultSet rs; 
String sql;
                sql="select image from name where userid="+userid;
                System.out.println("sql----"+sql);
                rs = st.executeQuery(sql);
                //rs = st.executeQuery("select image from demoimage where id='1'");
                String imgLen = "";
                while (rs.next()) {
                    imgLen = rs.getString(1);
                    System.out.println(imgLen.length());
                    int len = imgLen.length();
                    byte[] rb = new byte[len];
                    InputStream readImg = rs.getBinaryStream(1);
                    int index = readImg.read(rb, 0, len);
                    System.out.println("Index.........." + index);
 
                    response.reset();
                    response.setContentType("image/jpg");
                    response.getOutputStream().write(rb, 0, len);
                    response.getOutputStream().flush();
                }
                st.close();
 
                //  response.getContentType();
            } catch (Exception e) {
                System.out.println("Error" + e);
            }
 
        %>