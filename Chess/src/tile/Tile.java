package tile;

import static helpTools.Constants.Screen.TILESIZE;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	private int x, y;
	private BufferedImage image;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void render(Graphics g) {
		g.drawImage(image, x * TILESIZE, y * TILESIZE, TILESIZE, TILESIZE, null);
	}
}
