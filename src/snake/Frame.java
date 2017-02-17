package snake;

import javax.swing.JFrame;
/**
 * 
 * @author Marcel Kornhuber
 *
 */
public class Frame extends JFrame{

	public Frame(Player x) {
		add(new Game(x)); 			// JPanel hinzuf�gen
		setResizable(false); 		// Gr��e des Fensters ist nich ver�nderbar
		pack(); 					// Ohne Pack() werden die Eigenschaften von Game() nicht einbezogen
		setLocation(400, 50);
		setTitle("Snake");
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Fenster durch das rote X schlie�en k�nnen
		
	}

}
