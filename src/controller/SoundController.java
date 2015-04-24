package controller;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.SwingUtilities;

/**
 * En klass som startar musik och stänger av musik. Skickar även värde om musik/
 * effektljud är igång eller inte.
 * 
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
			AudioClip soundEffects = null;

			public void run() {
				if (playSound == true) {
					try {
						URL url = new File("Music/whoosh.wav").toURI().toURL();
						soundEffects = Applet.newAudioClip(url);

						soundEffects.play();

					} catch (MalformedURLException e) {
						System.out.println(e);
					}
				}
			}
		});
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
				// music.play();

			} catch (MalformedURLException e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * En metod som spelar upp ett ljud när någon att vunnit.
	 */
	private void winnerSound() {
		if (playMusic == true) {
			AudioClip winnerSound = null;
			try {
				URL url = new File("Music/WinnerSoundFull.wav").toURI().toURL();
				winnerSound = Applet.newAudioClip(url);
				winnerSound.play();

			} catch (MalformedURLException e) {
				System.out.println(e);
			}
		}
	}

	private void cardTurn() {
		if (playSound == true) {
			AudioClip sound = null;
			try {
				URL url = new File("Music/whoosh.wav").toURI().toURL();
				sound = Applet.newAudioClip(url);
				sound.play();

			} catch (MalformedURLException e) {
				System.out.println(e);
			}
		}
	}

	private void wrongPair() {
		if (playSound == true) {
			AudioClip wrongPair = null;
			try {
				URL url = new File("Music/WinnerSoundFull.wav").toURI().toURL();
				wrongPair = Applet.newAudioClip(url);
				wrongPair.play();

			} catch (MalformedURLException e) {
				System.out.println(e);
			}
		}
	}

	private void pair() {
		if (playSound == true) {
			try {
				URL url = new File("Music/WinnerSoundFull.wav").toURI().toURL();
				music = Applet.newAudioClip(url);
				music.play();

			} catch (MalformedURLException e) {
				System.out.println(e);
			}
		}
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

	public void startEffects(int soundNbr) {
		if(soundNbr == 1)//Swish
		{
			cardTurn();
		}
		
		soundEffects();
	}

	public void startMusic() {
		run();
	}

	public void startWinnerSound() {
		winnerSound();
	}

	public void turnCard() {
		cardTurn();
	}

}
