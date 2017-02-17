package snake;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Helper {
	public static Image loadImage(String path) {
		ImageIcon ico = new ImageIcon(path);
		return ico.getImage();
	}
}
