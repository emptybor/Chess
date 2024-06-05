package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import scenes.Playing;
import static helpTools.Constants.Screen.*;
import static helpTools.Constants.Playing.*;

public class StatisticBar {
	
	private Playing playing;
	
	private int x = 0;
	private int y = TILESIZE * SCALE;
	private int width = SCREENWIDTH;
	private int height = SCREENHEIGHT - y;

	public StatisticBar(Playing playing) {
		super();
		this.playing = playing;
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g.create();
		
		g2.setColor(Color.LIGHT_GRAY);
		g2.fillRect(x, y, width, height);
		
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(5));
		g2.drawLine(x, y, x + width, y);
		
		drawCurrentColor(g2);
		
		g2.dispose();
		
	}
	
	public void drawCurrentColor(Graphics2D g2) {
		
		String colorName;
		
		if(CURRENTCOLOR == WHITE) {
			
			colorName = "White";
		}
		else {
			colorName = "Black";
		}
		
		g2.setColor(Color.BLACK);
		g2.setFont(g2.getFont().deriveFont(20f));
		g2.drawString(colorName + "'s turn", x + height / 4, y + height / 2);
	}

}
