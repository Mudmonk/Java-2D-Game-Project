package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	
	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	public int hasKey = 0;
	public int money = 0;
	int usedPotion = 0;
	boolean isMoving = false;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 25;
		solidArea.y = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 30;
		solidArea.height = 50;
		
		setDefaultValues();
		getPlayerImage();
		
	}
	public void setDefaultValues() {
		
		worldX = gp.tileSize * 14;
		worldY = gp.tileSize * 14;
		speed = 4;
		direction = "down";
	}
	public void getPlayerImage() {
		try {
			
			up1 = ImageIO.read(getClass() .getResourceAsStream("/player/a_up1.png"));
			up2 = ImageIO.read(getClass() .getResourceAsStream("/player/a_up2.png"));
			up3 = ImageIO.read(getClass() .getResourceAsStream("/player/a_up3.png"));
			up4 = ImageIO.read(getClass() .getResourceAsStream("/player/a_up4.png"));
			down1 = ImageIO.read(getClass() .getResourceAsStream("/player/a_down1.png"));
			down2 = ImageIO.read(getClass() .getResourceAsStream("/player/a_down2.png"));
			down3 = ImageIO.read(getClass() .getResourceAsStream("/player/a_down3.png"));
			down4 = ImageIO.read(getClass() .getResourceAsStream("/player/a_down4.png"));
			left1 = ImageIO.read(getClass() .getResourceAsStream("/player/a_left1.png"));
			left2 = ImageIO.read(getClass() .getResourceAsStream("/player/a_left2.png"));
			left3 = ImageIO.read(getClass() .getResourceAsStream("/player/a_left3.png"));
			left4 = ImageIO.read(getClass() .getResourceAsStream("/player/a_left4.png"));
			right1 = ImageIO.read(getClass() .getResourceAsStream("/player/a_right1.png"));
			right2 = ImageIO.read(getClass() .getResourceAsStream("/player/a_right2.png"));
			right3 = ImageIO.read(getClass() .getResourceAsStream("/player/a_right3.png"));
			right4 = ImageIO.read(getClass() .getResourceAsStream("/player/a_right4.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		if(keyH.upPressed == true || keyH.downPressed == true || 
				keyH.rightPressed == true ||keyH.leftPressed == true) {
			if(keyH.upPressed == true) {
				direction = "up";
			}
			else if(keyH.downPressed == true) {
				direction = "down";
			}
			else if(keyH.rightPressed == true) {
				direction = "right";				
			}
			else if(keyH.leftPressed == true) {
				direction = "left";				
			}
			
			//COLLISION CHECKER
			
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			
			
			// IF FALSE, PLAYER MOVES
			if(collisionOn == false) {
								
				switch(direction) {
				case "up":
					worldY -= speed;					
					break;
				case "down":
					worldY += speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "right":
					worldX += speed;
					break;
					}
				
				}
				
			}
			spriteCounter++;
			if (spriteCounter > 10) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum = 3;
				}
				else if(spriteNum == 3) {
					spriteNum = 4;
				}
				else if(spriteNum == 4) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
		
	
	public void pickUpObject(int i) {
		
		if(i != 999) {
			String objectName = gp.obj[i].name;
			
			switch(objectName) {
			case "Key":
				gp.playSE(5);
				hasKey++;
				gp.obj[i] = null;
				System.out.println("Key:" + hasKey);
				break;
			case "Chest":
				if(hasKey > 0) {
				hasKey--;
				gp.playSE(1);
				money = money + 100;
				System.out.println("Key:" + hasKey + " Money:" + money);
				gp.obj[i] = gp.obj[1];
				}
				break;
			case "Potion":
				usedPotion++;
				gp.playSE(3);
				gp.obj[i] = null;
				speed = speed + 2;
				System.out.println("Gotta go fast!");
				break;
			}
		}
		
	}
	
	public void draw(Graphics2D g2) {
		
		// g2.setColor(Color.white);		
		// g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			if(spriteNum == 3) {
				image = up3;
			}
			if(spriteNum == 4) {
				image = up4;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			if(spriteNum == 3) {
				image = down3;
			}
			if(spriteNum == 4) {
				image = down4;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			if(spriteNum == 3) {
				image = left3;
			}
			if(spriteNum == 4) {
				image = left4;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			if(spriteNum == 3) {
				image = right3;
			}
			if(spriteNum == 4) {
				image = right4;
			}
			break;
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		
	}
}
