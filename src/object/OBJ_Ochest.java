package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Ochest extends SObject {
	
	public OBJ_Ochest() {
		
		name = "Ochest";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/ochest.png"));
		
		}catch(IOException e) {
		e.printStackTrace();
		}
		solidArea.x = 0;
		solidArea.y = 0;
		solidArea.width = 80;
		solidArea.height = 80;
		collision = true;
	}

}