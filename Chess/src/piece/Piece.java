package piece;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import helpTools.LoadSave;

import static helpTools.Constants.Screen.*;
import static helpTools.Constants.Playing.*;

import main.Game;
import tile.Position;

public class Piece {
	
	protected String name;
	
	protected int x, y;
	protected int color = 0;
	protected int direction = 0;
	protected BufferedImage image;
	protected BufferedImage atlas;
	
	protected boolean pinned = false;
	protected boolean hasMoved = false;
	
	public Piece(int x, int y, int color) {
		
		this.x = x;
		this.y = y;
		this.color = color;
		
		initDirection();
	}
	
	public void render(Graphics g) {
		g.drawImage(image, x * TILESIZE, y * TILESIZE, TILESIZE, TILESIZE, null);
	}
	
	public void update() {
		
	}
	
	public ArrayList<Position> getMovement() {
		return null;
	}
	public ArrayList<Position> getHitPositions() {
		return null;
	}
	
	
	public void initDirection() {
		
		if(color == WHITE) {
			direction = -1;
		}
		else {
			direction = 1;
		}
	}
	
	public void initImage() {
		
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
	
	public BufferedImage getSprite(int x, int y) {
		return atlas.getSubimage(x * 32, y * 32, 32, 32);
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public void setNewLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean setHasMoved() {
		return hasMoved;
	}

	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

}
