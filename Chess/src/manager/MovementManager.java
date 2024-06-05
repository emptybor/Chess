package manager;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import piece.Piece;
import scenes.Playing;
import tile.Position;

import static helpTools.Constants.Screen.*;
import static helpTools.Constants.Playing.*;


public class MovementManager {
	
	private Playing playing;
	private Piece selectedPiece;
	
	public MovementManager(Playing playing) {
		this.setPlaying(playing);
		
	}
	
	public void render(Graphics g) {
		
		if(selectedPiece != null) {
			for (Position pos : selectedPiece.getMovement()) {
				g.setColor(new Color(160, 60, 60, 100));
				g.fillRect(pos.getX() * TILESIZE, pos.getY() * TILESIZE, TILESIZE, TILESIZE);
			}
			
			for (Position pos : selectedPiece.getHitPositions()) {
				g.setColor(new Color(60, 160, 60, 100));
				g.fillRect(pos.getX() * TILESIZE, pos.getY() * TILESIZE, TILESIZE, TILESIZE);
			}
		}
		
	}
	
	public void update() {
		
	}
	
	public boolean canBePlaced(int x, int y) {
		
		for (Piece piece : playing.getPieceManager().getPieces()) {
			if(piece.intersect(x, y)) {
				if(piece.getColor() == CURRENTCOLOR) {
				return false;
				}
				
				else {
					
					for (Position pos : selectedPiece.getHitPositions()) {
						if(pos.intersect(x, y)) {
							
							//Mit anderen Positionen noch überprüfen
							return false;
						}
					}
					
				}
			}
		}
		
		
		for (Position pos : selectedPiece.getMovement()) {
			if(pos.intersect(x, y)) {
				return true;
			}
		}
		
		
		
		return false;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Playing getPlaying() {
		return playing;
	}

	public void setPlaying(Playing playing) {
		this.playing = playing;
	}

	public Piece getSelectedPiece() {
		return selectedPiece;
	}

	public void setSelectedPiece(Piece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}

	

}
