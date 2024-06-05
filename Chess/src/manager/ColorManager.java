package manager;

import java.util.Random;

import main.Game;
import scenes.Playing;

import static helpTools.Constants.Playing.*;

public class ColorManager {
	
	private Playing playing;
	
	public ColorManager(Playing playing) {
		super();
		this.playing = playing;
		
		initColor();
	}
	
	public void initColor() {
		
//		Random random = new Random();
//		int num = random.nextInt(2);
//
//		if(num == 0) {
//			setCurrentColor(BLACK);
//		}
//		else {
//			setCurrentColor(WHITE);
//		}
		
		setCurrentColor(WHITE);
	}

	public void changeColor() {
		
		if(CURRENTCOLOR == WHITE) {
			CURRENTCOLOR = BLACK;
		}
		else {
			CURRENTCOLOR = WHITE;
		}
	}

	public int getOppositeColor() {
		
		if(CURRENTCOLOR == WHITE) {
			return BLACK;
		}
		else {
			return WHITE;
		}
	}
	
	public int getCurrentColor() {
		return CURRENTCOLOR;
	}

	public void setCurrentColor(int currentColor) {
		CURRENTCOLOR = currentColor;
	}

}
