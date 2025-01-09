package main;

import object.OBJ_Chest;
import object.OBJ_Key;
import object.OBJ_Ochest;
import object.OBJ_Potion;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
		
	public void setObject() {
		
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldX = 16 * gp.tileSize;
		gp.obj[0].worldY = 14* gp.tileSize;
		
		gp.obj[1] = new OBJ_Ochest();
		gp.obj[1].worldX = 17 * gp.tileSize;
		gp.obj[1].worldY = 14 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Chest();
		gp.obj[2].worldX = 17 * gp.tileSize;
		gp.obj[2].worldY = 14 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Potion();
		gp.obj[3].worldX = 18 * gp.tileSize;
		gp.obj[3].worldY = 14 * gp.tileSize;
	}

}
