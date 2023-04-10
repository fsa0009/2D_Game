package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window {
	
	private JFrame jFrame; 
	
	private int windowWidth; 
	private int windowHeight; 

	public Window(GamePanel gamePanel) {
		jFrame = new JFrame(); 
		//jFrame.setSize(400 , 400);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JLabel label1 = new JLabel("Test");
	//	gamePanel.add(label1);
		jFrame.add(gamePanel); 
		jFrame.setLocationRelativeTo(null);
		jFrame.setResizable(false);
		jFrame.pack();
		//JLabel label1 = new JLabel("Test");
	//	label1.addMouseListener(null);
		jFrame.setVisible(true);

	}
	
	
	public static void print(String s) {
		System.out.println(s);
	}
}
