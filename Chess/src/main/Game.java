package main;

import java.awt.Graphics;

import javax.swing.JFrame;

import inputs.MyKeyListener;
import inputs.MyMouseListener;
import scenes.Menu;
import scenes.Playing;

public class Game extends JFrame implements Runnable{
	
	private Render render;
	private Playing playing;
	private Menu menu;
	
	private GameScreen gameScreen;
		
	private Thread gameThread;
	
	private MyMouseListener myMouseListener;
	private MyKeyListener myKeyListener;
	
	private final double FPS_SET = 120.0;
	private final double UPS_SET = 60.0;

	
	public Game() {
		
		gameScreen = new GameScreen(this);
				
		render = new Render(this);
		
		setPlaying(new Playing(this));
		setMenu(new Menu(this));
		
		setSize(gameScreen.getSize());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Chess");
		add(gameScreen);
		pack();
		setVisible(true);
		
		initInputs();
	}
	
	public void initInputs() {
		
		myMouseListener = new MyMouseListener(this);
		myKeyListener = new MyKeyListener(this);

		addMouseListener(myMouseListener);
		addMouseMotionListener(myMouseListener);
		addKeyListener(myKeyListener);
		
		requestFocus();
	}
	
	public void start() {
		
		gameThread = new Thread(this) {
		};

		gameThread.start();
	}
	
	@Override
	public void run() {

		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;

		long lastFrame = System.nanoTime();
		long lastUpdate = System.nanoTime();
		long lastTimeCheck = System.currentTimeMillis();

		int frames = 0;
		int updates = 0;

		long now;

		while (true) {
			now = System.nanoTime();

			// Render
			if (now - lastFrame >= timePerFrame) {
				repaint();
				lastFrame = now;
				frames++;
			}

			// Update
			if (now - lastUpdate >= timePerUpdate) {
				updateGame();
				lastUpdate = now;
				updates++;
			}

		}

	}
	
	private void updateGame() {
		switch (GameStates.gameState) {
		case MENU:
			menu.update();
			break;
		case PLAYING:
			playing.update();
			break;
		default:
			break;
		}
	}

	public Render getRender() {
		return render;
	}

	public void setRender(Render render) {
		this.render = render;
	}

	public Playing getPlaying() {
		return playing;
	}

	public void setPlaying(Playing playing) {
		this.playing = playing;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	

}
