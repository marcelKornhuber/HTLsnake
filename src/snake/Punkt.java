package snake;

public class Punkt {
	
	private int x, y;
	
	public Punkt(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Punkt(Punkt p) {
		this.x = p.getX();
		this.y = p.getY();
	}
	
	public Punkt() {
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void set(Punkt p) {
		this.x = p.getX();
		this.y = p.getY();
	}
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	

}