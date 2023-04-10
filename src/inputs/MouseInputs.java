package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.GamePanel;

public class MouseInputs implements MouseListener , MouseMotionListener {

	
	private GamePanel gamePanel; 
	
	public MouseInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel; 
	}
	
	public void mouseDragged(MouseEvent e) {
		// TOD Auto-generated method stub
		//print("mouse dragged"); 
	}

	
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		//print("mouse moved");
	}

	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//print("mouse clicked");
		if(e.getButton() == MouseEvent.BUTTON1) {
			gamePanel.getGame().getEllie().setShooting(true);
		}
	}

	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void print(String s) {
		System.out.println(s);
	}

}
