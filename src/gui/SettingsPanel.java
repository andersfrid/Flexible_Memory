package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.ControllerGUI;
import controller.SoundController;

public class SettingsPanel extends JPanel implements ActionListener {
	private JPanel panel;
	private JLabel logo;
	private JButton musicButton, soundButton, restartButton, mainMenu, exit;
	private JFrame frame;
	private ControllerGUI controller;
	private SoundController s;

	public SettingsPanel(ControllerGUI controller, SoundController s) {
		this.controller = controller;
		this.s = s;

		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(400, 400));
		panel.setBackground(Color.LIGHT_GRAY);

		logo = new JLabel("FLEXIBLE MEMORY" + "\n" + "Inställningar");
		logo.setBounds(150, 10, 200, 50);

		restartButton = new JButton("STARTA OM");
		restartButton.setBounds(40, 160, 150, 75);
		mainMenu = new JButton("HUVUD MENYN");
		mainMenu.setBounds(210, 160, 150, 75);
		exit = new JButton("AVSLUTA");
		exit.setBounds(50, 250, 300, 75);

		ImageIcon iconMusic = new ImageIcon("Images/b_volume_on_50x50.png");
		musicButton = new JButton(iconMusic);
		musicButton.setBounds(125, 337, 50, 50);
		musicButton.setBorderPainted(false);
		musicButton.setBorder(null);
		musicButton.setFocusable(false);
		musicButton.setMargin(new Insets(0, 0, 0, 0));
		musicButton.setContentAreaFilled(false);
		ImageIcon iconSound = new ImageIcon("Images/b_sfx_on_50x50.png");
		soundButton = new JButton(iconSound);
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
		panel.add(musicButton);
		panel.add(soundButton);

		frame = new JFrame("Inställningar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);

		restartButton.addActionListener(this);
		mainMenu.addActionListener(this);
		exit.addActionListener(this);
		soundButton.addActionListener(this);
		musicButton.addActionListener(this);
		
		s.startMusic();

	}

	public void volumePic() {
		boolean playSound = s.getSound();

		if (playSound == true) {

			ImageIcon iconSound = new ImageIcon("Images/b_sfx_on_50x50.png");
			soundButton.setIcon(iconSound);
		} else {

			ImageIcon iconSound = new ImageIcon("Images/b_sfx_off_50x50.png");
			soundButton.setIcon(iconSound);
		}
	}

	public void musicPic() {
		boolean playMusic = s.getMusic();

		if (playMusic == true) {

			ImageIcon iconMusic = new ImageIcon("Images/b_volume_on_50x50.png");
			musicButton.setIcon(iconMusic);
		} else {

			ImageIcon iconMusic = new ImageIcon("Images/b_volume_off_50x50.png");
			musicButton.setIcon(iconMusic);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == restartButton) {
			s.startEffects();
		}
		if (e.getSource() == mainMenu) {
			s.startEffects();
		}
		if (e.getSource() == exit) {
			System.exit(0);
		}
		if (e.getSource() == soundButton) {
			s.stopSound();
			volumePic();
		}
		if (e.getSource() == musicButton) {
			s.stopMusic();
			musicPic();
		}

	}

}
