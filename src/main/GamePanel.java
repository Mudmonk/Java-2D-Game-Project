package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import object.SObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	//SCREEN SETTINGS
	final int originalTileSize = 16; // 16x16 Tile
	final int scale = 5;
	
	public final int tileSize = originalTileSize * scale; // 80x80 tile
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 9;
	public final int screenWidth = tileSize * maxScreenCol; // 1280 pixels
	public final int screenHeight = tileSize * maxScreenRow; // 720 pixels
	
	//WORLD SETTINGS
	public final int maxWorldCol = 30;
	public final int maxWorldRow = 30;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	//FPS
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Sound music = new Sound();
	Sound se = new Sound();
	Thread gameThread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	
	// Entity & OBJECT
	public Player player = new Player(this, keyH);
	public SObject obj[] = new SObject[10];
	public UI ui = new UI(this);
	
	
	public GamePanel () {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		
		aSetter.setObject();
		
		playMusic(0);
		
	}
	
	public void startGameThread() {
			gameThread = new Thread(this);
			gameThread.start();
					
	}

	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS; // 0.016666 seconds
		double nextDrawTime = System.nanoTime() + drawInterval;
				
		while(gameThread != null) {
						
			update();
			
			repaint();
		
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
								
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
				
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += currentTime - lastTime;
			lastTime = currentTime;
			
			if(delta >= 1) {		
			update();
			repaint();
			delta--;
			drawCount++;
			}
			
			if(timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}*/
	}
	public void update() {
		
		player.update();
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		//Tile Drawer
		tileM.draw(g2);
		
		//Object Drawer
		for(int i = 0; i < obj.length; i++) {
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		
		//Player Drawer
		player.draw(g2);
		
		// UI
		ui.draw(g2);
		
		g2.dispose();
		

	}
	public void playMusic(int i) {
		
		music.setFile(i);
		music.play();
		music.loop();
		
	}
	public void stopMusic(int i) {
		
		music.stop();
		
	}
	public void playSE(int i) {
		
		se.setFile(i);
		se.play();
				
	}
	public void stopSE(int i) {
		se.stop();
	}
}
