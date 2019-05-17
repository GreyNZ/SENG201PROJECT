package main;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlaySounds {

	public static void main(String args) {
		
		File Click = new File("/sounds/button_click.wav");
		PlaySound(Click);
	}
	
	static void PlaySound(File Sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
			
			Thread.sleep(clip.getMicrosecondLength()/1000);  //takes milliseconds needed microseconds so divided by 1000
			
		}catch(Exception e) {
			
		}
	}
}
