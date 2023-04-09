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

import static utilz.Constants.EllieConstants.*;
import static utilz.Constants.Directions.*;

public class GamePanel extends JPanel {

	private MouseInputs mouseInputs;
	private int xDelta =100 , yDelta =100; 
	private BufferedImage img; 
	private BufferedImage[] runChar; 
	private BufferedImage[] shootChar; 
	private BufferedImage[] dieChar; 
	private BufferedImage[] idleChar; 

	String imgPath ; 
	private int aniTick , aniIndex , aniSpeed = 15; 
	
	
	private int x = 0; private int y = 0 ; 
	
	
	private int playerAction = ELLIE_IDLE; 
	private int playerDirection = -1; 
	private boolean moving = false; 
	
	public void setMoving(boolean moving) {
		this.moving = moving; 
	}
	
	public GamePanel() {
	imgPath = "Run"; 
	mouseInputs = new MouseInputs(this); 
	ImportImg(imgPath); 
	loadAnimations(); 
	setPanelSize(); 
	addKeyListener(new KeyboardInputs(this)); 
	addMouseListener( mouseInputs); 
	addMouseMotionListener(mouseInputs); 
	}
	
	private void loadAnimations() {

		// numbers for die 
		//int widthOfSpite = 239; 
		//int heightOfSpite = 199; 
		
		// numbers for for shoot idle run 
		int widthOfSpite = 239; 
		int heightOfSpite = 250; 

		idleChar = new BufferedImage[6]; 
		runChar = new BufferedImage[8]; 
		shootChar = new BufferedImage[8]; 
		dieChar = new BufferedImage[8]; 

		for(int i = 0 ; i < runChar.length;i++) {
			runChar[i] = img.getSubimage(i*widthOfSpite, 0, widthOfSpite, heightOfSpite);
		}
	}

	private void ImportImg( String imgPath) {
		
		InputStream inputStream = getClass().getResourceAsStream("/Assets/Ellie"+ imgPath + ".png"); 
		
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

	public void setDirection(int direction) {
		this.playerDirection = direction; 
	}
	
	private void setAnimation() {
		if (moving) {
			playerAction = ELLIE_RUN; 
			//imgPath = "Run"; 
			//ImportImg(imgPath); 
		}
		else {
			playerAction = ELLIE_IDLE; 
			//imgPath = "Idle"; 
			//ImportImg(imgPath); 
	} 
		}
	
	
	public void paintComponent(Graphics g) {

		//int xLocationOfDisplay = xDelta ; 
		//int yLocationOfDisplay = yDelta ; 
		
		int resizeSpiteWidthTo = 75; 
		int resizeSpiteHieghtTo =75; 
		
		int xlocationOfSubimage = 0; 
		int ylocationOfSubimage = 0; 
		
		//int widthOfInsideSubimage = 225; 
	//	int hieghtOfInsideSubimage = 199; 

		
		// for other none die 
		int widthOfInsideSubimage = 225; 
		int hieghtOfInsideSubimage = 250; 

		super.paintComponent(g);
		
		updateAnimationTick(); 
		setAnimation(); 
		updatePos(); 
		g.drawImage(runChar[aniIndex].getSubimage(xlocationOfSubimage, ylocationOfSubimage, widthOfInsideSubimage,  hieghtOfInsideSubimage), 
				xDelta	, yDelta ,resizeSpiteWidthTo,resizeSpiteHieghtTo,  null); 


	}

	private void updatePos() {
		if(moving) {
			switch(playerDirection) {
			case LEFT:
				if(xDelta <= 2) {
					break; 
				}else {
					xDelta -= 2 ; 
				}
				break; 
			case UP:
				if(yDelta <= 2) {
					break; 
				}else {
					yDelta -= 2 ; 
				}
				break; 		
			case RIGHT:
				if(xDelta >= 1198) {
					break; 
				}else {
					xDelta += 2 ; 
				}
				break;
			case DOWN:
				if(yDelta >= 790) {
					break; 
				}else {
					yDelta += 2 ; 
				}
				break; 
			}
		}
		
	}

	public static void print(String s) {
		System.out.println(s);
	}
}
