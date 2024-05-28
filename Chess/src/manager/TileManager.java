package manager;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import helpTools.LoadSave;
import scenes.Playing;

import static helpTools.Constants.Screen.*;

public class TileManager {
	
	private int[][] tiles;
	private Playing playing;
	private BufferedImage BLACK, WHITE;
	
	
	
	public TileManager(Playing playing) {
		this.playing = playing;
		this.tiles = new int[8][8];
		
		initTiles();
	}
	
	private void initTiles() {
		
		BufferedImage atlas = LoadSave.getSpriteAtlas();
		
		BLACK = atlas.getSubimage(1 * 32, 2 * 32, 32, 32);
		WHITE = atlas.getSubimage(2 * 32, 2 * 32, 32, 32);

	}



	public void render(Graphics g) {
		
		int line = 0;
		BufferedImage tempImg;
		
		for(int j = 0; j < tiles[0].length; j++) {
			
			line++;
			for(int i = 0; i < tiles[1].length; i++) {
				
				if((getCurrentTileIndex(i, j) + line) % 2 == 0) {
					tempImg = BLACK;
				}
				else {
					tempImg = WHITE;
				}
				g.drawImage(tempImg, (TILESIZE * i), (TILESIZE * j), TILESIZE, TILESIZE, null);
			}
		}
		
	}
	
	public int getCurrentTileIndex(int x, int y) {
		return (tiles[0].length * y) + x;
	}
}
