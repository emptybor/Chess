package piece;

import helpTools.LoadSave;

public class Pawn extends Piece{

	public Pawn(int x, int y, String color) {
		super(x, y, color);
	}
	
	public void initImage() {
		
		atlas = LoadSave.getSpriteAtlas();
		
		if(color.equals("white")) {
			image = getSprite(0, 0);
		}else {
			image = getSprite(0, 1);
		}
	}

}
