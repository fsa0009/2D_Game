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
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {

		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_A:
			gamePanel.setMoving(true); 
			gamePanel.setDirection(LEFT); 
			break;
		case KeyEvent.VK_S:
			gamePanel.setMoving(true);
			gamePanel.setDirection(DOWN); 
			break;
		case KeyEvent.VK_W:
			gamePanel.setMoving(true);
			gamePanel.setDirection(UP); 
			break;
		case KeyEvent.VK_D:
			gamePanel.setMoving(true);
			gamePanel.setDirection(RIGHT); 
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_A:
			gamePanel.setMoving(false); 
			break;
		case KeyEvent.VK_S:
			gamePanel.setMoving(false); 
			break;
		case KeyEvent.VK_W:
			gamePanel.setMoving(false); 
			break;
		case KeyEvent.VK_D:
			gamePanel.setMoving(false); 
			break;
		}		
	}
	
	
	
	public static void print(String s) {
		System.out.println(s);
	}

}
