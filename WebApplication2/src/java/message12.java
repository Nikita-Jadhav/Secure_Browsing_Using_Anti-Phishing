



import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class message12 {
    public static int kii=0;
    public static int [] pixels1=new int [500000];
    public static int [] pixels2=new int [500000];   
    
    public static void createImage(int[] pixels,int width,int height) throws IOException
    {           BufferedImage img100 = new   BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
                WritableRaster raster1 = img100.getRaster();
                raster1.setPixels(0, 0, width, height, pixels1);
                File outputFile1 = new File("E://output.jpg");
                ImageIO.write(img100, "jpg", outputFile1);
    }
    public static void rec3()
             
  {
     try{
    File f4,f5,f6;
    int n=3,k=2,a,b,l,m,i,j;
     Integer c=new Integer(500000);
     Integer c1=new Integer(500000);
     Integer c2=new Integer(500000);
    String z="",z1="",z2="",z3="",z4="",z0="",z00=""; 
f4 =new File("E://share1.jpg");
BufferedImage image1;
image1 = ImageIO.read(f4);
int h1 = image1.getHeight();
int w1 = image1.getWidth();

f5 =new File("E://share2.jpg");
BufferedImage image2;
image2 = ImageIO.read(f5);
int h2 = image2.getHeight();
int w2 = image2.getWidth();
f6 =new File("E://share3.jpg");
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
/*
 static void rec2()
    {
    
        try {
      		File f4,f5;
                int n=3,k=2,a,b,l,m,i,j;
                Integer c=new Integer(500000);
                String z="",z1="",z2="",z3="";
                f4 =new File("E:\\share1.jpg");
                BufferedImage image1;
                image1 = ImageIO.read(f4);
                int h1 = image1.getHeight();
                int w1 = image1.getWidth();

                f5 =new File("E:\\share2.jpg");
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
        }  */
     
 public static void rec2()
     {
        
  try {
       File f4,f5;
   int n=3,k=2,a,b,l,m,i,j,l1,m1,h,k3;
    //Integer c=new Integer(9000000);
    String z="",z1="",z2="",z3="",zx="";
    
 f4 =new File("E:\\share111.jpg");
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
f5 =new File("E:\\share112.jpg");
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
 

}
