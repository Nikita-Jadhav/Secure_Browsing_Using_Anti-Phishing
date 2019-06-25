import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class message121 
{
    public static int kii=0;
    public static int [] pixels1=new int [9000000];
    public static int [] pixels2=new int [9000000];    
    public static int [] rgb1=new int[9000000];
    public static BufferedImage img10;
    public static int []fin;
    public static String z4="",z5="",z8="";
    
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
  int n=3,k=2,a,b,l,m,i,j;
  Integer c=new Integer(5000000);
    Integer c1=new Integer(5000000);
  String z="",z1="",z2="",z3="",z0="",fin="";
 f4 =new File("D:\\share111.jpg");
 BufferedImage image1;
image1 = ImageIO.read(f4);
 int h1 = image1.getHeight();
 int w1 = image1.getWidth();
System.out.println("Height : "+ h1);
System.out.println("Width : "+ w1);
f5 =new File("D:\\share112.jpg");
BufferedImage image2;
image2 = ImageIO.read(f5);
int h2 = image2.getHeight();
int w2 = image2.getWidth();
System.out.println("Height : "+ h2);
System.out.println("Width : "+ w2);
kii=0; 
z5="";         
for(l=0; l<w2 ;l++)
          { for(m=0; m<h2 ;m++)
               { 
                 
                     c=image1.getRGB(l,m);                  //get each pixel value share1
                     z =Integer.toBinaryString(c); 
                    // z1=z1+z;
                     c1=image2.getRGB(l,m);                  //get each pixel value share2
                     z0 =Integer.toBinaryString(c1);  
                    // z2=z2+z0;
                    z3=oro(z,z0,l,m);
                    z8="";
               }
          }
       
       File outputFile1 = new File("D://output.jpg");
       ImageIO.write(img10, "jpg",outputFile1);
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
     Integer c=new Integer(5000000);
     Integer c1=new Integer(5000000);
     Integer c2=new Integer(5000000);
    String z="",z1="",z2="",z3="",z6="",z0="",z00=""; 
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

//BufferedImage img1 = new BufferedImage(image1.getWidth(),image1.getHeight(), BufferedImage.TYPE_INT_ARGB); 
  img10 = new BufferedImage(w2,h2, BufferedImage.TYPE_INT_RGB);
  kii=0;   
  z5="";
  for(i=0; i<w1 ;i++)
          {
             for(m=0; m<h1 ;m++)
               { 
                     c=image1.getRGB(i,m);                  //get each pixel value share1
                    // share[0][i*m]=c;
                     z =Integer.toBinaryString(c);  
                    // z1=z1+z;
                     c1=image2.getRGB(i,m);                  //get each pixel value share2
                    // share[1][i*m]=c1;
                     z0 =Integer.toBinaryString(c1);  
                     //z2=z2+z0; 
                     c2=image3.getRGB(i,m);                  //get each pixel value share2
                    // share[2][i*m]=c2;
                     z00 =Integer.toBinaryString(c2);  
                    // z3=z3+z00;
                     z6=orop(z,z0,z00,i,m);
                    // System.out.println("z6"+z6);
                     z4="";
            }
      }
      File outputFile1 = new File("D://output.jpg");
      ImageIO.write(img10, "jpg",outputFile1);
      
 /*for (i=0;i<w2;i++)
 {
  for (j=0;j<h2;j++)
 {
   System.out.println("share1"+share[0][i*j]);
   System.out.println("share2"+share[1][i*j]);
   System.out.println("share3"+share[2][i*j]);
 }
}
fin=new int[w2*h2*1000];
for(k=0;k<3;k++) 
{
for (i=0;i<w2;i++)
{
for (j=0;j<h2;j++)
{
  fin[i*j]=fin[i*j]|share[k][i*j];
  img10.setRGB(i,j,fin[i*j]);
  // System.out.println("finalj"+fin[j]);
}
}
File outputFile1 = new File("D://opt.jpg");
ImageIO.write(img10, "jpg", outputFile1);*/
    
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
      
        int A= Integer.parseInt(value.substring(i, i+8), 2);
        int R= Integer.parseInt(value.substring(i+8, i+16), 2);
        int G= Integer.parseInt(value.substring(i+16, i+24), 2);
        int B= Integer.parseInt(value.substring(i+24, i+32), 2);           
                rgb1[kii] =A<<24|R<<16|G<<8|B;
                System.out.println("rgb1["+kii+"]"+rgb1[kii]);    
                img10.setRGB(x,y,rgb1[kii]);
                kii++;
          }        
     // System.out.println("kii"+kii);
    public static String orop(String z,String z0,String z00,int i,int m)
    {
                   
                     while(z.length()!=32)
                     {
                      z=z+"0";
                     }
                      while(z0.length()!=32)
                     {   
                      z0=z0+"0";
                     }
                     while(z00.length()!=32)
                     {   
                        z00=z00+"0";
                     }
                      System.out.println("z  "+z);
                      System.out.println("z0 "+z0);
                      System.out.println("z00"+z00);
                      
                     for(int l=0;l<32;l++)
                     {
                         {
                         if(!(z.charAt(l)=='0' && z0.charAt(l)=='0' && z00.charAt(l)=='0'))
                         z4=z4+"1";
                         else
                         z4=z4+"0";
                         }
                         z5=z5+z4;
                    }
                    System.out.println("z6 "+z4);
                    argb(z4,i,m); 
                    return z4;
                
    }
            
    
 public static String oro(String z,String z0,int i,int m)
    {
                   
                     while(z.length()!=32)
                     {
                      z=z+"0";
                     }
                      while(z0.length()!=32)
                     {   
                      z0=z0+"0";
                     }
                 
               System.out.println("z  "+z);
                      System.out.println("z0 "+z0);
                      for(int l=0;l<32;l++)
                     {
                         {
                         if(!(z.charAt(l)=='0' && z0.charAt(l)=='0'))
                         z8=z8+"1";
                         else
                         z8=z8+"0";
                         }
                         z5=z5+z8;
                    }
                    System.out.println("z6 "+z8);
                    argb(z8,i,m); 
                    return z8;
          
}
}