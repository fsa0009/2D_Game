package main;

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
	private Game game; 

	public GamePanel(Game game) {
	mouseInputs = new MouseInputs(this); 
	this.game = game; 
	setPanelSize(); 
	addKeyListener(new KeyboardInputs(this)); 
	addMouseListener( mouseInputs); 
	addMouseMotionListener(mouseInputs); 
	}
	
	private void setPanelSize() {
		Dimension size = new Dimension(1200 , 800); 
		setPreferredSize(size); 
	}

	public void updateGame() {

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.render(g);
	}

	public Game getGame() {
		return game; 
	}
	public static void print(String s) {
		System.out.println(s);
	}
}
