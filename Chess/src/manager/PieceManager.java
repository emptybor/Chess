package manager;

import java.awt.Graphics;
import java.util.ArrayList;

import piece.Bishop;
import piece.King;
import piece.Knight;
import piece.Pawn;
import piece.Piece;
import piece.Queen;
import piece.Rook;
import scenes.Playing;

public class PieceManager {
	
	private Playing playing;
	private ArrayList<Piece> pieces = new ArrayList<>();

	public PieceManager(Playing playing) {
		this.playing = playing;
		
		initBlack();
		initWhite();
		
		for (Piece piece : pieces) {
			piece.initImage();
		}
	}
	
	
	private void initBlack() {
		
		String color = "black";
		
		pieces.add(new Pawn(0, 1, color));
		pieces.add(new Pawn(1, 1, color));
		pieces.add(new Pawn(2, 1, color));
		pieces.add(new Pawn(3, 1, color));
		pieces.add(new Pawn(4, 1, color));
		pieces.add(new Pawn(5, 1, color));
		pieces.add(new Pawn(6, 1, color));
		pieces.add(new Pawn(7, 1, color));
		
		pieces.add(new Rook(0, 0, color));
		pieces.add(new Rook(7, 0, color));
		
		pieces.add(new Knight(1, 0, color));
		pieces.add(new Knight(6, 0, color));
		
		pieces.add(new Bishop(2, 0, color));
		pieces.add(new Bishop(5, 0, color));
		
		pieces.add(new King(4, 0, color));
		pieces.add(new Queen(3, 0, color));

	}
	
	private void initWhite() {
		
		String color = "white";
		
		pieces.add(new Pawn(0, 6, color));
		pieces.add(new Pawn(1, 6, color));
		pieces.add(new Pawn(2, 6, color));
		pieces.add(new Pawn(3, 6, color));
		pieces.add(new Pawn(4, 6, color));
		pieces.add(new Pawn(5, 6, color));
		pieces.add(new Pawn(6, 6, color));
		pieces.add(new Pawn(7, 6, color));
		
		pieces.add(new Rook(0, 7, color));
		pieces.add(new Rook(7, 7, color));
		
		pieces.add(new Knight(1, 7, color));
		pieces.add(new Knight(6, 7, color));
		
		pieces.add(new Bishop(2, 7, color));
		pieces.add(new Bishop(5, 7, color));
		
		pieces.add(new King(4, 7, color));
		pieces.add(new Queen(3, 7, color));
		
	}
	
	public void render(Graphics g) {
		
		for (Piece piece : pieces) {
			piece.render(g);
		}
	}
	
	

}
