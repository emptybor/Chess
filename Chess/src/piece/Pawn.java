package piece;

import helpTools.LoadSave;
import tile.Position;

import static helpTools.Constants.Playing.*;

import java.util.ArrayList;


public class Pawn extends Piece{

	public Pawn(int x, int y, int color) {
		super(x, y, color);
		
		name = "Pawn";
	}
	
	public void initImage() {
		
		atlas = LoadSave.getSpriteAtlas();
		
		if(color == WHITE) {
			image = getSprite(0, 0);
		}else {
			image = getSprite(0, 1);
		}
	}
	
	public ArrayList<Position> getMovement(){
		
		ArrayList<Position> position = new ArrayList<>();
		
		position.add(new Position(x, y +  1 * direction));
		
		if(hasMoved == false) {
			
		position.add(new Position(x, y + 2 * direction));
		}
		
		return position;
	}
	
	public ArrayList<Position> getHitPositions(){
		
		ArrayList<Position> position = new ArrayList<>();
		
		position.add(new Position(x - 1, y + 1 * direction));
		position.add(new Position(x + 1, y + 1 * direction));
		
		return position;
	}

}
