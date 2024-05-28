package main;

public enum GameStates {
	
	MENU, PLAYING;
	
	public static GameStates gameState = PLAYING;
	
	public void setGameStates(GameStates gameState) {
		this.gameState = gameState;
	}

}
