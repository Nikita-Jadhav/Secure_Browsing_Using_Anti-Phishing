
import com.mysql.jdbc.Driver;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;
import java.util.Random;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class hiiiiiiiiiiiiiiiiiiiiiiiiiiiiii{
 public static int[][][] img_share;        // to store the pixels of 3 number of shares 
 public static int po=0,ki1=0,ki2=0,ki3=0;
 public static int ja=0;
 public static BufferedImage img1,img2,img3;
 public static int [] pixels1=new int[500000];
 public static int [] pixels2=new int[500000];
 public static int [] pixels3=new int[500000];
  public static void main(String[] args) throws Exception, IOException, SQLException  {
  String url = "jdbc:mysql://localhost:3306/share1";
        String user = "root";
        String password ="";
try {
File f,f1,f2,f3;
int n=3,k=2,rec=2,m,s=0,i,e,j,h,c,P;  //declare n=no of shares, r=for reconstruction
int k1,k2,k4 =0,k3, height,width;
String b="",val;
int[] rand=new int[3];
FileInputStream imguser=null,share2u=null,share1ser=null,share3ser=null; 
BufferedImage image;
rec=2;
 f =new File("D:\\mix.jpg");
imguser =new FileInputStream(f);
image = ImageIO.read(f);       
height = image.getHeight(); 
width = image.getWidth();
img_share=new int[3][height*width][100];    

img1 = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_ARGB); 
img2 = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_ARGB); 
img3 = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_ARGB); 
for(i=0;i<width;i++)
 {   for(j=0;j<height;j++)
         {  
           Integer a=new Integer(5000000);
           a=image.getRGB(i,j);                  //get each pixel value
           b =Integer.toBinaryString(a);         //convert to binary 
            for(h=0;h<32;h++)
            {  
           if(b.charAt(h)=='1')      //ith position of PIX contains ‘1’
            { 
               rand= Random_Place(3,2);  //call rand fn
               imgshare(h,rand,i,j); }
      }
    }
  }
for(k1=0;k1<3;k1++)
{   val="";
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
   System.out.println("share"+(k1+1)+""+val); 
   System.out.println(val.length()); 
     switch(k1)
      {
         case 0:
               createImage(pixels1,width,height,k1);
               File outputFile1 = new File("D://share111.jpg");
               ImageIO.write(img1, "jpg", outputFile1);
               share1ser= new FileInputStream(outputFile1);
               {  po=0;
                  ja=0; } 
               break;
         case 1:
               createImage(pixels2,width,height,k1);
               File outputFile2 = new File("D://share112.jpg");
               ImageIO.write(img2, "jpg", outputFile2);
               share2u= new FileInputStream(outputFile2);
               {  po=0; 


                ja=0;  }  
               break;
         case 2:
               createImage(pixels3,width,height,k1);
               File outputFile3 = new File("D://share113.jpg");
               ImageIO.write(img3, "jpg", outputFile3);
               share3ser= new FileInputStream(outputFile3);
               break;
         default: break;
      } //end switch write img
     } // end k1 for loop                                
   try {
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql1 = "INSERT INTO user(uid,name,image,share2) values (?,?,?,?)";
        String sql2 = "INSERT INTO server(sid,uid,share1,share3) values (?,?,?,?)";
           PreparedStatement statement1 = conn.prepareStatement(sql1);
           statement1.setString(1,"112");
           statement1.setString(2,"Tomyy");
           statement1.setBlob(3,imguser);
           statement1.setBlob(4,share2u);
           int row1 = statement1.executeUpdate();
           PreparedStatement statement2 = conn.prepareStatement(sql2);
           statement2.setString(1,"2");
           statement2.setString(2,"112");
           statement2.setBlob(3,share1ser);
           statement2.setBlob(4,share3ser);
           int row2 = statement2.executeUpdate();
          conn.close();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        } 
} //end of main try   
catch (IOException io)
   {   }
} //end main
public static int[] Random_Place(int n, int rec) 
{  int j,i;
    int[] rand=new int[3];
    for(i=0;i<=2;i++)
    {  int nik=rand_int(0,2);
        if(nik!=rand[2])
        {   rand[i]=nik;
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
}

