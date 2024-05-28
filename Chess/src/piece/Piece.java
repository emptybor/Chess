package piece;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import helpTools.LoadSave;

import static helpTools.Constants.Screen.*;

import main.Game;

public class Piece {
	
	protected int x, y;
	protected String color = "";
	protected BufferedImage image;
	protected BufferedImage atlas;
	
	protected boolean pinned;
	
	public Piece(int x, int y, String color) {
		
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public void render(Graphics g) {
		g.drawImage(image, x * TILESIZE, y * TILESIZE, TILESIZE, TILESIZE, null);
	}
	
	public void initImage() {
		
	}
	
	public BufferedImage getSprite(int x, int y) {
		return atlas.getSubimage(x * 32, y * 32, 32, 32);
	}

}
