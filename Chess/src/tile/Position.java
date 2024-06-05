package tile;

public class Position {
	
	private int x, y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean intersect(Position point) {
		
		if(x == point.getX()) {
			if(y == point.getY()) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean intersect(int x, int y) {
		
		if(this.x == x) {
			if(this.y == y) {
				return true;
			}
		}
		
		return false;
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
	
	

}
