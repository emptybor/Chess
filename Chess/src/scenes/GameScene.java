package scenes;

import java.awt.Graphics;

import main.Game;

public class GameScene {
	
	public Game game;
	
	protected int animationIndex;
	protected int tick;
	protected int ANIMATION_SPEED = 25;
	
	public GameScene(Game game) {
		
		this.game = game;
		
	}
	
	protected void updateTick() {
		
		tick++;
		
		if(tick >= ANIMATION_SPEED) {
			tick = 0;
			animationIndex++;
			
			if(animationIndex >= 4) {
				animationIndex = 0;
			}
		}
	}
	
	public Game getGame() {
		return game;
	}
	
	public int getXStringLength(Graphics g, String text) {
		int length = (int)g.getFontMetrics().getStringBounds(text, g).getWidth();
		int x = length;
		 return x;
		
	}

}
