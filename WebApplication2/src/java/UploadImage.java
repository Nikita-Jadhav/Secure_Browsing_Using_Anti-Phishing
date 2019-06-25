
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javax.imageio.ImageIO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class UploadImage extends HttpServlet {
     
    // database connection settings
     String dbURL = "jdbc:mysql://localhost:3306/share1";
    String dbUser = "root";
    String dbPass = "";
     
    public static int[][][] img_share;        // to store the pixels of 3 number of shares 
    public static int po=0,ki1=0,ki2=0,ki3=0;

    public static int ja=0;
    public static BufferedImage img1,img2,img3;

    public static int [] pixels1=new int[500000];
    public static int [] pixels2=new int[500000];
    public static int [] pixels3=new int[500000];

 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
         
        InputStream inputStream = null; // input stream of the upload file
        //Image image1 = null;
        String name=request.getParameter("name");
        String userid=request.getParameter("userid"); 
        String password=request.getParameter("password"); 
        String male=request.getParameter("male"); 
        String contact=request.getParameter("contact"); 
        String image=request.getParameter("image"); 
        /*try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\" \"http://www.w3.org/TR/REC-html40/loose.dtd\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " +userid + "</h1>");
            
            
            out.println("</body>");
            out.println("</html>");
            }*/
        String message1 = null;
        String message2 = null;
        String message3 = null;
         
       // inputStream = new BufferedInputStream( new FileInputStream("image"));
        //image1 = image1;
        
        File f,f1,f2,f3;
        int n=3,k=2,rec=2,m,s=0,i,e,j,h,c,P;  //declare n=no of shares, r=for reconstruction
        int k1,k2,k4 =0,k3;
        String b="";
        String val;

        String sid="";
        int[] rand=new int[3];
        int height=0,width=0;
        FileInputStream inputStream1 = null,inputStream2= null,inputStream3= null,inputStream4= null,imguser=null,imgser=null,share2u=null,share1ser=null,share3ser=null; 
        img_share=new int[3][300 * 300][100]; 
        
        
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("image");
        
        inputStream = new BufferedInputStream ( filePart.getInputStream() );
        BufferedImage image1 = ImageIO.read ( inputStream );
       
          
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
             width = image1.getWidth();        
              height = image1.getHeight();
              
        //        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        /*    out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\" \"http://www.w3.org/TR/REC-html40/loose.dtd\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet NewServlet at " + message + "</h1>");
            out.println("<h1>Servlet NewServlet at " + height + "</h1>");
             out.println("<h1>Servlet NewServlet at " + width + "</h1>");
            out.println("</body>");
            out.println("</html>");
            }*/
        
           
        }
        img1 = new BufferedImage(image1.getWidth(),image1.getHeight(), BufferedImage.TYPE_INT_ARGB); 
        img2 = new BufferedImage(image1.getWidth(),image1.getHeight(), BufferedImage.TYPE_INT_ARGB); 
        img3 = new BufferedImage(image1.getWidth(),image1.getHeight(), BufferedImage.TYPE_INT_ARGB);         

        rec=2;
               
                for(i=0;i<width;i++)
                        {
                         for(j=0;j<height;j++)
                         {  
                           Integer a=new Integer(900000000);
                           a=image1.getRGB(i,j);                  //get each pixel value
                           b =Integer.toBinaryString(a);         //convert to binary 
                            for(h=0;h<32;h++)
                            {
                            if(b.charAt(h)=='1')      //ith position of PIX contains â€˜1â€™
                            { 
                               rand= Random_Place(3,2);  //call rand fn
                               imgshare(h,rand,i,j);
                            }  

                         }
                        }
                       }

                for(k1=0;k1<3;k1++)
                {
                   val="";
                   System.out.println("imgshare");

                   for(k2=0;k2<width;k2++)
                   {
                     for(k4=0;k4<height;k4++)
                       {    
                        for(k3=0;k3<32;k3++)
                       {    
                           val=val+img_share[k1][k2*k4][k3];   
                       }
                        argb(val,k2,k4,k1);     
                     }
                   }
                   System.out.println("val"+val);
                   System.out.println("value"+val.length());
                switch(k1)
                {
                 case 0:
                       createImage(pixels1,width,height,k1);
                       System.out.println("ki1"+ki1);
                       File outputFile1 = new File("E://outshare111.jpg");
                       ImageIO.write(img1, "jpg", outputFile1);
                       inputStream2=share1ser= new FileInputStream(outputFile1);
                       {
                        po=0;
                        ja=0;
                       } 
                       break;
                 case 1:
                       createImage(pixels2,width,height,k1);
                       System.out.println("ki2"+ki2);
                       File outputFile2 = new File("E://outshare112.jpg");
                       ImageIO.write(img2, "jpg", outputFile2);
                       inputStream3=share2u= new FileInputStream(outputFile2);
                       {
                        po=0;
                        ja=0;
                       }  
                       break;
                 case 2:
                       createImage(pixels3,width,height,k1);
                       System.out.println("ki3"+ki3);
                       File outputFile3 = new File("E://outshare113.jpg");
                       ImageIO.write(img3, "jpg", outputFile3);
                       inputStream4=share3ser= new FileInputStream(outputFile3);
                       break;
                 default: break;
                } //end switch write img
                } // end k1 for loop
         
        Connection conn = null; // connection to the database
        String message = null;  // message will be sent back to client
         
        try {
            // connects to the database
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
 
            Statement st= conn.createStatement(); 
            //ResultSet rs; 
            
            // constructs SQL statement
            String sql = "INSERT INTO name (name,userid,password,male,contact,image,share2u) values (?,?,?,?,?,?,?)";
            //String sql1 = "INSERT INTO name(share2u) values (?)";
            String sql2 = "INSERT INTO server(sid,userid,share1ser,share3ser) values (?,?,?,?)";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            //PreparedStatement statement1 = conn.prepareStatement(sql1);
            PreparedStatement statement2 = conn.prepareStatement(sql2);
            
             if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setString(1, name);
                statement.setString(2, userid);
                statement.setString(3, password);
                statement.setString(4, male);
                statement.setString(5, contact);
                statement.setBlob(6, inputStream);
                statement.setBlob(7,share2u);
            }
            
           // statement1.setBlob(7,share2u);
           // int row2 = statement1.executeUpdate();

                   
            statement2.setString(1,sid);
            statement2.setString(2,userid);
            statement2.setBlob(3,share1ser);
            statement2.setBlob(4,share3ser);
            int row3 = statement2.executeUpdate();
            //int i = st.executeUpdate("insert into name values ('"+name+"','"+userid+"','"+password+"','"+male+"','"+contact+"','"+image+"')"); 
            //System.out.println("Registered Successfully"); 
           // response.getWriter().println("File uploaded and saved into database........");
            // sends the statement to the database server
            
            int row = statement.executeUpdate();
            if (row > 0  && row3>0) {
                
            message = "File uploaded and saved into database & server updated";
                response.setContentType("image/jpeg");
                
                ServletOutputStream out2;
                out2 = response.getOutputStream();
                FileInputStream fin2 = new FileInputStream("E://outshare112.jpg");

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
	
                
            }
    

           
        }
            catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
              
           
             
            //Encryption code starts...
                
            
            
     // sets the message in request scope
                request.setAttribute("Message", message);
                request.setAttribute("Message1", message1);
                request.setAttribute("Message2", message2);
            // forwards to the message page
            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
            getServletContext().getRequestDispatcher("/Message1.jsp").forward(request, response);
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\" \"http://www.w3.org/TR/REC-html40/loose.dtd\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + message + "</h1>");
            
            
            out.println("</body>");
            out.println("</html>");
            }//
          //  getServletContext().getRequestDispatcher("/Regggg.html").forward(request, response);
            //RequestDispatcher view = request.getRequestDispatcher("html/Regggg.html");
               //       view.forward(request, response); 
    }//END OF FINALLY
    
}//end class
 public static int[] Random_Place(int n, int rec) // generates a array of random nos to find the position of pix in 3 shares
{
    int j,i;
    int[] rand=new int[3];
    for(i=0;i<=2;i++)
    {
        int nik=rand_int(0,2);
        if(nik!=rand[2])
        { 
            rand[i]=nik;
        }    
    }
    return rand; 
}

public static int rand_int(int g, int n)
{
    g=0;
    Random rand1 =new Random();
    int rand_into=rand1.nextInt((2-g)+1)+g;
    return rand_into; 
}

public static void imgshare(int h,int []rand,int width,int height)
{
    int c,e;
     e=width*height;
    for(c=0;c<3;c++)
            {
              img_share[rand[c]][e][h] =1;
            }
 }

public static void argb(String val,int width,int height,int no)
{       int i,P,shareno;
        shareno=no;
        String value=val;
        int x= width;
        int y= height;
        i=ja;
             // System.out.println("iiii"+i);
        int B= Integer.parseInt(value.substring(i, i+8), 2);
        int G= Integer.parseInt(value.substring(i+8, i+16), 2);
        int R= Integer.parseInt(value.substring(i+16, i+24), 2);
        int A= Integer.parseInt(value.substring(i+24, i+32), 2);           
   switch(shareno)
      {
         case 0:
                    pixels1[ki1] =R;
                    pixels1[ki1+1]=G;
                    pixels1[ki1+2]=B;
                    pixels1[ki1+3]=A;
                    ki1 = ki1+4;
                    break; 
         case 1:
                    pixels2[ki2] =R;
                    pixels2[ki2+1] =G;
                    pixels2[ki2+2] =B;
                    pixels2[ki2+3]=A;
                    ki2 = ki2+4;  
                    break;
         case 2:
                    pixels3[ki3] =R;
                    pixels3[ki3+1] =G;
                    pixels3[ki3+2] =B;
                    pixels3[ki3+3]=A;
                    ki3 = ki3+4;
                    break;      
         default: break;
      }
               ja=ja+32;
               po=po+32;            
   }
 
  public static void createImage(int[] pixels,int width,int height,int no) throws IOException
    {  
      switch(no)
      {
        case 0:
                WritableRaster raster1 = img1.getRaster();
                raster1.setPixels(0, 0, width, height, pixels1);
                break;
        case 1:
                WritableRaster raster2 = img2.getRaster();
                raster2.setPixels(0, 0, width, height, pixels2);
                break;
        case 2:
                WritableRaster raster3 = img3.getRaster();
                raster3.setPixels(0, 0, width, height, pixels3);
                break;
        default:break;
      }
    }
  private static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}
}   
   
   
   
   
   

   
