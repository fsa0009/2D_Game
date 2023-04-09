package entities;

public abstract class Entity {

	// protected => only classes that extend this class can use it 
	protected float x, y ; 
	public Entity( float x , float y) {
		this.x = x ; 
		this.y = y ; 
	}
}
