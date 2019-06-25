
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
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
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;

public class decryption {
    
public static int kii=0;
public static int [] pixels1=new int [9000000];
public static int [] pixels2=new int [9000000];    
public static int [] rgb1=new int[9000000];
public static BufferedImage img10;

public static void main(String[] args) throws IOException 
{
    
                System.out.println("Retrive Image Example!");
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/share1";
		String userName = "root";
		String password = "";
		Connection con = null;
		try{
			Class.forName(driverName);
			con = DriverManager.getConnection(url,userName,password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select share2u from user where uid=789");
			while (rs.next()) {
                        InputStream in = rs.getBinaryStream(1);
			OutputStream f = new FileOutputStream(new File("E://ru//share2.jpg"));
			int c = 0;
                       while ((c = in.read()) > -1) {
			     f.write(c);
				}
			f.close();
			in.close();
                        }
                        ResultSet rs1 = stmt.executeQuery("select share1 from server where uid=112");
			while (rs1.next()) {
                        InputStream in1 = rs1.getBinaryStream(1);
			OutputStream f1 = new FileOutputStream(new File("E://ru//share1.jpg"));
			 int c = 0;
				while ((c = in1.read()) > -1) {
					f1.write(c);
				}
			f1.close();
			in1.close();
                        }
                        ResultSet rs2 = stmt.executeQuery("select share3 from server where uid=112");
			while (rs2.next()) {
                        InputStream in2 = rs2.getBinaryStream(1);
			OutputStream f2 = new FileOutputStream(new File("E://ru//share3.jpg"));
			int c = 0;
				while ((c = in2.read()) > -1) {
					f2.write(c);
				}
			f2.close();
			in2.close();
                        }
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
      System.out.println("Enter total number of shares for regeneration" );
      Scanner in = new Scanner(System.in);
      int no = in.nextInt();
      switch(no)
     {
         case 1:System.out.println("Invalid input");
               break;
         case 2:
             rec2();
             break;
         case 3 :
             rec3();
             break;
      }
    
}
 public static void createImage(int[] pixels,int width,int height) throws IOException
    {
        
                BufferedImage img100 = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
                WritableRaster raster1 = img100.getRaster();
                raster1.setPixels(0, 0, width, height, pixels1);
                File outputFile1 = new File("D://output.jpg");
                ImageIO.write(img100, "jpg", outputFile1);
              

    }

  public static void rec2()
     {
        
  try {
       File f4,f5;
   int n=3,k=2,a,b,l,m,i,j,l1,m1,h,k3;
    //Integer c=new Integer(9000000);
    String z="",z1="",z2="",z3="",zx="";
    
 f4 =new File("D:\\share111.jpg");
 BufferedImage image1;
image1 = ImageIO.read(f4);
  
int h1 = image1.getHeight();
int w1 = image1.getWidth();
System.out.println("Height1 : "+ h1);
System.out.println("Width1 : "+ w1);
int count = 0;

for(l=0; l<w1; l++){
         z="";
            for(m=0; m<h1; m++){
            
                    
                  
                   count++;
               Color c = new Color(image1.getRGB(l, m),true);
               z =Integer.toBinaryString(image1.getRGB(l, m));
               System.out.println("S.No: " + count + " Z: " + z +"Red:"+c.getBlue()+"Blue:"+c.getRed()+"Green:"+c.getGreen());
               z1=z1+z;
                   
            }
            
         }
         System.out.println("z1"+z1.length());
f5 =new File("D:\\share112.jpg");
BufferedImage image2;
image2 = ImageIO.read(f5);
int h2 = image2.getHeight();
int w2 = image2.getWidth();
System.out.println("Height2 : "+ h2);
System.out.println("Width2 : "+ w2);
 for(l=0; l<w2; l++){
         z="";
            for(m=0; m<h2; m++){
            
                    count++;
                  
                     count++;
               Color c = new Color(image1.getRGB(l, m),true);
               z =Integer.toBinaryString(image1.getRGB(l, m));
               System.out.println("S.No: " + count + " Z: " + z +"Red:"+c.getBlue()+"Blue:"+c.getRed()+"Green:"+c.getGreen());
               z2=z2+z;
                   
            }
            
         }
         System.out.println("z2"+z2.length());
     
        /*  
        for(l1=0; l1< w2 ;l1++)
          {
            for(m1=0; m1< h2 ;  m1++)
              { 
                  Integer abc=new Integer(900000000);
                    abc=image2.getRGB(l1,m1);                  //get each pixel value
                           zx =Integer.toBinaryString(abc);
          
            z2=z2+zx;  
           
              }
          }
        System.out.println("z2 String "+z2); 
        System.out.println("z2"+z2.length());*/
        
        /*c=image2.getRGB(l1,m1);                  //get each pixel value share2
           z =Integer.toBinaryString(c);  */
           //System.out.println(z);
    int x,y; 
    if (z1.length()>z2.length())
    { 
        y=z1.length()-z2.length();
       // System.out.println("y "+y);
        while(y!=0 && z1.length()!=z2.length())
        {
          z2=z2+"0";  
          y--;
        }
        //System.out.println("outer z2 "+z2);
      //  System.out.println("y "+y);
       // System.out.println("z2"+z2.length());
        x=z1.length();
    }
    else
        { 
        y=z2.length()-z1.length();
       // System.out.println("y "+y);
        while(y!=0 && z2.length()!=z1.length())
        {
          z1=z1+"0"; 
          y--;
        }
       // System.out.println("outer z1"+z1); 
       // System.out.println("y "+y);
       // System.out.println("z1"+z1.length());
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
     }
    // System.out.println("l"+l);
     System.out.println("Final z3  "+z3);//2 shares stacked
     System.out.println("z3"+z3.length());
     int len=0,q,ja=0,d;
   //  System.out.println("x"+x);
      y=x/32;
     d=z3.length()-(y*32);
    // System.out.println("d"+d);
       while(d%32!=0)
        {
          z3=z3+"0"; 
          d++;
        }
     int r=y*32+d;
     while(len!=r)
     {
               q =ja;
             //  System.out.println("iiii"+q);
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
        
    // System.out.println("kii"+kii);
            createImage(pixels1,w1,h1);
           // File outputFile1 = new File("E://ru//outimage2.jpg");
            //ImageIO.write(img1, "jpg", outputFile1);
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
f4 =new File("D://share111.jpg");
BufferedImage image1;
image1 = ImageIO.read(f4);
int h1 = image1.getHeight();
int w1 = image1.getWidth();
System.out.println("Height : "+ h1);
System.out.println("Width : "+ w1);

f5 =new File("D://share112.jpg");
BufferedImage image2;
image2 = ImageIO.read(f5);
int h2 = image2.getHeight();
int w2 = image2.getWidth();
System.out.println("Height : "+ h2);
System.out.println("Width : "+ w2);

f6 =new File("D://share113.jpg");
BufferedImage image3;
image3 = ImageIO.read(f6);
int h3 = image3.getHeight();
int w3 = image3.getWidth();
System.out.println("Height : "+ h3);
System.out.println("Width : "+ w3);

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
       System.out.println("outer z1 "+z1);
      //  System.out.println("z1"+z1.length()); 
       System.out.println("outer z2 "+z2); 
       // System.out.println("z2"+z2.length());
      System.out.println("outer z3 "+z2); 
       // System.out.println("z3"+z3.length());
         
    int x,y,d; 
    d=h1*w1*32;
     while(z1.length()!=d)
         {
             z1=z1+"0";
         }
         System.out.println("Final z1"+z1);
      
         while(z2.length()!=d)
          {   
             z2=z2+"0";
           }
         
         System.out.println("Final z2"+z2);
         while(z3.length()!=d)
          {   
             z3=z3+"0";
           }
         
         System.out.println("Final z3"+z3);
    l=0;
    z4="";
    System.out.println("z1len"+z1.length()); 
    System.out.println("z2len"+z2.length()); 
    System.out.println("z3len"+z3.length()); 
  
    while(l!=d)
    { 
      {
        if(z1.charAt(l)=='1' && z2.charAt(l)=='1' && z3.charAt(l)=='1'||z1.charAt(l)=='1' && z2.charAt(l)=='0' && z3.charAt(l)=='1' ||z1.charAt(l)=='0' && z2.charAt(l)=='1' && z3.charAt(l)=='1' ||z1.charAt(l)=='1' && z2.charAt(l)=='1' && z3.charAt(l)=='0'||z1.charAt(l)=='1' && z2.charAt(l)=='0' && z3.charAt(l)=='0'||z1.charAt(l)=='0' && z2.charAt(l)=='0' && z3.charAt(l)=='1'||z1.charAt(l)=='0' && z2.charAt(l)=='1' && z3.charAt(l)=='0')
          z4=z4+1;
         else
          z4=z4+0;
        }
        l++;
    }
   
   
     System.out.println("Final z4 "+z4);
     System.out.println("z4len"+z4.length()); 
     int r=d;
     int len=0,ja=0;
     kii=0;
      img10 = new BufferedImage(w2,h2, BufferedImage.TYPE_INT_RGB);
     len=0;
     i=0;
     String fin="";
     while(len!=r)    
     {  
      for(l=0; l<w2 ;l++)
          { for(m=0; m<h2 ;m++)
               { 
                 fin=z3.substring(i,i+32);
                 argb(fin,l,m);
                 i=i+32;
                 len=len+32;
                 System.out.println("len"+len);
               }
          }
     
     }
       File outputFile1 = new File("D://outpu.jpg");
       ImageIO.write(img10, "jpg",outputFile1);
  
    
}
  
catch (IOException io)
   {
   }
}
   public static void argb(String val,int width,int height)
{       int i=0,P,shareno;
        String value=val;
        int x= width;
        int y= height;
      
        int B= Integer.parseInt(value.substring(i, i+8), 2);
        int G= Integer.parseInt(value.substring(i+8, i+16), 2);
        int R= Integer.parseInt(value.substring(i+16, i+24), 2);
        int A= Integer.parseInt(value.substring(i+24, i+32), 2);           
                kii=0;
                rgb1[kii] =A<<24|R<<16|G<<8|B;
                System.out.println("rgb1[ki1]"+rgb1[kii]);    
                 
              
                img10.setRGB(x,y,rgb1[kii]);
                kii++;
             
       
                         
     }        
     // System.out.println("kii"+kii);
   
}
