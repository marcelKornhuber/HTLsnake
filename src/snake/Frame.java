package snake;

import javax.swing.JFrame;
/**
 * 
 * @author Marcel Kornhuber
 *
 */
public class Frame extends JFrame{

	public Frame(Player x) {
		add(new Game(x)); 			// JPanel hinzufügen
		setResizable(false); 		// Größe des Fensters ist nich veränderbar
		pack(); 					// Ohne Pack() werden die Eigenschaften von Game() nicht einbezogen
		setLocation(400, 50);
		setTitle("Snake");
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Fenster durch das rote X schließen können
		
	}

}
