package snake;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ScoreBoard {

	private ArrayList<Player> scoreboard;

	public ScoreBoard() {
		scoreboard = new ArrayList<Player>();
	}
	
	public ScoreBoard(ScoreBoard x) {
		this.scoreboard = x.getPlayers();
	}

	public void addPlayer(Player neu) {
		scoreboard.add(neu);
	}

	public void deleteKunde(Player falsch) {
		scoreboard.remove(falsch);
	}

	public void load() {
		String line;
		String[] player;

		try {
			BufferedReader f = new BufferedReader(new FileReader(
					"C:/Users/Marcel/Documents/Marcel/HTBLuVA/3CHEL/FSST/Workspace/08_Snake/src/Ranking.txt"));

			while ((line = f.readLine()) != null) {
				player = line.split(",");
				Player neu = new Player(Integer.parseInt(player[0]), player[1], Integer.parseInt(player[2]));
				scoreboard.add(neu);
			}
			f.close();
		} catch (Exception e) {

		}

	}

	public void safe() {
		try {
			BufferedWriter wr = new BufferedWriter(new FileWriter(
					"C:/Users/Marcel/Documents/Marcel/HTBLuVA/3CHEL/FSST/Workspace/08_Snake/src/Ranking.txt"));

			for (Player a : scoreboard) {
				wr.write(a.toString());
			}
			wr.close();
		} catch (Exception e) {
			System.out.println("Fehler bei der Bearbeitung des Rankings");
		}

	}
	
	public void updateScoreBoard() {
		//ScoreBoard order = new ScoreBoard(this);
		//ArrayList<Player> orderPlayers = order.getPlayers();
		Player hilfe = new Player(0,"TestPlayer",0);
		boolean control = true;
		
		while (control){
			for (int i = 0; i < (scoreboard.size() - 1); i ++){
				if (scoreboard.get(i).getScore() > scoreboard.get(i+1).getScore()){
					hilfe = scoreboard.get(i);
					scoreboard.set(i, scoreboard.get(i+1));
					scoreboard.set((i+1),hilfe);
				}
			}
			
			control = false;
				for (int i = 0; i < (scoreboard.size() - 1); i++){
					if (scoreboard.get(i).getScore() > scoreboard.get(i+1).getScore())
					control = true;	
				}
		}
		
		
	}
	
	private ArrayList<Player> getPlayers() {
		return scoreboard;
	}
}
