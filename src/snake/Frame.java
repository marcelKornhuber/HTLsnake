package snake;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Frame extends JFrame{

	public Frame() {
		add(new Game()); 			// JPanel hinzuf�gen
		setResizable(false); 		// Gr��e des Fensters ist nich ver�nderbar
		pack(); 					// Ohne Pack() werden die Eigenschaften von Game() nicht einbezogen
		setLocation(400, 50);
		setTitle("Snake");
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Fenster durch das rote X schlie�en k�nnen
		
	}

}
