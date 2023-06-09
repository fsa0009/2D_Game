package utilz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {
	
	public static final String LEVEL_ATLAS = "/Assets/map.png";

	public static final String LEVEL_BACKGROUND = "/Assets/Background.jpg";
	
	public static BufferedImage getSpriteAtlas(String fileName) {
		BufferedImage img = null; 
		InputStream is = LoadSave.class.getResourceAsStream(fileName); 
		try {
			img = ImageIO.read(is); 
		}catch (IOException e ) {
			e.printStackTrace();
		}finally {
			try {
				is.close(); 
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		return img; 
	}
	public static BufferedImage getBackground(String fileName) {
		BufferedImage img = null; 
		InputStream is = LoadSave.class.getResourceAsStream(fileName); 
		try {
			img = ImageIO.read(is); 
		}catch (IOException e ) {
			e.printStackTrace();
		}finally {
			try {
				is.close(); 
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		return img; 
	}
	
	
	

}
