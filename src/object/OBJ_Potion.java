package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Potion extends SObject{
	
	public OBJ_Potion() {
		name = "Potion";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/potion.png"));
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