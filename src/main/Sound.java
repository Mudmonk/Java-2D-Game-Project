package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {
	
	Clip clip;
	URL soundURL[] = new URL[30];
	
	public Sound() {
		
		soundURL[0] = getClass().getResource("/sound/We're Bird People Now.wav");
		soundURL[1] = getClass().getResource("/sound/01_chest_open_1.wav");
		soundURL[2] = getClass().getResource("/sound/03_Step_grass_03.wav");
		soundURL[3] = getClass().getResource("/sound/051_use_item_01.wav");
		soundURL[4] = getClass().getResource("/sound/16_Atk_buff_04.wav");
		soundURL[5] = getClass().getResource("/sound/001_Hover_01.wav");
				
	}
	
	public void setFile(int i) {
		
		try {
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			
			if(i == 0) {
				FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				volumeControl.setValue(-15.0f);
			}
			
		}catch(Exception e) {
			
		}
		
	}
	
	public void play() {
		
		clip.start();
	}
	
	public void loop() {
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
	}
	
	public void stop() {
		
		clip.stop();
		
	}
	

}
