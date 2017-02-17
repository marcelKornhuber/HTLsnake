package snake;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.Random;

import javax.swing.ImageIcon;

public class Apfel {
	
	public static Image apfel;
	private Punkt position = new Punkt();
	
	
	public Apfel() {
		ImageIcon icon_apfel = new ImageIcon("C:/Users/Marcel/Documents/Marcel/HTBLuVA/3CHEL/FSST/Snake/apfelG.png");
		apfel = icon_apfel.getImage();
		newApplePosition();
		
	}
	
	//neuen Apfel zeichnen
	public void newApplePosition() {		
		Random x = new Random();
		position.setX((int)(Math.random() * 560) + 15);
		position.setY((int)(Math.random() * 560) + 15);
	}

	public Punkt getPosition() {
		return position;
	}

	public void setPosition(Punkt position) {
		this.position = position;
	}
	
	//apfel zeichnen: wird aber erst im Panel (Game) ausgeführt
	public void getGraphics(Graphics g, ImageObserver img){
		g.drawImage(apfel, position.getX(), position.getY(), img);
		
	}
	
}
