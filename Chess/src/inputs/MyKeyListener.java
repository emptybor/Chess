package inputs;

import static main.GameStates.MENU;
import static main.GameStates.PLAYING;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Game;
import main.GameStates;

public class MyKeyListener implements KeyListener{
	
	private Game game;
	
	public MyKeyListener(Game game) {
		super();
		this.game = game;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch(code) {
		case KeyEvent.VK_1: GameStates.gameState = MENU; break;
		case KeyEvent.VK_2: GameStates.gameState = PLAYING; break;

		}
		
		if(GameStates.gameState == PLAYING) {
			
			switch(code) {
			
			default: break;
				
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
