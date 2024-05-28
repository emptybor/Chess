package main;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import inputs.MyKeyListener;
import inputs.MyMouseListener;

import static helpTools.Constants.Screen.*;

public class GameScreen extends JPanel {

	private Game game;
	private Dimension size;

	public GameScreen(Game game) {
		this.game = game;

		setPanelSize();

	}

	private void setPanelSize() {
		size = new Dimension(SCREENWIDTH, SCREENHEIGHT);

		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		game.getRender().render(g);

	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

}