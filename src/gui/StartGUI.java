package gui;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.sun.prism.paint.Color;

import controller.ControllerGUI;
import controller.SoundController;

/**
 * Start menu GUI
 * @author Anders Frid
 *
 */
public class StartGUI extends JPanel implements ActionListener{
	private JButton jbtSingle, jbtMulti, jbtClose, jbtMusic, jbtFx, jbtSettings;
	private JLabel lblLogo;
	private JPanel pnlCenter = new JPanel();
//	private StartBGMusic sm = new StartBGMusic();
	private ControllerGUI controller;
	private SoundController s = new SoundController();
	

	
	public StartGUI(ControllerGUI controller, SoundController s){
		this.controller = controller;
		this.s = s;
		
		JPanel bgPanel = new BgPanel(); 
		bgPanel.setPreferredSize(new Dimension(1000,700));
		bgPanel.setLayout(null);
		
		pnlCenter.setLayout(null);
		pnlCenter.setBounds(0, 0, 1000, 700);
		pnlCenter.setOpaque(false);

		ImageIcon iconLogo = new ImageIcon("Images/logo_big_800x275.png");
		lblLogo = new JLabel(iconLogo);
		
		ImageIcon iconSingle = new ImageIcon("Images/b_singelplayer310x100.png");
		jbtSingle = new JButton(iconSingle);
		
		ImageIcon iconMulti = new ImageIcon("Images/b_multiplayer_310x100.png");
		jbtMulti = new JButton(iconMulti);
		
		ImageIcon iconClose = new ImageIcon("Images/b_exit_640x100.png");
		jbtClose = new JButton(iconClose);
		
		ImageIcon iconMusic = new ImageIcon("Images/b_volume_on_50x50.png");
		jbtMusic = new JButton(iconMusic);
		
		ImageIcon iconFx = new ImageIcon("Images/b_sfx_on_50x50.png");
		jbtFx = new JButton(iconFx);
		
		
		lblLogo.setBounds(0, 0, 1000, 300);
		
		jbtSingle.setBounds(180, 400, 310, 100);
		jbtSingle.setBorderPainted(false);
		
		jbtMulti.setBounds(510, 400, 310, 100);
		jbtMulti.setBorderPainted(false);
		
		jbtClose.setBounds(180, 520, 640, 100);
		jbtClose.setBorderPainted(false);
		

		
		jbtMusic.setBounds(10, 600, 50, 50);
		jbtMusic.setBorderPainted(false);
		jbtMusic.setBorder(null);
		jbtMusic.setFocusable(false);
		jbtMusic.setMargin(new Insets(0,0,0,0));
		jbtMusic.setContentAreaFilled(false	);
		
		jbtFx.setBounds(70, 600, 50, 50);
		jbtFx.setBorderPainted(false);
		jbtFx.setBorder(null);
		jbtFx.setFocusable(false);
		jbtFx.setMargin(new Insets(0,0,0,0));
		jbtFx.setContentAreaFilled(false);
		
		bgPanel.add(pnlCenter);
		pnlCenter.add(lblLogo);
		pnlCenter.add(jbtSingle);
		pnlCenter.add(jbtMulti);
		pnlCenter.add(jbtClose);
		pnlCenter.add(jbtMusic);
		pnlCenter.add(jbtFx);

		
		jbtSingle.addActionListener(this);
		jbtMulti.addActionListener(this);
		jbtClose.addActionListener(this);
		jbtMusic.addActionListener(this);
		jbtFx.addActionListener(this);
	
		
		
		add(bgPanel);
		
		s.startMusic();
		
	}
	public void volumePic() {
		boolean playSound = s.getSound();

		if (playSound == true) {

			ImageIcon iconSound = new ImageIcon("Images/b_sfx_on_50x50.png");
			jbtFx.setIcon(iconSound);
		} else {

			ImageIcon iconSound = new ImageIcon("Images/b_sfx_off_50x50.png");
			jbtFx.setIcon(iconSound);
		}
	}

	public void musicPic() {
		boolean playMusic = s.getMusic();

		if (playMusic == true) {

			ImageIcon iconMusic = new ImageIcon("Images/b_volume_on_50x50.png");
			jbtMusic.setIcon(iconMusic);
		} else {

			ImageIcon iconMusic = new ImageIcon("Images/b_volume_off_50x50.png");
			jbtMusic.setIcon(iconMusic);
		}
	}

	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == jbtSingle){
			controller.chooseSingle();
			s.startEffects();
		}
		if(e.getSource() == jbtMulti){
			controller.chooseMulti();
			s.startEffects();
		}
		if(e.getSource() == jbtClose){
			s.startEffects();
			System.exit(0);
		}
		if(e.getSource() == jbtMusic){
			s.stopMusic();
			musicPic();
		}
		if(e.getSource() == jbtFx){
			s.stopSound();
			volumePic();
		}
		
	}
	
//	private class StartBGMusic extends Applet { //Plays the background music
//		AudioClip audioClip;	
//		
//		public void init(){
//			try {
//				audioClip = Applet.newAudioClip( new URL( "file:\\Users\\Anders\\Pictures\\gong.au"));
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			audioClip.loop();
//		}
//    }
	
	private class BgPanel extends JPanel {
	    Image bg = new ImageIcon("Images/mario_1.jpg").getImage();
	    @Override
	    public void paintComponent(Graphics g) {
	        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	    }
	}
}
