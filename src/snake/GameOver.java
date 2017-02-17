package snake;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
/**
 * 
 * @author Marcel Kornhuber
 *
 */
public class GameOver extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private Label label;
	private Label label_Points;
	private Label label_Ranking;
	private JTextField points;
	private JTextField rank;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOver frame = new GameOver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GameOver(/*String player , String Score*/) {
		setFont(new Font("Dialog", Font.BOLD, 15));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Marcel\\Documents\\Marcel\\HTBLuVA\\3CHEL\\FSST\\Snake\\RotesX.jpg"));
		setTitle("GAME OVER");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(470, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Restart");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(37, 203, 118, 38);
		contentPane.add(btnNewButton);
		
		//Spiel beenden
		btnNewButton_1 = new JButton("EXIT\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(289, 204, 118, 38);
		contentPane.add(btnNewButton_1);
		
		label = new Label("You crashed");
		label.setBounds(41, 29, 354, 55);
		contentPane.add(label);
		
		label_Points = new Label("Score:");
		label_Points.setBounds(37, 147, 74, 22);
		contentPane.add(label_Points);
		
		label_Ranking = new Label("Rank:");
		label_Ranking.setBounds(37, 97, 74, 22);
		contentPane.add(label_Ranking);
		
		points = new JTextField();
		points.setEditable(false);
		points.setBounds(151, 99, 107, 20);
		contentPane.add(points);
		points.setColumns(10);
		
		rank = new JTextField();
		rank.setEditable(false);
		rank.setBounds(151, 149, 107, 20);
		contentPane.add(rank);
		rank.setColumns(10);
	}
}
