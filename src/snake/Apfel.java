package snake;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.Random;
/**
 * 
 * @author Marcel Kornhuber
 *
 */
public class Apfel {

	public static Image apfel;
	private Punkt position = new Punkt();
	private Random random;

	public Apfel() {

		apfel = Helper.loadImage("src/resources/apfelG.png");
		random = new Random();
		newApplePosition();

	}

	// neuen Apfel zeichnen
	public void newApplePosition() {
		position.setX(randomPosition(570));
		position.setY(randomPosition(570));
	}

	/**
	 * Berechnet eine neue Position, die nur in 15er schritten ist
	 * 
	 * @return
	 */
	private int randomPosition(int max) {
		return random.nextInt(max / 15) * 15 + 15;
	}

	public Punkt getPosition() {
		return position;
	}

	public void setPosition(Punkt position) {
		this.position = position;
	}

	// apfel zeichnen: wird aber erst im Panel (Game) ausgeführt
	public void getGraphics(Graphics g, ImageObserver img) {
		g.drawImage(apfel, position.getX(), position.getY(), img);

	}

}
