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
	private int höhe;
	private int schlangenLänge = 3;
	private int schlangenDicke = 15;
	private List<Punkt> punkteListe = new ArrayList<>(); // Liste in der alle
															// Teile der
															// Schlange
															// aufgelistet sind
	private Image körper;
	private Image kopf;
	private int movex = -15;
	private int movey = 0;
	private int currentMovement = LEFT; // schleichrichtung der Schlange: zu
										// beginn links

	private boolean addKörper = false;

	public Schlange(Game g) {

		// Images für Kopf und Körper einlesen

		körper = Helper.loadImage("src/resources/körper3.png");
		kopf = Helper.loadImage("src/resources/kopf3.png");

		// Breite und Höhe des Spielfeldes einlesen
		this.breite = g.getBreite();
		this.höhe = g.getHöhe();

		// Startpunkt der Schlange
		for (int i = 0; i < 3; i++) {
			punkteListe.add(new Punkt(i * 15 + 300, 300));
		}

	}

	// fahrtrichtung festlegen
	public void setMovement(int direction) {
		switch (direction) {
		case DOWN:
			if (currentMovement == UP) // sollte UP gedrückt werden --> springt
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
		currentMovement = direction; // Richtung ändert sich nicht
	}

	public void getGraphics(Graphics g, ImageObserver img) {

		g.drawImage(kopf, punkteListe.get(0).getX(), punkteListe.get(0).getY(), img); // Kopf
																						// zeichnen
		// alle Körperteile zeichnen, die in der Punkteliste vorhanden sind
		for (int i = 1; i < punkteListe.size(); i++) {
			g.drawImage(körper, punkteListe.get(i).getX(), punkteListe.get(i).getY(), img);
		}

	}

	public void bewege() {
		Punkt körperi = null; // create neuenKörper
		if (addKörper) { // wenn boolean addKörper true ist: wird körperi mit
							// dem letzen Körper der vorhanden ist überschrieben
			körperi = new Punkt(punkteListe.get(punkteListe.size() - 1)); //
			addKörper = false;
		}

		for (int i = punkteListe.size() - 1; i > 0; i--) { // verschiebt alle
															// punkte
			punkteListe.get(i).set(punkteListe.get(i - 1));
		}

		if (körperi != null) { // wenn ein neuer Körper hinzugefügt wurde...wird
								// er in die Punkteliste hinzugefügt
			punkteListe.add(körperi);
		}

		Punkt kopfPunkt = punkteListe.get(0); // neuer Punkt mit der Position
												// des Kopfes...
		// Kopf um die pixel der Fahrtrichtung verschieben
		kopfPunkt.set(kopfPunkt.getX() + movex, kopfPunkt.getY() + movey);
	}

	public void addKörper() { // boolean addKörperteil
		addKörper = true;
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
	// addKörper();
	// a.newApplePosition();
	// }
	// }
}
