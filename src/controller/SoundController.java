package controller;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.SwingUtilities;

/**
 * En klass som startar musik och stänger av musik. Skickar även värde om musik/ effektljud är igång eller inte.
 * @author David
 *
 */
public class SoundController extends Thread {
	private boolean playSound = true;
	private boolean playMusic = true;
	private AudioClip music = null;

	/**
	 * En metod som skapar ett soundeffect ljud.
	 */
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
	/**
	 * Metod som kollar om ljudeffekterna är på eller avstängda. 
	 */
	public void stopSound() {
		if (playSound == true) {
			playSound = false;

		} else {
			playSound = true;

		}
	}

	/**
	 * Tråd som spelar upp bakgrundmusiken.
	 */
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

	/**
	 * Kollar om musiken skall stoppas eller sättas igång.
	 */
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
