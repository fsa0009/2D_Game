package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utilz.LoadSave;

public class LevelManager {

	private Game game ; 
	private BufferedImage levelSprite ; 
	private BufferedImage background ; 
	
	public LevelManager(Game game) {
		this.game = game ; 
		levelSprite = LoadSave.getSpriteAtlas(LoadSave.LEVEL_ATLAS) ; 
		background = LoadSave.getSpriteAtlas(LoadSave.LEVEL_BACKGROUND) ; 
	}
	
	
	
	public void draw(Graphics g) {
		g.drawImage(background, 0, 0,1248 ,672,  null) ; 
		g.drawImage(levelSprite, 0, 0,1248 ,672,  null) ; 

	}
	
	public void update() {
		
	}
}
