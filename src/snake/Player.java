package snake;
/**
 * 
 * @author Marcel Kornhuber
 *
 */
public class Player {

	private int score;
	private String name;
	private int rank;
	
	public Player() {
		
	}
	
	public Player(int rank, String name, int score) {
		this.rank = rank;
		this.name = name;
		this.score = score;
	}
	
	public int getRank() {
		return rank;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	public String toString() {
		return rank + "," + name + "," + score + System.lineSeparator();
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public void incrementScore() {
		score += 10;
	}
}
