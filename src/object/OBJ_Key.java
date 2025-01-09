package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Key extends SObject {
	
	public OBJ_Key() {
		
		name = "Key";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		solidArea.x = 30;
		solidArea.y = 10;
		solidArea.width = 20;
		solidArea.height = 70;
		collision = true;
	}
	

}
