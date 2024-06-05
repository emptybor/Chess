package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.Game;
import main.GameStates;

public class MyMouseListener implements MouseListener, MouseMotionListener{
	
	private Game game;

	public MyMouseListener(Game game) {
		super();
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			switch(GameStates.gameState) {
			case MENU:
				game.getMenu().mouseClicked(e.getX() - 15, e.getY() - 20);
				break;
			case PLAYING:
				game.getPlaying().mouseClicked(e.getX() - 15, e.getY() - 20);
				break;
				
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		if(e.getButton() == MouseEvent.BUTTON1) {
		
		switch(GameStates.gameState) {
		case MENU:
			game.getMenu().mousePressed(e.getX() - 15, e.getY() - 20);
			break;
		case PLAYING:
			game.getPlaying().mousePressed(e.getX() - 15, e.getY() - 20);
			break;
		
		}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		switch(GameStates.gameState) {
		case MENU:
			game.getMenu().mouseReleased(e.getX() - 15, e.getY() - 20);
			break;
		case PLAYING:
			game.getPlaying().mouseReleased(e.getX() - 15, e.getY() - 20);
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
				
		switch(GameStates.gameState) {
		case MENU:
			game.getMenu().mouseDragged(e.getX() - 15, e.getY() - 20);
			break;
		case PLAYING:
			game.getPlaying().mouseDragged(e.getX() - 15, e.getY() - 20);
			break;
		}
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
					
			switch(GameStates.gameState) {
			case MENU:
				game.getMenu().mouseMoved(e.getX() - 15, e.getY() - 30);
				break;
			case PLAYING:
				game.getPlaying().mouseMoved(e.getX() - 15, e.getY() - 30);
				break;
			}
			
	}

}
