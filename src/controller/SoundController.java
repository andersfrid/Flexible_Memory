package controller;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.SwingUtilities;

public class SoundController extends Thread {
	private boolean playSound = true;
	private boolean playMusic = true;
	private AudioClip music = null;

	public SoundController() {

	}

	private void soundEffects() {
		SwingUtilities.invokeLater(new Runnable() {
			AudioClip music = null;

			public void run() {
				if (playSound == true) {
					try {
						URL url = new File("Music/gong.au").toURI().toURL();
						music = Applet.newAudioClip(url);
						
						music.play();

					} catch (MalformedURLException e) {
						System.out.println(e);
					}
				}
			}
		});
	}

	public void stopSound() {
		if (playSound == true) {
			playSound = false;

		} else {
			playSound = true;

		}
	}

	public void run() {

		if (playMusic == true) {
			try {
				URL url = new File("Music/alcoholic.au").toURI().toURL();
				music = Applet.newAudioClip(url);
				music.loop();
//				music.play();

			} catch (MalformedURLException e) {
				System.out.println(e);
			}
		}

	}

	public void stopMusic() {
		if (playMusic == true) {
			playMusic = false;
			music.stop();
			this.interrupt();
		} else
			playMusic = true;
			startMusic();
	}

	public void setSound(boolean playSound) {
		this.playSound = playSound;

	}

	public boolean getSound() {
		return playSound;

	}

	public void setMusic(boolean playMusic) {
		this.playMusic = playMusic;
	}

	public boolean getMusic() {
		return playMusic;
	}

	public void startEffects() {
		soundEffects();
	}

	public void startMusic() {
		run();
	}

}
