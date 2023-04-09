package main;

import java.awt.Graphics;

import entities.Ellie; 

public class Game implements Runnable{
	
	private Window gWindow; 
	private GamePanel gamePanel; 
	private Thread gameLoopThread; 
	private final int FPS = 120; 
	
	public final static int TILES_DEFALT_SIZE = 32; 
	public final static float SCALE = 1.5f; 
	public final static int TILES_IN_WIDTH = 26; 
	public final static int TILES_IN_HEIGHT = 14; 
	public final static int TILES_SIZE = (int) (TILES_DEFALT_SIZE * SCALE); 
	public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
	public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;

	
	
	private Ellie Ellie; 
	
	public Game() {
		initClasses();
		gamePanel = new GamePanel(this); 
		gWindow = new Window(gamePanel); 
		gamePanel.requestFocus();
		startGameLoop(); 
	}
	
	private void initClasses() {
		Ellie = new Ellie(200, 200); 		
	}

	private void startGameLoop() {
		gameLoopThread = new Thread(this); 
		gameLoopThread.start();
		
	}
	
	public void update() {
		Ellie.update();
	}
	
	public void render(Graphics g) {
		Ellie.render(g);
	}

	// game loop function to repaint the game for every frame 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		double timePerFrame = 1000000000.0/FPS; 
		long lastFrame= System.nanoTime(); 
		long now = System.nanoTime(); 
		
		int frames = 0 ; 
		long lastCheck = System.currentTimeMillis(); 
		
		while(true) {
			now = System.nanoTime(); 
			
			if(System.nanoTime() - lastFrame >= timePerFrame) {
				
				gamePanel.repaint();
				update();
				lastFrame= now; 
				frames++; 
				
			}
			
			if(System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis(); 
				print("FPS : " + frames) ;
				frames= 0 ; 
			}
		}
	}
	public Ellie getEllie() {
		return Ellie; 
	}
	
	public static void print(String s) {
		System.out.println(s);
	}
	
	
}
