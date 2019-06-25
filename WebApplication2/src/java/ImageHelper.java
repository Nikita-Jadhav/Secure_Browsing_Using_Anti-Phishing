import java.awt.Image;
import java.awt.Toolkit;
 
import javax.swing.ImageIcon;
/**
 * @author KAUSIK
 *
 */
public class ImageHelper {
	/**
	 * This method creates an image from encrypted string and returns an image
	 * @param imageData
	 * @return
	 */
	
	public static Image getImage(StringBuilder imageData){
		
		return Toolkit.getDefaultToolkit().createImage(ImageEncoderAndDecoder.decodeImage(imageData));
		
	}
	
	/**
	 * This method creates an image icon from encrypted string and returns an image icon
	 * @param imageData
	 * @return
	 */
	
	public static ImageIcon getImageIcon(StringBuilder imageData){
		
		return new ImageIcon(ImageEncoderAndDecoder.decodeImage(imageData));
		
	}
	
	
	
}