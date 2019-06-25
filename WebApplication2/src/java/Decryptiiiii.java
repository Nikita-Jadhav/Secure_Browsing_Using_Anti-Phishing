import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import javax.imageio.ImageIO;
import java.lang.Integer.*;
import java.util.Scanner;
import java.util.Random;
import java.text.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletOutputStream;

import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import java.io.*;
import java.sql.Date;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class Decryptiiiii extends HttpServlet {
     
    
    String dbURL = "jdbc:mysql://localhost:3306/share1";
    String dbUser = "root";
    String dbPass = "";
    
    public static int kii=0;
    public static int [] pixels1=new int [9000000];
    public static int [] pixels2=new int [9000000];    
    public static int [] rgb1=new int[9000000];
    public static BufferedImage img10;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,IOException 
    {
        String userid=request.getParameter("userid"); 
        String password=request.getParameter("password"); 
        String sreg =request.getParameter("sreg"); 
        int x =Integer.parseInt(request.getParameter("sreg"));
        
        Connection con = null;
        String message = null;

        try
        {
                        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                        con = DriverManager.getConnection(dbURL, dbUser, dbPass);
                        /*Class.forName(driverName);
			con = DriverManager.getConnection(url,userName,password);*/
			Statement stmt = con.createStatement();
			
                        
                        ResultSet rs = stmt.executeQuery("select share2u from name where userid="+userid);
			while (rs.next()) {
                        InputStream in = rs.getBinaryStream(1);
			OutputStream f = new FileOutputStream(new File("D://share112.jpg"));
			int c = 0;
				while ((c = in.read()) > -1) {
					f.write(c);
				}
			f.close();
			in.close();
                        }
                        ResultSet rs1 = stmt.executeQuery("select share1ser from server where userid="+userid);
			while (rs1.next()) {
                        InputStream in1 = rs1.getBinaryStream(1);
			OutputStream f1 = new FileOutputStream(new File("D://share111.jpg"));
			 int c = 0;
				while ((c = in1.read()) > -1) {
					f1.write(c);
				}
			f1.close();
			in1.close();
                        }
                        ResultSet rs2 = stmt.executeQuery("select share3ser from server where userid="+userid);
			while (rs2.next()) {
                            
                        InputStream in2 = rs2.getBinaryStream(1);
			OutputStream f2 = new FileOutputStream(new File("D://share113.jpg"));
			int c = 0;
				while ((c = in2.read()) > -1) {
					f2.write(c);
                                         
				}
                                
			f2.close();
			in2.close();
                        }
                        switch(x)
                        {
                            case 1:
                                System.out.println("Invalid input");
                                break;
                            case 2:
                                message11.rec2();
                                break;
                            case 3:
                                message11.rec3();
                                break;
                            default: break;
                        }
                        response.setContentType("image/jpeg");
                
                ServletOutputStream out2;
                out2 = response.getOutputStream();
                FileInputStream fin2 = new FileInputStream("D://output.jpg");

                BufferedInputStream bin2 = new BufferedInputStream(fin2);
                BufferedOutputStream bout2 = new BufferedOutputStream(out2);
                int ch2 =0; ;
                while((ch2=bin2.read())!=-1)
                {
                bout2.write(ch2);
             
                }
                
                bin2.close();
                fin2.close();
                bout2.close();
                out2.close();
	
                 /*response.setContentType("text/html");

                // New location to be redirected
                String site = new String("http://www.gmail.com");

                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", site); */
		}
                catch (SQLException ex)
                {
                    message = "ERROR: " + ex.getMessage();
                    ex.printStackTrace();
                } 
           
                finally 
                {
            
                    if (con != null) 
                    {
                        // closes the database connection
                        try 
                        {
                            con.close();
                        } 
                        catch (SQLException ex) 
                        {
                            ex.printStackTrace();
                        }//END OF SUB CATCH
                    }//END OF IF
                }//END OF FINALLY
           
          
    }


    }