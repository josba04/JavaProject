package Priority;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.*;
import javazoom.jl.player.Player;

public class Music extends Thread {
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	private Clip clip;
	
	public Music(String pathName, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(IntroMusic.class.getResource("../Music/"+pathName).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		}catch(Exception e) {
			 System.out.println(e.getMessage());
		}
	}
	public int getTime() {
		if(player == null)
			return 0;
		return player.getPosition();
	}
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();
	}
	
	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}while(isLoop);	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void playWinSound(String pathName, boolean isLoop ) {
		try{
			clip = AudioSystem.getClip();
			File audioFile = new File(pathName);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip.open(audioStream);
			clip.start();
			if(isLoop) {
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
		}catch(LineUnavailableException e) {
			e.printStackTrace();
			
		}catch(UnsupportedAudioFileException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	public void playLoseSound(String pathName, boolean isLoop ) {
		try{
			clip = AudioSystem.getClip();
			File audioFile = new File(pathName);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip.open(audioStream);
			clip.start();
			if(isLoop) {
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
		}catch(LineUnavailableException e) {
			e.printStackTrace();
			
		}catch(UnsupportedAudioFileException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	public void playingSound(String pathName, boolean isLoop ) {
		try{
			clip = AudioSystem.getClip();
			File audioFile = new File(pathName);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip.open(audioStream);
			clip.start();
			FloatControl volume= (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			volume.setValue(-10.0f);
			if(isLoop) {
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
		}catch(LineUnavailableException e) {
			e.printStackTrace();
			
		}catch(UnsupportedAudioFileException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
}
