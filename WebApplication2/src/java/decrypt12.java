/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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


/**
 *
 * @author user
 */
@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class decrypt12 extends HttpServlet {
     
    
    String dbURL = "jdbc:mysql://localhost:3306/share1";
    String dbUser = "root";
    String dbPass = "";
    
    public static int kii=0;
    public static int [] pixels1=new int [500000];
    public static int [] pixels2=new int [500000];  
    
   

     protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,IOException {
    
          
     
        String userid=request.getParameter("userid"); 
        String password=request.getParameter("password"); 
        String sreg =request.getParameter("sreg"); 
        int x =Integer.parseInt(request.getParameter("sreg"));
       /* String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/share1";
        String userName = "root";
        String password1 = "";*/

        /*
	try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\" \"http://www.w3.org/TR/REC-html40/loose.dtd\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " +x+ "</h1>");
            
            
            out.println("</body>");
            out.println("</html>");
            }*/
        
                Connection con = null;
                String message = null;

          try{
                        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                        con = DriverManager.getConnection(dbURL, dbUser, dbPass);
                        /*Class.forName(driverName);
			con = DriverManager.getConnection(url,userName,password);*/
			Statement stmt = con.createStatement();
			
                        
                        ResultSet rs = stmt.executeQuery("select share2u from name where userid="+userid);
			while (rs.next()) {
                        InputStream in = rs.getBinaryStream(1);
			OutputStream f = new FileOutputStream(new File("E://share2.jpg"));
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
			OutputStream f1 = new FileOutputStream(new File("E://share1.jpg"));
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
			OutputStream f2 = new FileOutputStream(new File("E://share3.jpg"));
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
                                message12.rec2();
                                break;
                            case 3:
                                message12.rec3();
                                break;
                            default: break;
                        }
                        response.setContentType("image/jpeg");
                
                ServletOutputStream out2;
                out2 = response.getOutputStream();
                FileInputStream fin2 = new FileInputStream("E://output.jpg");

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
     /*
    public static void createImage(int[] pixels,int width,int height) throws IOException
    {           BufferedImage img100 = new   BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
                WritableRaster raster1 = img100.getRaster();
                raster1.setPixels(0, 0, width, height, pixels1);
                File outputFile1 = new File("E://output.jpg");
                ImageIO.write(img100, "jpg", outputFile1);
    }

    public static void rec2()
    {
        
        try {
      		File f4,f5;
                int n=3,k=2,a,b,l,m,i,j;
                Integer c=new Integer(9000000);
                String z="",z1="",z2="",z3="";
                f4 =new File("E:\\share111.jpg");
                BufferedImage image1;
                image1 = ImageIO.read(f4);
                int h1 = image1.getHeight();
                int w1 = image1.getWidth();

                f5 =new File("E:\\share112.jpg");
                BufferedImage image2;
                image2 = ImageIO.read(f5);
                int h2 = image2.getHeight();
                int w2 = image2.getWidth();
                for(l=0; l< w1 ;l++)
                {
                    for(m=0; m<h1 ;m++)
                    { 
                        c=image1.getRGB(l,m);                  //get each pixel value share1
                        z =Integer.toBinaryString(c);  
                        z1=z1+z;
                    }           
                }
                for(l=0; l< w2 ;l++)
                {
                    for(m=0; m< h2 ;  m++)
                    { 

                        c=image2.getRGB(l,m);                  //get each pixel value share2
                        z =Integer.toBinaryString(c);  
                        z2=z2+z;   
                    }
                }
                int x,y; 
                if (z1.length()>z2.length())
                { 
                    y=z1.length()-z2.length();
                    while(y!=0 && z1.length()!=z2.length())
                    {
                      z2=z2+"0";  
                      y--;
                    }
                    x=z1.length();
                }
                else
                    { 
                    y=z2.length()-z1.length();
                    while(y!=0 && z2.length()!=z1.length())
                    {
                      z1=z1+"0"; 
                      y--;
                    }
                     x=z2.length();
                } 

                z3="";
                l=0;
                while(l!=x)
                 {    
                    {
                     if(z1.charAt(l)=='1' && z2.charAt(l)=='1' ||z1.charAt(l)=='1' && z2.charAt(l)=='0' ||z1.charAt(l)=='0' && z2.charAt(l)=='1')
                     z3=z3+"1";
                     else
                     z3=z3+"0";
                    }

                    l++;
                 int len=0,q,ja=0,d;
                  y=x/32;
                 d=z3.length()-(y*32);
                   while(d%32!=0)
                    {
                      z3=z3+"0"; 
                      d++;
                    }
                 int r=y*32+d;
                 while(len!=r)
                 {
                           q =ja;
                           int B= Integer.parseInt(z3.substring(q, q+8), 2);
                           int G= Integer.parseInt(z3.substring(q+8,q+16), 2);
                           int R= Integer.parseInt(z3.substring(q+16,q+24), 2); 

                           int A= Integer.parseInt(z3.substring(q+24, q+32), 2);

                                pixels1[kii] =R;
                                pixels1[kii+1]=G;
                                pixels1[kii+2]=B;
                                pixels1[kii+3]=A;
                                kii = kii+4;

                                ja=ja+32;
                                len=len+32;
                 }        

                    createImage(pixels1,w1,h1);
            }
        }
            catch (IOException io)
            {
            } 
        }
public static void rec3()
             
  {
     try{
    File f4,f5,f6;
    int n=3,k=2,a,b,l,m,i,j;
     Integer c=new Integer(9000000);
     Integer c1=new Integer(9000000);
     Integer c2=new Integer(9000000);
    String z="",z1="",z2="",z3="",z4="",z0="",z00=""; 
f4 =new File("E://share111.jpg");
BufferedImage image1;
image1 = ImageIO.read(f4);
int h1 = image1.getHeight();
int w1 = image1.getWidth();

f5 =new File("E://share112.jpg");
BufferedImage image2;
image2 = ImageIO.read(f5);
int h2 = image2.getHeight();
int w2 = image2.getWidth();
f6 =new File("E://share113.jpg");
BufferedImage image3;
image3 = ImageIO.read(f6);
int h3 = image3.getHeight();
int w3 = image3.getWidth();

BufferedImage img1 = new BufferedImage(image1.getWidth(),image1.getHeight(), BufferedImage.TYPE_INT_ARGB); 

       for(l=0; l<w1 ;l++)
          {
             for(m=0; m<h1 ;m++) 

               { 
                     c=image1.getRGB(l,m);                  //get each pixel value share1
                     z =Integer.toBinaryString(c);  
                     z1=z1+z;
                     c1=image2.getRGB(l,m);                  //get each pixel value share2
                     z0 =Integer.toBinaryString(c1);  
                     z2=z2+z0; 
                     c2=image3.getRGB(l,m);                  //get each pixel value share2
                     z00 =Integer.toBinaryString(c2);  
                     z3=z3+z00; 
               }
             }
     int x,y; 
    if (z1.length()>z2.length())
    { 
        y=z1.length()-z2.length();
        while(y!=0 && z2.length()!=z1.length())
        {
          z2=z2+"0";  
          y--;
        }
        x=z1.length();
    }
    else
        { 
        y=z2.length()-z1.length();
        while(y!=0 && z1.length()!=z2.length())
        {
          z1=z1+"0"; 
          y--;
        }
         x=z2.length();
    }

   int x1,y1; 
    if (x>z3.length())
      { 
        y1=x-z3.length();
        while(y1!=0 && z3.length()!=x)
        {
          z3=z3+"0";  
          y1--;
        }
        x1=x;
      }
    else 
       { 
        y1=z3.length()-x;
        while(y1!=0 && x!=z3.length())
        {
          z1=z1+"0";
          z2=z2+"0"; 

          y1--;
          x++;
        }
        x1=z3.length();
       } 
    l=0;
    z4="";    
    while(l!=x1)      
    { 
      {
        if(z1.charAt(l)=='1' && z2.charAt(l)=='1' && z3.charAt(l)=='1'||z1.charAt(l)=='1' && z2.charAt(l)=='0' && z3.charAt(l)=='1' ||z1.charAt(l)=='0' && z2.charAt(l)=='1' && z3.charAt(l)=='1' ||z1.charAt(l)=='1' && z2.charAt(l)=='1' && z3.charAt(l)=='0'||z1.charAt(l)=='1' && z2.charAt(l)=='0' && z3.charAt(l)=='0'||z1.charAt(l)=='0' && z2.charAt(l)=='0' && z3.charAt(l)=='1'||z1.charAt(l)=='0' && z2.charAt(l)=='1' && z3.charAt(l)=='0')
          z4=z4+1;
         else
          z4=z4+0;   }
        l++;
    }
    int y4=x1/32;
    int d=z4.length()-(y4*32);
          while(d%32!=0)
        {
          z4=z4+"0"; 
          d++;
        }
     int r=y4*32+d;
     int len=0,ja=0;
     kii=0;
     while(len!=r)
     {        int q =ja;
               int B= Integer.parseInt(z4.substring(q, q+8), 2);
               int G= Integer.parseInt(z4.substring(q+8, q+16), 2);
               int R= Integer.parseInt(z4.substring(q+16, q+24), 2);
               int A= Integer.parseInt(z4.substring(q+24, q+32), 2);
                    pixels1[kii] =R;
                    pixels1[kii+1] =G;
                     pixels1[kii+2] =B;
                     pixels1[kii+3] =A;
                    kii = kii+4;
        ja=ja+32;
                    len=len+32;
     }        
            createImage(pixels1,w1,h1);
}
catch (IOException io)
   {
   }
}

*/
}
        

