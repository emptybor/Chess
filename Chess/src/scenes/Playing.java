package scenes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;

import main.Game;
import manager.ColorManager;
import manager.MovementManager;
import manager.PieceManager;
import manager.TileManager;
import piece.Piece;
import ui.StatisticBar;

import static helpTools.Constants.Screen.*;
import static helpTools.Constants.Playing.*;

public class Playing extends GameScene implements SceneMethods{
	
	private TileManager tileManager;
	private PieceManager pieceManager;
	private ColorManager colorManager;
	private MovementManager movementManager;
	
	private StatisticBar sBar;
	
	private Piece selectedPiece = null;
	private int mX, mY;

	public Playing(Game game) {
		super(game);
		
		colorManager = new ColorManager(this);
		tileManager = new TileManager(this);
		pieceManager = new PieceManager(this);
		movementManager = new MovementManager(this);
		
		sBar = new StatisticBar(this);
		
	}
	
	public void render(Graphics g) {
		
		tileManager.render(g);
		pieceManager.render(g);
		movementManager.render(g);
		sBar.render(g);
		
		if(selectedPiece != null) {
			g.drawImage(selectedPiece.getImage(), mX - TILESIZE / 2, mY - TILESIZE / 2, TILESIZE, TILESIZE, null);
			g.setColor(new Color(20, 200, 20, 100));
			g.fillRect(selectedPiece.getX() * TILESIZE, selectedPiece.getY() * TILESIZE, TILESIZE, TILESIZE);
			g.setColor(Color.WHITE);
		}
	}

	public void update() {
		
		sBar.update();
		
	}

	@Override
	public void mouseClicked(int x, int y) {
		int id = pieceManager.getPieceIndex(mX, mY);
		if(id != 999) {
			if(pieceManager.getPieces().get(id).getColor() == colorManager.getCurrentColor()) {
				
				selectedPiece = pieceManager.getPieces().get(id);
				selectedPiece.initImage();
			}
		}
		
	}

	@Override
	public void mouseMoved(int x, int y) {
		mX = x;
		mY = y;
	}

	@Override
	public void mousePressed(int x, int y) {
		
		
		int id = pieceManager.getPieceIndex(mX, mY);
		if(id != 999) {
			if(pieceManager.getPieces().get(id).getColor() == colorManager.getCurrentColor()) {
				
				game.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

				selectedPiece = pieceManager.getPieces().get(id);
				selectedPiece.initImage();
				
				movementManager.setSelectedPiece(selectedPiece);
			}
		}
	}

	@Override
	public void mouseReleased(int x, int y) {
		
		game.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

		if(selectedPiece != null) {
			
			if(movementManager.canBePlaced(x / TILESIZE, y / TILESIZE)) {
			colorManager.changeColor();
			
			int id = pieceManager.getPieces().indexOf(selectedPiece);
			pieceManager.getPieces().get(id).setNewLocation(mX / TILESIZE, mY / TILESIZE);
			pieceManager.getPieces().get(id).setHasMoved(true);
			}
			
			selectedPiece = null;
			movementManager.setSelectedPiece(null);
		}
		
	}

	@Override
	public void mouseDragged(int x, int y) {
		
		mX = x;
		mY = y;
		
	}

	public TileManager getTileManager() {
		return tileManager;
	}

	public void setTileManager(TileManager tileManager) {
		this.tileManager = tileManager;
	}

	public PieceManager getPieceManager() {
		return pieceManager;
	}

	public void setPieceManager(PieceManager pieceManager) {
		this.pieceManager = pieceManager;
	}

	public ColorManager getColorManager() {
		return colorManager;
	}

	public void setColorManager(ColorManager colorManager) {
		this.colorManager = colorManager;
	}

}
