package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.ControllerGUI;

/**
 * Ett GUI som visar en settings panel, där användaren kan stänga av musik och ljud. 
 * Även starta om spelet och gå till startsidan.
 * @author David Beer
 *
 */
public class SettingsPanel extends JPanel implements ActionListener {
	private JPanel panel;
	private JLabel logo;
	private JButton musicButton, soundButton, restartButton, mainMenu, exit, nextSong;
	private ControllerGUI controller;
	private Random rand = new Random();
	private int choose = 0;

	public SettingsPanel(ControllerGUI controller, int choose) {
		this.controller = controller;
		this.choose = choose;

		//Panel som målar upp bakgrunden.
		panel = new BgPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(400, 400));
		panel.setBackground(Color.LIGHT_GRAY);

		//Skapar en label och sätter en logo bild på den.
		ImageIcon iconLogo = new ImageIcon("Images/logo_smaller_320x75.png");
		logo = new JLabel(iconLogo);
		logo.setBounds(40, 40, 320, 50);

		//Knapp som startar om spelet och lägger passande bild på den.
		ImageIcon iconStart = new ImageIcon("Images/restartgame_small.jpg");
		restartButton = new JButton(iconStart);
		restartButton.setBounds(40, 170, 150, 50);

		// gör så restartknappen inte är klickbar när man inte valt teman.
		if(choose == 1){
			restartButton.setEnabled(false);
		}else{
			restartButton.setEnabled(true);
		}

		//Skapar en home knapp som tar användaren tillbaka till första sidan.
		ImageIcon iconHome = new ImageIcon("Images/home_small.jpg");
		mainMenu = new JButton(iconHome);
		mainMenu.setBounds(210, 170, 150, 50);

		// en avsluta knapp som stänger ner settings rutan.
		ImageIcon iconAvsluta = new ImageIcon("Images/b_exit_small_300x50.png");
		exit = new JButton(iconAvsluta);
		exit.setBounds(50, 250, 300, 50);

		//knapp som gör att man kan byta bakgrundmusik.
		ImageIcon iconNextSong = new ImageIcon("Images/nextButton.png");
		nextSong = new JButton(iconNextSong);
		nextSong.setBounds(20,337,50,50);
		nextSong.setBorderPainted(false);
		nextSong.setBorder(null);
		nextSong.setFocusable(false);
		nextSong.setMargin(new Insets(0,0,0,0));
		nextSong.setContentAreaFilled(false);

		//knapp som stänger av och sätter igång musiken igen.
		musicButton = new JButton();
		musicButton.setBounds(125, 337, 50, 50);
		musicButton.setBorderPainted(false);
		musicButton.setBorder(null);
		musicButton.setFocusable(false);
		musicButton.setMargin(new Insets(0, 0, 0, 0));
		musicButton.setContentAreaFilled(false);

		//knapp som stänger av ljudeffekterna och startar dem igen.
		soundButton = new JButton();
		soundButton.setBounds(225, 337, 50, 50);
		soundButton.setBorderPainted(false);
		soundButton.setBorder(null);
		soundButton.setFocusable(false);
		soundButton.setMargin(new Insets(0, 0, 0, 0));
		soundButton.setContentAreaFilled(false);

		panel.add(logo);
		panel.add(restartButton);
		panel.add(mainMenu);
		panel.add(exit);
		panel.add(nextSong);
		panel.add(musicButton);
		panel.add(soundButton);

		//lyssnare
		restartButton.addActionListener(this);
		mainMenu.addActionListener(this);
		exit.addActionListener(this);
		soundButton.addActionListener(this);
		musicButton.addActionListener(this);
		nextSong.addActionListener(this);

		volumePic();
		musicPic();

		add(panel);
	}

	/**
	 * Kollar om ljud spelas eller inte, byter även bild till den bild som skall visas.
	 */
	public void volumePic() {
		boolean playSound = controller.getSound();

		if (playSound == true) {

			ImageIcon iconSound = new ImageIcon("Images/b_sfx_on_50x50.png");
			soundButton.setIcon(iconSound);
		} else {

			ImageIcon iconSound = new ImageIcon("Images/b_sfx_off_50x50.png");
			soundButton.setIcon(iconSound);
		}
	}

	/**
	 * Kollar om musik spelar eller inte, byter även bild till den bild som skall visas.
	 */
	public void musicPic() {
		boolean playMusic = controller.getMusic();

		if (playMusic == true) {

			ImageIcon iconMusic = new ImageIcon("Images/b_volume_on_50x50.png");
			musicButton.setIcon(iconMusic);
		} else {

			ImageIcon iconMusic = new ImageIcon("Images/b_volume_off_50x50.png");
			musicButton.setIcon(iconMusic);
		}
	}
	/**
	 * Lyssnare som lyssnar på de olika knapparna och ger de funktionallitet.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == restartButton) {
			controller.startSound(5);
			controller.restart();
		}
		if (e.getSource() == mainMenu) {
			controller.startSound(5);
			controller.home();
		}
		if (e.getSource() == exit) {
			controller.startSound(5);
			System.exit(0);
		}
		if (e.getSource() == soundButton) {
			controller.stopSound();
			volumePic();
		}
		if (e.getSource() == musicButton) {
			controller.stopMusic(1);
			musicPic();
		}
		if (e.getSource() == nextSong){
			controller.startSound(5);
			controller.stopMusic(1);
			controller.nextSong(random(5));

		}

	}

	/**
	 * Metod som returnerar ett random värde som skickas in när man vill använda den.
	 * @param nbr
	 * @return random
	 */
	public int random(int nbr){
		int random = rand.nextInt(nbr);
		return random;
	}

	/**
	 * Inre klass som målar upp bakgrunden på panelen.
	 * @author David
	 *
	 */
	private class BgPanel extends JPanel {
		Image bg = new ImageIcon("Images/SettingsBackground.jpg").getImage();

		public void paintComponent(Graphics g) {
			g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
		}
	}
}
