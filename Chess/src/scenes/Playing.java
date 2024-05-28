package scenes;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;
import manager.PieceManager;
import manager.TileManager;

import static helpTools.Constants.Screen.*;

public class Playing extends GameScene implements SceneMethods{
	
	private Game game;
	private TileManager tileManager;
	private PieceManager pieceManager;
	
	int mX, mY;

	public Playing(Game game) {
		super(game);
		
		tileManager = new TileManager(this);
		pieceManager = new PieceManager(this);
		
	}
	
	public void render(Graphics g) {
		
		tileManager.render(g);
		pieceManager.render(g);
		
		g.setColor(new Color(20, 200, 20, 100));
		g.fillRect(mX, mY, TILESIZE, TILESIZE);
		g.setColor(Color.WHITE);
	}

	public void update() {
		
	}

	@Override
	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int x, int y) {
				
		mX = (x / TILESIZE) * TILESIZE;
		mY = (y / TILESIZE) * TILESIZE;
	}

	@Override
	public void mousePressed(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
