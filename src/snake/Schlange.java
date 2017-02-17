package snake;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

public class Schlange {

	public static final int LEFT = 0, RIGHT = 1, UP = 2, DOWN = 3; // vom
																	// KeyListener
																	// empfangen
	public static final int MOVEMENT_SPEED = 15; // Geschwindigkeit (15 pixel
													// pro sek)

	private int breite;
	private int h�he;
	private int schlangenL�nge = 3;
	private int schlangenDicke = 15;
	private List<Punkt> punkteListe = new ArrayList<>(); // Liste in der alle
															// Teile der
															// Schlange
															// aufgelistet sind
	private Image k�rper;
	private Image kopf;
	private int movex = -15;
	private int movey = 0;
	private int currentMovement = LEFT; // schleichrichtung der Schlange: zu
										// beginn links

	private boolean addK�rper = false;

	public Schlange(Game g) {

		// Images f�r Kopf und K�rper einlesen

		k�rper = Helper.loadImage("src/resources/k�rper3.png");
		kopf = Helper.loadImage("src/resources/kopf3.png");

		// Breite und H�he des Spielfeldes einlesen
		this.breite = g.getBreite();
		this.h�he = g.getH�he();

		// Startpunkt der Schlange
		for (int i = 0; i < 3; i++) {
			punkteListe.add(new Punkt(i * 15 + 300, 300));
		}

	}

	// fahrtrichtung festlegen
	public void setMovement(int direction) {
		switch (direction) {
		case DOWN:
			if (currentMovement == UP) // sollte UP gedr�ckt werden --> springt
										// er aus dem switch case und bleibt in
										// der gleichen Richtung
				return;
			movex = 0;
			movey = MOVEMENT_SPEED;
			break;
		case UP:
			if (currentMovement == DOWN)
				return;
			movex = 0;
			movey = -MOVEMENT_SPEED;
			break;
		case RIGHT:
			if (currentMovement == LEFT)
				return;
			movex = MOVEMENT_SPEED;
			movey = 0;
			break;
		case LEFT:
			if (currentMovement == RIGHT)
				return;
			movex = -MOVEMENT_SPEED;
			movey = 0;
			break;

		default:
			break;
		}
		currentMovement = direction; // Richtung �ndert sich nicht
	}

	public void getGraphics(Graphics g, ImageObserver img) {

		g.drawImage(kopf, punkteListe.get(0).getX(), punkteListe.get(0).getY(), img); // Kopf
																						// zeichnen
		// alle K�rperteile zeichnen, die in der Punkteliste vorhanden sind
		for (int i = 1; i < punkteListe.size(); i++) {
			g.drawImage(k�rper, punkteListe.get(i).getX(), punkteListe.get(i).getY(), img);
		}

	}

	public void bewege() {
		Punkt k�rperi = null; // create neuenK�rper
		if (addK�rper) { // wenn boolean addK�rper true ist: wird k�rperi mit
							// dem letzen K�rper der vorhanden ist �berschrieben
			k�rperi = new Punkt(punkteListe.get(punkteListe.size() - 1)); //
			addK�rper = false;
		}

		for (int i = punkteListe.size() - 1; i > 0; i--) { // verschiebt alle
															// punkte
			punkteListe.get(i).set(punkteListe.get(i - 1));
		}

		if (k�rperi != null) { // wenn ein neuer K�rper hinzugef�gt wurde...wird
								// er in die Punkteliste hinzugef�gt
			punkteListe.add(k�rperi);
		}

		Punkt kopfPunkt = punkteListe.get(0); // neuer Punkt mit der Position
												// des Kopfes...
		// Kopf um die pixel der Fahrtrichtung verschieben
		kopfPunkt.set(kopfPunkt.getX() + movex, kopfPunkt.getY() + movey);
	}

	public void addK�rper() { // boolean addK�rperteil
		addK�rper = true;
	}

	public boolean kollision() {
		boolean alive = true;

		if (punkteListe.get(0).getX() <= 15 || punkteListe.get(0).getX() >= 565) {
			alive = false;
		}
		if (punkteListe.get(0).getY() <= 15 || punkteListe.get(0).getY() >= 565) {
			alive = false;
		}

		return alive;
	}
	// public void kollisionApfel(Apfel a){
	// if(punkteListe.get(0).getX() == 200 && punkteListe.get(0).getY() == 200){
	// addK�rper();
	// a.newApplePosition();
	// }
	// }
}
