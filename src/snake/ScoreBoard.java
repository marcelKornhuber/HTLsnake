package snake;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * 
 * @author Marcel Kornhuber
 *
 */
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
			BufferedReader f = new BufferedReader(new FileReader("src/Ranking.txt"));

			while ((line = f.readLine()) != null) {
				player = line.split(",");
				Player neu = new Player(Integer.parseInt(player[0]), player[1], Integer.parseInt(player[2]));
				scoreboard.add(neu);
			}
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	public void safe() {
		try {
			BufferedWriter wr = new BufferedWriter(new FileWriter("src/Ranking.txt"));

			for (Player a : scoreboard) {
				wr.write(a.toString());
			}
			wr.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	public void updateScoreBoard() {
		sort(scoreboard);
	}

	private ArrayList<Player> getPlayers() {
		return scoreboard;
	}

	private void sort(ArrayList<Player> str) {
		int i, j;
		int p1, p2;
		int length = str.size();
		Player tmp;
		for (i = 0; i < length - 1; ++i) {
			for (j = 0; j < length - 1; ++j) {
				p1 = str.get(j).getScore();
				p2 = str.get(j + 1).getScore();
				if (p1 < p2) {
					tmp = str.get(j);
					str.set(j, str.get(j + 1));
					str.set(j + 1, tmp);
				}
			}
		}
	}
	
	private void setRanks(ArrayList<Player> str){
		
	}
}
