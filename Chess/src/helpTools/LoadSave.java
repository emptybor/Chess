package helpTools;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class LoadSave {
	
	public static BufferedImage getSpriteAtlas() {
		
		BufferedImage img = null;
		InputStream is = LoadSave.class.getClassLoader().getResourceAsStream("chess_atlas.png");
		
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}

}
