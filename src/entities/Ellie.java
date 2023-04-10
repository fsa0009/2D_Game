package entities;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.Directions.*;
import static utilz.Constants.EllieConstants.*;
import javax.imageio.ImageIO;

public class Ellie extends Entity {

	public BufferedImage [] idleElliePics;
	public BufferedImage [] shootElliePics;
	public BufferedImage [] runElliePics;
	public BufferedImage [] dieElliePics;
	
	private BufferedImage EllieIdle; 
	private BufferedImage EllieShoot; 
	private BufferedImage EllieRun; 
	private BufferedImage EllieDie; 
	
	private BufferedImage[] animationArray1; 
	
	private int playerAction = ELLIE_DIE ; 
	private int aniTick , aniIndex , aniSpeed = 25; 
	
	private int x = 0; private int y = 500 ; 
	
	private int playerDirection = -1; 
	private boolean moving = false; 
	
	
	private boolean left, up, right, down ; 

	private boolean shooting = false; 
	

	public Ellie(float x , float y ) {
		super(x, y ); 
		importAllElliePics();
		loadAllEllieAnimations();
	
	}
	
	public void importBulletImage () {
		
	}
	
	public void animateBullet() {
		
	}
	
	public void update() {
		updateAnimationTick(); 
		setAnimation(); 
		updatePos();
		updateHitbox(); 

	}
	
	public void setShooting(boolean shooting){
		this.shooting = shooting ; 
	}
	
	public void render(Graphics g ) {
		int xLocationOfDisplay = x ; 
		int yLocationOfDisplay = y ; 
		
		int resizeSpiteWidthTo = 75; 
		int resizeSpiteHieghtTo =75; 
		
		int xlocationOfSubimage = 0; 
		int ylocationOfSubimage = 0; 
		
		// for other none die 
		int widthOfInsideSubimage = 225; 
		int hieghtOfInsideSubimage = 250; 

		// if Ellie dies , change dimenstions of subimage to cut
		if(playerAction == ELLIE_DIE) {
			widthOfInsideSubimage = 225; 
			hieghtOfInsideSubimage = 199; 
		}
		
		if(aniIndex >= determineAnimationArray().length || aniIndex <0 ) {
			if(determineAnimationArray()[0] != null) {
				aniIndex = 0; 
				g.drawImage(determineAnimationArray()[aniIndex], 
						x	, y ,resizeSpiteWidthTo,resizeSpiteHieghtTo,  null);
				drawHitbox(g); 

			}
		}else {
			if(determineAnimationArray()[aniIndex] != null) {
				g.drawImage(determineAnimationArray()[aniIndex], 
						x	, y ,resizeSpiteWidthTo,resizeSpiteHieghtTo,  null);
				drawHitbox(g); 
			}
		}


	}
	
	public BufferedImage[] determineAnimationArray() {
		if (playerAction == ELLIE_IDLE) {
			return idleElliePics;
		}else if (playerAction == ELLIE_RUN) {
			return runElliePics;
		}else if (playerAction == ELLIE_SHOOT) {
			return shootElliePics;
		}else if (playerAction == ELLIE_DIE) {
			return dieElliePics;
		}else {
			return idleElliePics;
		}
				
	}
	private void loadAllEllieAnimations(){
		int widthOfSpite = 239; 
		int hieghtOfSpite = 250; 
		idleElliePics  = new BufferedImage[6] ;
	    shootElliePics =new BufferedImage[8] ;
		runElliePics =new BufferedImage[8] ;
		dieElliePics =new BufferedImage[6] ;
		
		for(int i = 0 ; i < idleElliePics.length; i++) {
			idleElliePics[i] = EllieIdle.getSubimage(i*widthOfSpite, 0, widthOfSpite, hieghtOfSpite);
		}
		
		for(int i = 0 ; i < shootElliePics.length; i++) {
			shootElliePics[i] = EllieShoot.getSubimage(i*widthOfSpite, 0, widthOfSpite, hieghtOfSpite);
		}
		
		for(int i = 0 ; i < runElliePics.length; i++) {
			runElliePics[i] = EllieRun.getSubimage(i*widthOfSpite, 0, widthOfSpite, hieghtOfSpite);
		}
		
		for(int i = 0 ; i < dieElliePics.length; i++) {
			dieElliePics[i] = EllieDie.getSubimage(i*239, 0, 239, 199);
		}
		
	}
	
	private void importAllElliePics() {
		// TODO Auto-generated method stub
		InputStream is1 = getClass().getResourceAsStream("/Assets/EllieIdle.png"); 
		InputStream is2 = getClass().getResourceAsStream("/Assets/EllieShoot.png"); 
		InputStream is3 = getClass().getResourceAsStream("/Assets/EllieRun.png"); 
		InputStream is4 = getClass().getResourceAsStream("/Assets/EllieDie.png"); 

		try {
			EllieIdle = ImageIO.read(is1);
			EllieShoot = ImageIO.read(is2);
			EllieRun = ImageIO.read(is3);
			EllieDie = ImageIO.read(is4);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	private void updateAnimationTick() {
		aniTick++; 
		if(aniTick >= aniSpeed) {
			aniTick =0 ; 
			aniIndex++; 
			if(aniIndex >= getSpriteAmount(playerAction)) {
				aniIndex = 0 ; 
				shooting = false; 
			}
		}
	}
	
	public void setMoving(boolean moving) {
		this.moving = moving; 
	}
	
	// change Ellie direction to change animation
	public void setDirection(int direction) {
		this.playerDirection = direction; 
	}
	
	// change Ellie state
	private void setAnimation() {
		int startAni = playerAction; 
		
		if (moving) {
			playerAction = ELLIE_RUN; 
		}else if (shooting) {
			playerAction = ELLIE_SHOOT; 
		}
		else {
			playerAction = ELLIE_IDLE; 
	} 
		if(startAni != playerAction) {
			resetAniTick(); 
		}
		}
	
	private void resetAniTick() {
		aniTick = 0 ; 
		aniIndex = 0 ; 
	}

	// change Ellie position based on user arrow inputs
	private int[] updatePos() {
		int [] coordinates = new int[2];  
		if(moving) {
			switch(playerDirection) {
			case LEFT:
				if(x <= 1) {
					break; 
				}else {
					x -= 1 ; 
				}
				break; 
			case UP:
				if(y <= 1) {
					break; 
				}else {
					y -= 1 ; 
				}
				break; 		
			case RIGHT:
				if(x >= 1173) {
					break; 
				}else {
					x += 1 ; 
				}
				break;
			case DOWN:
				if(y >= 597) {
					break; 
				}else {
					y += 1 ; 
				}
				break; 
			}
		}
		coordinates [0] = x ; 
		coordinates [1] = y ; 
		return coordinates;
	}

	public static void print(String s) {
		System.out.println(s);
	}
}

