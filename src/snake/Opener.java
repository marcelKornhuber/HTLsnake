package snake;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Opener extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblSpielername;
	private JButton btnRangliste;
	private JButton btnStartGame;
	private JLabel lblSnake;
	Frame snake = new Frame(); // JFrame erstellt
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Opener frame = new Opener();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Opener() {
		setTitle("Snake\r\n");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 368, 162);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(152, 44, 177, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblSpielername = new JLabel("Spielername:");
		lblSpielername.setBounds(32, 47, 118, 14);
		contentPane.add(lblSpielername);

		btnRangliste = new JButton("Rangliste");
		btnRangliste.setBounds(32, 99, 125, 30);
		contentPane.add(btnRangliste);

		btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//JFrame sichtbar machen
				snake.setVisible(true);
				setVisible(false);
				
				
				//Spieler einlesen
				//...
			}
		});
		btnStartGame.setBounds(203, 99, 125, 30);
		contentPane.add(btnStartGame);

		lblSnake = new JLabel("Snake V1.0");
		lblSnake.setBounds(32, 11, 125, 14);
		contentPane.add(lblSnake);
	}
}
