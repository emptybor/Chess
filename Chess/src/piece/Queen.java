package piece;

import main.Game;
import tile.Position;

import static helpTools.Constants.Playing.*;

import java.util.ArrayList;

import helpTools.LoadSave;


public class Queen extends Piece{

	public Queen(int x, int y, int color) {
		super(x, y, color);
		
		name = "Queen";
	}
	
	public void initImage() {
		
		atlas = LoadSave.getSpriteAtlas();
		
		if(color == WHITE) {
			image = getSprite(4, 0);
		}else {
			image = getSprite(4, 1);
		}
	}
	
	public ArrayList<Position> getMovement() {
		
		ArrayList<Position> position = new ArrayList<>();
		
		position.add(new Position(x, y +  1 * direction));
		position.add(new Position(x - 1, y + 1 * direction));
		position.add(new Position(x + 1, y + 1 * direction));

		
		return position;
	}
	
}
