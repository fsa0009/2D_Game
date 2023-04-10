package inputs;

import java.awt.event.KeyEvent;
import static utilz.Constants.Directions.*;
import java.awt.event.KeyListener;

import main.GamePanel;

public class KeyboardInputs implements KeyListener{

	private GamePanel gamePanel;
	
	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel; 
	}
	

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}


	public void keyPressed(KeyEvent e) {

		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_A:
			gamePanel.getGame().getEllie().setMoving(true); 
			gamePanel.getGame().getEllie().setDirection(LEFT); 
			break;
		case KeyEvent.VK_S:
			gamePanel.getGame().getEllie().setMoving(true);
			gamePanel.getGame().getEllie().setDirection(DOWN); 
			break;
		case KeyEvent.VK_W:
			gamePanel.getGame().getEllie().setMoving(true);
			gamePanel.getGame().getEllie().setDirection(UP); 
			break;
		case KeyEvent.VK_D:
			gamePanel.getGame().getEllie().setMoving(true);
			gamePanel.getGame().getEllie().setDirection(RIGHT); 
			break;
		}

	}


	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_A:
			gamePanel.getGame().getEllie().setMoving(false);
			
			break;
		case KeyEvent.VK_S:
			gamePanel.getGame().getEllie().setMoving(false); 
			break;
		case KeyEvent.VK_W:
			gamePanel.getGame().getEllie().setMoving(false); 
			break;
		case KeyEvent.VK_D:
			gamePanel.getGame().getEllie().setMoving(false); 
			break;
		}		
	}
	
	public static void print(String s) {
		System.out.println(s);
	}

}
