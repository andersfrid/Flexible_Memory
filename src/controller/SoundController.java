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
	private String path = "Music/alcoholic.wav";
 
	/**
	 * Tråd som spelar upp bakgrundmusiken.
	 */
	private void music() {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				if (music == null) {
					if (playMusic == true) {
						try {
							URL url = new File(path).toURI().toURL();
							music = Applet.newAudioClip(url);
							music.loop();
							
						} catch (MalformedURLException e) {
							System.out.println(e);
						}
					}
				}
			}
		});
	}

	/**
	 * En metod som spelar upp ett ljud när någon att vunnit.
	 */
	private void winnerSound() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				if (playMusic == true) {
					AudioClip winnerSound = null;
					try {
						URL url = new File("Music/WinnerSoundFull.wav").toURI()
								.toURL();
						winnerSound = Applet.newAudioClip(url);
						winnerSound.play();

					} catch (MalformedURLException e) {
						System.out.println(e);
					}
				}
			}
		});
	}

	/**
	 * Metod för ljudet när man vänder kort.
	 */
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

	/**
	 * Metod som spelar upp ljud när man får fel par på sina kort.
	 */
	private void wrongPair() {
		if (playSound == true) {
			AudioClip wrongPair = null;
			try {
				URL url = new File("Music/error.wav").toURI().toURL();
				wrongPair = Applet.newAudioClip(url);
				wrongPair.play();

			} catch (MalformedURLException e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Metod som spelar upp ljud när avändaren lyckas välja rätt par.
	 */
	private void pair() {
		if (playSound == true) {
			AudioClip pair = null;
			try {
				URL url = new File("Music/win.wav").toURI().toURL();
				pair = Applet.newAudioClip(url);
				pair.play();

			} catch (MalformedURLException e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Metod som spelar upp ljud när användaren gör något felaktigt drag.
	 */
	private void error() {
		if (playSound == true) {
			AudioClip error = null;
			try {
				URL url = new File("Music/aj.wav").toURI().toURL();
				error = Applet.newAudioClip(url);
				error.play();

			} catch (MalformedURLException e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Metod för övriga knappljud, exempel singelplayer, multiplayer, de olika
	 * temanen och svårighetsgraderna.
	 */
	private void buttonSound() {
		if (playSound == true) {
			AudioClip button = null;
			try {
				URL url = new File("Music/click.wav").toURI().toURL();
				button = Applet.newAudioClip(url);
				button.play();

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
			music = null;
		} else
			playMusic = true;
			
			startMusic(1);
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

	/**
	 * Metod för att välja vilket ljud som skall spelas
	 * 
	 * @param soundNbr
	 *            skickas in en int som blir valet av vilket ljud som skall
	 *            spelas.
	 */
	public void startEffects(int soundNbr) {
		if (soundNbr == 1) {
			cardTurn(); // swish när kortet vänder = nummer 1
		}
		if (soundNbr == 2) {
			wrongPair(); // eee spelas vid fel par = nummer 2
		}
		if (soundNbr == 3) {
			pair(); // pling ljud när det blir rätt par = nummer 3
		}
		if (soundNbr == 4) {
			error(); // aj ljud när man klickar på samma kort två gånger =
						// nummer 4
		}
		if (soundNbr == 5) {
			buttonSound(); // klick ljud när man klickar på knapparna i menyerna
							// = nummer 5
		}

	}

	/**
	 * Metod för att välja vilken musik som skall spelas.
	 * 
	 * @param musicNbr
	 *            skickas in en int som blir till val för vilken musik som skall
	 *            spelas.
	 */
	public void startMusic(int musicNbr) {
		if (musicNbr == 1) {
			music(); // bakgrundsmusiken = nummer 1
		}
		if (musicNbr == 2) {
			winnerSound(); // vinnar musik som spelas när vinnarpanelen visas =
							// nummer 2
		}
	}
	
	public void musicChooser(int songNumb){
	
		switch(songNumb){
		case 0: 
			path = "Music/alcoholic.wav";
			break;
		case 1:
			path = "Music/Ambient-voyager-chillout-music.wav";
			break;
		case 2:
			path = "Music/Digital-garden-happy-music.wav";
			break;
		case 3:
			path = "Music/Mistery-of-Danch-unfinished.wav";
			break;
		case 4: 
			path = "Music/Time-traveler-beautiful-melodies-for-fantastic-stories.wav";
			break;
		default:
			path = "Music/alcoholic.wav";
			break;
		}
	}

}
