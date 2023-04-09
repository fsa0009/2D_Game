package main;

import java.awt.Graphics;

import entities.Ellie; 

public class Game implements Runnable{
	
	private Window gWindow; 
	private GamePanel gamePanel; 
	private Thread gameLoopThread; 
	private final int FPS = 120; 
	
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
