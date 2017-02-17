package snake;

import java.awt.Image;

import javax.swing.ImageIcon;
/**
 * 
 * @author Marcel Kornhuber
 *
 */
public class Helper {
	public static Image loadImage(String path) {
		ImageIcon ico = new ImageIcon(path);
		return ico.getImage();
	}
}
