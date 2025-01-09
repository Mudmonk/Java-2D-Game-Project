package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_GoldCoin extends SObject{
	
	public OBJ_GoldCoin() {
		name = "Gold Coin";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/gcoin.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
