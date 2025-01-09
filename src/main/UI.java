package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.OBJ_GoldCoin;
import object.OBJ_Key;

public class UI {
	
	GamePanel gp;
	Font serif_30;
	BufferedImage keyImage;
	BufferedImage gCoinImage;
	
	public UI(GamePanel gp) {
		
		this.gp = gp;
		
		serif_30 = new Font("Serif", Font.PLAIN, 30);
		OBJ_Key key = new OBJ_Key();
		keyImage = key.image;
		OBJ_GoldCoin gCoin = new OBJ_GoldCoin();
		gCoinImage = gCoin.image;
		
		
	}
	
	public void draw(Graphics2D g2) {
		g2.setFont(serif_30);
		g2.setColor(Color.WHITE);
		g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize, gp.tileSize/2, gp.tileSize/2, null);
		g2.drawImage(gCoinImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize/2, gp.tileSize/2, null);
		g2.drawString("0" + gp.player.money, gp.tileSize, 80);
		g2.drawString("x " + gp.player.hasKey, gp.tileSize, 120);
		
	}

}
