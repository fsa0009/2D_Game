package inputs;

import java.awt.event.KeyEvent;
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
			gamePanel.changeXDelta(-5);
			System.out.println("Key A is pressed");
			break;
		
		case KeyEvent.VK_S:
			System.out.println("Key S is pressed");
			gamePanel.changeYDelta(5);
			break;
		
		case KeyEvent.VK_W:
			System.out.println("Key W is pressed");
			gamePanel.changeYDelta(-5);
			break;
		case KeyEvent.VK_D:
			System.out.println("Key D is pressed");
			gamePanel.changeXDelta(5);
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public static void print(String s) {
		System.out.println(s);
	}

}
