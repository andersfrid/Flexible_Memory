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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ControllerGUI;

/**
 * Ett GUI som visar en settings panel, där användaren kan stänga av musik och ljud. 
 * Även starta om spelet och gå till startsidan.
 * @author David
 *
 */
public class SettingsPanel extends JPanel implements ActionListener {
	private JPanel panel;
	private JLabel logo;
	private JButton musicButton, soundButton, restartButton, mainMenu, exit, nextSong;
	private JFrame frame;
	private ControllerGUI controller;
	private Random rand = new Random();
	private int number;

	public SettingsPanel(ControllerGUI controller) {
		this.controller = controller;

		panel = new BgPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(400, 400));
		panel.setBackground(Color.LIGHT_GRAY);

		ImageIcon iconLogo = new ImageIcon("Images/logo_smaller_320x75.png");
		logo = new JLabel(iconLogo);
		logo.setBounds(40, 40, 320, 50);

		ImageIcon iconStart = new ImageIcon("Images/restartgame_small.jpg");
		restartButton = new JButton(iconStart);
		restartButton.setBounds(40, 170, 150, 50);
		
		ImageIcon iconHome = new ImageIcon("Images/home_small.jpg");
		mainMenu = new JButton(iconHome);
		mainMenu.setBounds(210, 170, 150, 50);
		
		ImageIcon iconAvsluta = new ImageIcon("Images/b_exit_small_300x50.png");
		exit = new JButton(iconAvsluta);
		exit.setBounds(50, 250, 300, 50);
		
		nextSong = new JButton("Välj ny låt!");
		nextSong.setBounds(20,337,50,50);

		musicButton = new JButton();
		musicButton.setBounds(125, 337, 50, 50);
		musicButton.setBorderPainted(false);
		musicButton.setBorder(null);
		musicButton.setFocusable(false);
		musicButton.setMargin(new Insets(0, 0, 0, 0));
		musicButton.setContentAreaFilled(false);

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
	 * kollar om musik spelar eller inte, byter även bild till den bild som skall visas.
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
			controller.getSound();
			controller.restart();
		}
		if (e.getSource() == mainMenu) {
			controller.getSound();
			controller.home();
		}
		if (e.getSource() == exit) {
			controller.removeSettings();
		}
		if (e.getSource() == soundButton) {
			controller.stopSound();
			volumePic();
		}
		if (e.getSource() == musicButton) {
			controller.stopMusic();
			musicPic();
		}
		if (e.getSource() == nextSong){
			random();
			controller.nextSong(number);
			controller.stopMusic();
			controller.startMusic(1);
		}

	}
	
	public void random(){
		number = rand.nextInt(5);
		
	}
	
	/**
	 * Inre klass som målar upp bakgrunden på panelen.
	 * @author David
	 *
	 */
	private class BgPanel extends JPanel {
	    Image bg = new ImageIcon("Images/mario_1.jpg").getImage();
	  
	    public void paintComponent(Graphics g) {
	        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	    }
	}
}
