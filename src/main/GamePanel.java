package main;
import chars.Ellie; 

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel {

	private MouseInputs mouseInputs;
	private int xDelta =100 , yDelta =100; 
	private BufferedImage img; 
	private BufferedImage[] runChar; 
	private BufferedImage[] shootChar; 
	private BufferedImage[] dieChar; 
	private BufferedImage[] idleChar; 

	private int aniTick , aniIndex , aniSpeed = 15; 
	
	
	private int x = 0; private int y = 0 ; 
	
	public GamePanel() {
	
	mouseInputs = new MouseInputs(this); 
	ImportImg(); 
	loadAnimations(); 
	setPanelSize(); 
	addKeyListener(new KeyboardInputs(this)); 
	addMouseListener( mouseInputs); 
	addMouseMotionListener(mouseInputs); 
	}
	
	private void loadAnimations() {

		// numbers for die 
		int widthOfSpite = 239; 
		int heightOfSpite = 199; 
		
		/* numbers for for shoot idle run 
		 * 		int widthOfSpite = 239; 
		int heightOfSpite = 250; 
		 * 
		 * 
		 * */
		idleChar = new BufferedImage[8]; 
		runChar = new BufferedImage[6]; 
		shootChar = new BufferedImage[8]; 
		dieChar = new BufferedImage[8]; 

		for(int i = 0 ; i < runChar.length;i++) {
			runChar[i] = img.getSubimage(i*widthOfSpite, 0, widthOfSpite, heightOfSpite);
		}
		
		
	}

	private void ImportImg() {
		// TODO Auto-generated method stub
		InputStream inputStream = getClass().getResourceAsStream("/Assets/EllieDie.png"); 
		
		try {
			img = ImageIO.read(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	private void updateAnimationTick() {
		aniTick++; 
		if(aniTick >= aniSpeed) {
			aniTick =0 ; 
			aniIndex++; 
			if(aniIndex >= runChar.length) {
				aniIndex = 0 ; 
			}
		}
	}
	private void setPanelSize() {
		Dimension size = new Dimension(1200 , 800); 
		setPreferredSize(size); 
	}


	public void changeXDelta(int value){
		this.xDelta += value; 
	}
	
	public void changeYDelta(int value){
		this.yDelta += value; 
	}
	private int times = 0 ; 
	public void paintComponent(Graphics g) {
		int xLocationOfDisplay = 0 ; 
		int yLocationOfDisplay = 0 ; 
		
		int resizeSpiteWidthTo = 75; 
		int resizeSpiteHieghtTo =75; 
		
		int xlocationOfSubimage = 0; 
		int ylocationOfSubimage = 0; 
		
		int widthOfInsideSubimage = 225; 
		int hieghtOfInsideSubimage = 199; 

		
		// for other none die 
	//	int widthOfInsideSubimage = 225; 
	//	int hieghtOfInsideSubimage = 250; 

		
		super.paintComponent(g);
		
		updateAnimationTick(); 
		g.drawImage(runChar[aniIndex].getSubimage(xlocationOfSubimage, ylocationOfSubimage, widthOfInsideSubimage,  hieghtOfInsideSubimage), 
				xLocationOfDisplay	, yLocationOfDisplay ,resizeSpiteWidthTo,resizeSpiteHieghtTo,  null); 
		
		if(times <1200)
		times+= 1; 
		
		if(times >= 1200) {
			times = 0 ; 
		}
		
	}
	
	
	
	public static void print(String s) {
		System.out.println(s);
	}
}
