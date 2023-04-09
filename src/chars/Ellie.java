package chars;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;


public class Ellie extends JPanel {
	
	public Graphics g ; 

	public boolean EllieExist; 
	public BufferedImage [] idleElliePics ;
	public BufferedImage [] shootElliePics ;
	public BufferedImage [] runElliePics ;
	public BufferedImage [] dieElliePics ;
	
	private BufferedImage EllieIdle; 
	private BufferedImage EllieShoot; 
	private BufferedImage EllieRun; 
	private BufferedImage EllieDie; 
	
	private int xDelta =100 , yDelta =100; 
	private int aniTick , aniIndex , aniSpeed = 15; 
	private int x = 0; private int y = 0 ; 
	

	// 0 = idle , 1 = shoot , 2 = run , 3=  die
	public int EllieState ; 

	public Ellie(){
		EllieState = 0 ;
		idleElliePics = new BufferedImage[6];
		shootElliePics = new BufferedImage[8];
		runElliePics = new BufferedImage[8];
		dieElliePics = new BufferedImage[6];
		importAllElliePics();
		loadAllEllieAnimations( 239 ,  250);
		
		paintEllie(   EllieState );
		updateAnimationTick( EllieState) ;
	}
	
	private void loadAllEllieAnimations(int widthOfSpite , int hieghtOfSpite){

		for(int i = 0 ; i < idleElliePics.length; i++) {
			idleElliePics[i] = EllieIdle.getSubimage(i*widthOfSpite, 0, widthOfSpite, hieghtOfSpite);
		}
		
		for(int i = 0 ; i < idleElliePics.length; i++) {
			shootElliePics[i] = EllieShoot.getSubimage(i*widthOfSpite, 0, widthOfSpite, hieghtOfSpite);
		}
		
		for(int i = 0 ; i < idleElliePics.length; i++) {
			runElliePics[i] = EllieRun.getSubimage(i*widthOfSpite, 0, widthOfSpite, hieghtOfSpite);
		}
		
		for(int i = 0 ; i < idleElliePics.length; i++) {
			dieElliePics[i] = EllieIdle.getSubimage(i*239, 0, 239, 199);
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

	private boolean updateAnimationTick(int EllieState) {
		BufferedImage [] toUpdate ; 

		if (EllieState == 0 ) {
			toUpdate =  idleElliePics; 
		}else if (EllieState ==1 ) {
			toUpdate =  idleElliePics; 
		}else if (EllieState ==2 ) {
			toUpdate =  idleElliePics; 
		}else if (EllieState ==3 ) {
			toUpdate =  idleElliePics; 
		}else {
			print("Wrong Ellie State"); 
			return false; 
		}
		
		aniTick++; 
		if(aniTick >= aniSpeed) {
			aniTick =0 ; 
			aniIndex++; 
			if(aniIndex >= toUpdate.length) {
				aniIndex = 0 ; 
			}
		}
		
		return true; 	
		
	}

	public void changeXDelta(int value){
		this.xDelta += value; 
	}
	
	public void changeYDelta(int value){
		this.yDelta += value; 
	}
	
	private int times = 0 ; 
	
	public void paintEllie( int EllieState ) {
		BufferedImage [] toUpdate = null ; 

		if (EllieState == 0 ) {
			toUpdate =  idleElliePics; 
		}else if (EllieState ==1 ) {
			toUpdate =  idleElliePics; 
		}else if (EllieState ==2 ) {
			toUpdate =  idleElliePics; 
		}else if (EllieState ==3 ) {
			toUpdate =  idleElliePics; 
		}else {
			print("Wrong Ellie State"); 
		}
		
		int xLocationOfDisplay = 0 ; 
		int yLocationOfDisplay = 0 ; 
		
		int resizeSpiteWidthTo = 75; 
		int resizeSpiteHieghtTo =75; 
		
		int xlocationOfSubimage = 0; 
		int ylocationOfSubimage = 0; 
		
		int widthOfInsideSubimage = 239; 
		int hieghtOfInsideSubimage = 250; 

		//paintEllie( EllieState);
		
		updateAnimationTick(EllieState); 
		
		g.drawImage(toUpdate[aniIndex].getSubimage(xlocationOfSubimage, ylocationOfSubimage, widthOfInsideSubimage,  hieghtOfInsideSubimage), 
				times , yLocationOfDisplay ,resizeSpiteWidthTo,resizeSpiteHieghtTo,  null); 
		
		if(times <1200)
		times+= 1; 
		
		if(times >= 1200) {
			times = 0 ; 
		}
		
	}
	
	public void EllieDies() {
		EllieState = 3; 
	}
	public void EllieRuns() {
		EllieState = 2; 
	}
	public void EllieShoots() {
		EllieState = 1; 
	}	
	public void EllieIdle() {
		EllieState = 0; 
	}
	
	public static void print(String s) {
		System.out.println(s);
	}
}