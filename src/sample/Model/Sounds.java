package sample.Model;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sounds {
	/**
	 * Methods responsible for playing a sound
	 * 
	 * @param fileName
	 */
	public void playSound(String fileName) {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("sounds/" + fileName).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
		}
	}
}
