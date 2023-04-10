package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {

	// protected => only classes that extend this class can use it 
	protected float x, y ; 
	
	protected int width , height ; 
	protected Rectangle hitbox ; 
	
	public Entity( float x , float y  ) {
		this.y = y ; 
		initHitbox(); 
	}
	protected void drawHitbox(Graphics g) {
		// to debug 
		g.setColor(Color.PINK);
		g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
	}
	
	private void initHitbox() {
		hitbox =  new Rectangle( (int) x , (int) y , width , height ); 
	}
	
	protected void updateHitbox() {
		hitbox.x = (int) x ; 
		hitbox.y = (int) y ; 
	}
	
	public Rectangle getHitbox() {
		return hitbox; 
	}
	
	
	
}
