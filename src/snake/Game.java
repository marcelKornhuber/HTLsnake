package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel implements KeyListener {
	private int breite = 600;
	private int h�he = 600;

	private Schlange snake;
	private Apfel apfel = new Apfel();

	Timer tmr;

	GameOver gameover = new GameOver();

	public Game() {
		addKeyListener(this);
		snake = new Schlange(this);
		// addKeyListener(new MoveSnakeListener());
		setPreferredSize(new Dimension(h�he, breite)); // Legt die gr��e des
														// Feldes fest (mit
														// setSize funktioniert
														// es nicht)

		setBackground(Color.DARK_GRAY);

		setFocusable(true);

		tmr = new Timer();
		tmr.schedule(new TimerTask() {
			@Override
			public void run() {
				snake.bewege();
				repaint();
			}
		}, 1000, 400);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		// snake.kollisionApfel(apfel);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.GRAY);
		g2.fillRect(0, 0, 600, 15);
		g2.fillRect(0, 0, 15, 600);
		g2.fillRect(585, 0, 15, 600);
		g2.fillRect(0, 585, 600, 15);
		// g2.fillRect(200, 200, 20, 20);

		snake.getGraphics(g2, this);
		apfel.getGraphics(g2, this);

		if (snake.kollision() == false) {
			System.out.println("Kollision");
			tmr.cancel();
			gameover.setVisible(true);

		}

	}

	public int getBreite() {
		return breite;
	}

	public int getH�he() {
		return h�he;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		switch (arg0.getKeyCode()) {

		case KeyEvent.VK_UP:
			// System.out.println("up");
			snake.setMovement(Schlange.UP);
			break;

		case KeyEvent.VK_DOWN:
			// System.out.println("down");
			snake.setMovement(Schlange.DOWN);
			break;

		case KeyEvent.VK_LEFT:
			// System.out.println("left");
			snake.setMovement(Schlange.LEFT);
			break;

		case KeyEvent.VK_RIGHT:
			// System.out.println("right");
			snake.setMovement(Schlange.RIGHT);
			break;

		case KeyEvent.VK_T:
			snake.addK�rper();
			break;

		default:
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}