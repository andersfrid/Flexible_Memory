package gui;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import controller.ControllerGUI;

/*
 * @auth JGS
 */



public class ChooseGameGUI extends JPanel implements ActionListener {

	private JFrame frame = new JFrame("Flexible Memory");
	private JPanel mainPanel, contentPanel, bg;
	private JButton btnEasy, btnMedium, btnHard, btnSettings, btnStart, btnStandard, btnFlag, btnPlus;
	private JButton btnCloud = new JButton();
	private JButton btnPipe = new JButton();
	private JButton btnBush = new JButton();
	private JLabel lblLakitu = new JLabel();
	private JLabel lblFlag = new JLabel();
	private JLabel lblPlus = new JLabel();
	private JLabel lblStandard = new JLabel();
	private JLabel lblMario = new JLabel();
	private JLabel lblYoshi = new JLabel();
	private JLabel lblTitleP1 = new JLabel();
	private JLabel lblTitleP2 = new JLabel();
	private JLabel lblUsernameP1 = new JLabel();
	private JLabel lblUsernameP2 = new JLabel();
	private JLabel lblTitle = new JLabel();
	private JLabel lblError = new JLabel();
	private JLabel lblError2 = new JLabel();
	private JLabel lblArrow = new JLabel();
	private JLabel lblArrowLeft = new JLabel();
	private JLabel lbltfBackground = new JLabel();
	private JLabel lbltfBackground2 = new JLabel();
	private JLabel lblEnter = new JLabel();
	private JLabel lblTheme = new JLabel();
	private JLabel lblDifficulty = new JLabel();
	private JTextField tf = new JTextField("Enter your name here");
	private JTextField tfP1 = new JTextField("Enter Player 1's name");
	private JTextField tfP2 = new JTextField("Enter Player 2's name");
	private Font r60 = new Font("Rockwell", Font.PLAIN, 60);
	private Font p50 = new Font("Papyrus", Font.BOLD, 50);
	private Font r20 = new Font("Rockwell", Font.PLAIN, 20);
	private Font afb20 = new Font("Agency FB", Font.PLAIN, 20);
	private Color color;
	private ControllerGUI controller;
	private AudioClip cloudSound = null;
	private AudioClip pipeSound = null;
	private AudioClip bushSound = null;
	private boolean mode = false;
	private boolean theme = false;
	private boolean singleplayer;
	
	public ChooseGameGUI(ControllerGUI controller, boolean singleplayer) {
		
		
		this.controller = controller;
		this.singleplayer = singleplayer;
		
		// primaryPanel
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setPreferredSize(new Dimension(200, 200));

		// contentPanel
		contentPanel = new BgPanel();
		contentPanel.setLayout(null);
		contentPanel.setPreferredSize(new Dimension(1000, 700));

		// imageicons
		ImageIcon iconSettings = new ImageIcon("Images/cog2.png");
		btnSettings = new JButton(iconSettings);
		ImageIcon iconlblTheme = new ImageIcon("Images/Theme.png");
		lblTheme = new JLabel(iconlblTheme);
		ImageIcon iconlblArrow = new ImageIcon("Images/Arrow.png");
		lblArrow = new JLabel(iconlblArrow);
		ImageIcon iconlblArrowLeft = new ImageIcon("Images/ArrowLeft.png");
		lblArrowLeft = new JLabel(iconlblArrowLeft);
		ImageIcon iconlblError = new ImageIcon("Images/Error.png");
		lblError = new JLabel(iconlblError);
		ImageIcon iconlblError2 = new ImageIcon("Images/Error.png");
		lblError2 = new JLabel(iconlblError2);
		ImageIcon iconlblStandard = new ImageIcon("Images/StandardHeader.png");
		lblStandard = new JLabel(iconlblStandard);
		ImageIcon iconbtnStandard = new ImageIcon("Images/Standard.jpg");
		btnStandard = new JButton(iconbtnStandard);
		btnStandard.setToolTipText("A theme with random pictures (standard)");
		ImageIcon iconlblFlag = new ImageIcon("Images/FlagsHeader.png");
		lblFlag = new JLabel(iconlblFlag);
		ImageIcon iconbtnFlag = new ImageIcon("Images/Flag.jpg");
		btnFlag = new JButton(iconbtnFlag);
		btnFlag.setToolTipText("A theme with different flags");
		ImageIcon iconbtnPlus = new ImageIcon("Images/Plus.jpg");
		ImageIcon iconlblPlus = new ImageIcon("Images/PlusHeader.png");
		lblPlus = new JLabel(iconlblPlus);
		btnPlus = new JButton(iconbtnPlus);
		btnPlus.setToolTipText("A theme with math (addition)");
		ImageIcon iconlblDifficulty = new ImageIcon("Images/Difficulty.png");
		lblDifficulty = new JLabel(iconlblDifficulty);
		ImageIcon iconbtnEasy = new ImageIcon("Images/easy2.png");
		btnEasy = new JButton(iconbtnEasy);
		ImageIcon iconbtnMedium = new ImageIcon("Images/medium.png");
		btnMedium = new JButton(iconbtnMedium);
		ImageIcon iconbtnHard = new ImageIcon("Images/hard.png");
		btnHard = new JButton(iconbtnHard);
		ImageIcon iconbtnStart = new ImageIcon("Images/Start.jpg");
		btnStart = new JButton(iconbtnStart);
	
		btnSettings.setBounds(10, 10, 50, 50);
		btnCloud.setBounds(60, 300, 51, 43);
		lblTheme.setBounds(348, 200, 288, 46);
		lblStandard.setBounds(313, 245, 98, 33);
		btnStandard.setBounds(313, 275, 98, 76);
		lblFlag.setBounds(463, 245, 82, 30);
		btnFlag.setBounds(442, 275, 98, 76);
		lblPlus.setBounds(571, 245, 98, 33);
		btnPlus.setBounds(571, 275, 98, 76);
		lblDifficulty.setBounds(350, 365, 304, 39);
		btnEasy.setBounds(311, 420, 100, 40);
		btnMedium.setBounds(441, 420, 100, 40);
		btnHard.setBounds(571, 420, 100, 40);
		btnPipe.setBounds(700, 420, 200, 200);
		btnBush.setBounds(140, 570, 102, 36);
		btnStart.setBounds(336, 500, 312, 59);

		// mainPanel
		mainPanel.setBounds(311, 30, 460, 400);
		mainPanel.setOpaque(false);

		// set settings invisible
		btnSettings.setBorderPainted(false);
		btnSettings.setBorder(null);
		btnSettings.setFocusable(false);
		btnSettings.setMargin(new Insets(0, 0, 0, 0));
		btnSettings.setContentAreaFilled(false);

		btnCloud.setBorderPainted(false);
		btnCloud.setBorder(null);
		btnCloud.setFocusable(false);
		btnCloud.setMargin(new Insets(0, 0, 0, 0));
		btnCloud.setContentAreaFilled(false);

		
		btnBush.setBorderPainted(false);
		btnBush.setBorder(null);
		btnBush.setFocusable(false);
		btnBush.setMargin(new Insets(0, 0, 0, 0));
		btnBush.setContentAreaFilled(false);

		btnPipe.setBorderPainted(false);
		btnPipe.setBorder(null);
		btnPipe.setFocusable(false);
		btnPipe.setMargin(new Insets(0, 0, 0, 0));
		btnPipe.setContentAreaFilled(false);

		
		// add components
		contentPanel.add(btnSettings);
		contentPanel.add(btnCloud);
		contentPanel.add(lblTheme);
		contentPanel.add(lblStandard);
		contentPanel.add(btnStandard);
		contentPanel.add(lblFlag);
		contentPanel.add(btnFlag);
		contentPanel.add(lblPlus);
		contentPanel.add(btnPlus);
		contentPanel.add(lblDifficulty);
		contentPanel.add(btnEasy);
		contentPanel.add(btnMedium);
		contentPanel.add(btnHard);
		contentPanel.add(btnBush);
		contentPanel.add(btnPipe);
		contentPanel.add(btnStart);
		contentPanel.add(mainPanel);

		// singleplayer

		if (singleplayer == true) {

			ImageIcon iconlblTitle = new ImageIcon("Images/Title.png");
			lblTitle = new JLabel(iconlblTitle);
			lblTitle.setBounds(0, 0, 380, 90);
			mainPanel.add(tf);
			mainPanel.add(lblTitle);
			ImageIcon iconlblEnter = new ImageIcon("Images/Enter.png");
			lblEnter = new JLabel(iconlblEnter);
			lblEnter.setBounds(70, 90, 228, 64);
			mainPanel.add(lblEnter);
		
			ImageIcon icontfBackground = new ImageIcon("Images/TextFieldBackground3.jpg");
			lbltfBackground = new JLabel(icontfBackground);
			lbltfBackground.setBounds(108, 127, 150, 50);
			mainPanel.add(lbltfBackground);

			// set stuff invisible	
			
			tf.setBounds(113, 127, 140, 50);
			tf.setFont(afb20);
			tf.setBorder(null);
			tf.setMargin(new Insets(0, 0, 0, 0));
			tf.setOpaque(false);
		
			tf.setForeground(Color.DARK_GRAY);
			tf.addFocusListener(new FocusListener(){
		        public void focusGained(FocusEvent e){
		            tf.setText("");
		            tf.setForeground(Color.BLACK);
		        }

				public void focusLost(FocusEvent arg0) {
				}
		    });
		}
		
		// multiplayer
		else {
			lblTitle.setBounds(20, 0, 1000, 90);

			ImageIcon iconMP = new ImageIcon("Images/multiplayer.png");

			lblTitle.setIcon(iconMP);
			mainPanel.add(lblTitle);
			ImageIcon iconP1 = new ImageIcon("Images/Player1.png");
			ImageIcon iconP2 = new ImageIcon("Images/Player2.png");
			lblUsernameP1.setIcon(iconP1);
			lblUsernameP2.setIcon(iconP2);

			lblUsernameP1.setBounds(0, 70, 150, 60);
			lblUsernameP2.setBounds(225, 70, 150, 60);
			mainPanel.add(tfP1);
			mainPanel.add(tfP2);
			mainPanel.add(lblUsernameP1);
			mainPanel.add(lblUsernameP2);
			
			ImageIcon icontfBackground = new ImageIcon("Images/TextFieldBackground3.jpg");
			lbltfBackground = new JLabel(icontfBackground);
			lbltfBackground.setBounds(0, 105, 150, 65);
			lbltfBackground2 = new JLabel(icontfBackground);
			lbltfBackground2.setBounds(220, 105, 150, 65);
			mainPanel.add(lbltfBackground);
			mainPanel.add(lbltfBackground2);
			
			tfP1.setForeground(Color.DARK_GRAY);
			tfP1.addFocusListener(new FocusListener(){
		    
				public void focusGained(FocusEvent e){
		            tfP1.setText("");
		            tfP1.setForeground(Color.BLACK);
			        
		        }

				public void focusLost(FocusEvent notUsed) {
				}
		    });
			
			tfP2.setForeground(Color.DARK_GRAY);
			tfP2.addFocusListener(new FocusListener(){
		        
	public void focusGained(FocusEvent e){
			tfP2.setText("");
		    tfP2.setForeground(Color.BLACK);     
		    }    
		 
	public void focusLost(FocusEvent notUsed2) {
				}
		    });					
		}
		
		// set textfield invisible and bounds
		tfP1.setFont(afb20);
		tfP1.setBounds(5, 107, 140, 60);
		tfP1.setBorder(null);
		tfP1.setMargin(new Insets(0, 0, 0, 0));
		tfP1.setOpaque(false);

		tfP2.setFont(afb20);
		tfP2.setBounds(225, 107, 140, 60);
		tfP2.setBorder(null);
		tfP2.setMargin(new Insets(0, 0, 0, 0));
		tfP2.setOpaque(false);


		// actionListener
		btnSettings.addActionListener(this);
		btnCloud.addActionListener(this);
		btnEasy.addActionListener(this);
		btnMedium.addActionListener(this);
		btnHard.addActionListener(this);
		btnStart.addActionListener(this);
		btnFlag.addActionListener(this);
		btnStandard.addActionListener(this);
		btnPlus.addActionListener(this);
		btnBush.addActionListener(this);
		btnPipe.addActionListener(this);
		
		
		add(contentPanel);
	}

	private class BgPanel extends JPanel {
		private java.awt.Image bg = new ImageIcon(
				"Images/retro4.jpg").getImage();

		public void paintComponent(Graphics g) {
			g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
		}
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnStandard){
	
			theme = true;
			controller.setMode(0);

			ImageIcon iconbtnStandardSelected = new ImageIcon("Images/StandardSelected.jpg");
			btnStandard.setIcon(iconbtnStandardSelected);
			ImageIcon iconbtnFlag = new ImageIcon("Images/Flag.jpg");
			btnFlag.setIcon(iconbtnFlag);
			ImageIcon iconbtnPlus = new ImageIcon("Images/Plus.jpg");
			btnPlus.setIcon(iconbtnPlus);	
			
			controller.startSound(5);
		}
		
		if(e.getSource() == btnCloud){
			cloud();
		}
		
		
		if(e.getSource() == btnFlag){
	
			theme = true;
			controller.setMode(1);
	
			ImageIcon iconbtnFlagSelected = new ImageIcon("Images/FlagSelected.jpg");
			btnFlag.setIcon(iconbtnFlagSelected);
			ImageIcon iconbtnStandard = new ImageIcon("Images/Standard.jpg");
			btnStandard.setIcon(iconbtnStandard);
			ImageIcon iconbtnPlus = new ImageIcon("Images/Plus.jpg");
			btnPlus.setIcon(iconbtnPlus);
			
			controller.startSound(5);
			
		}
	
		if(e.getSource() == btnPlus){
			
			theme = true;
			controller.setMode(4);
		
			ImageIcon iconbtnPlusSelected = new ImageIcon("Images/PlusSelected.jpg");
			btnPlus.setIcon(iconbtnPlusSelected);
			ImageIcon iconbtnFlag = new ImageIcon("Images/Flag.jpg");
			btnFlag.setIcon(iconbtnFlag);
			ImageIcon iconbtnStandard = new ImageIcon("Images/Standard.jpg");
			btnStandard.setIcon(iconbtnStandard);
			
			controller.startSound(5);
		}
		
		if (e.getSource() == btnSettings) {
			controller.settings();
			controller.startSound(5);
		}
		
		if (e.getSource() == btnEasy) {
			ImageIcon iconbtnEasySelected = new ImageIcon("Images/EasySelected.png");
			mode = true;
	
			controller.setLevel(0);
			btnEasy.setIcon(iconbtnEasySelected);
			ImageIcon iconbtnMedium = new ImageIcon("Images/medium.png");
			btnMedium.setIcon(iconbtnMedium);
			ImageIcon iconbtnHard = new ImageIcon("Images/hard.png");
			btnHard.setIcon(iconbtnHard);
			
			controller.startSound(5);
		}
		if (e.getSource() == btnMedium) {
			mode = true;
			controller.setLevel(1);
			
			ImageIcon iconbtnMediumSelected = new ImageIcon("Images/MediumSelected.png");
			btnMedium.setIcon(iconbtnMediumSelected);
			ImageIcon iconbtnEasy = new ImageIcon("Images/easy2.png");
			btnEasy.setIcon(iconbtnEasy);
			ImageIcon iconbtnHard = new ImageIcon("Images/hard.png");
			btnHard.setIcon(iconbtnHard);
			System.out.println(tf.getText());
			
			controller.startSound(5);
		}
		
		if (e.getSource() == btnHard) {
			mode = true;
			controller.setLevel(2);
		
			ImageIcon iconbtnHardSelected = new ImageIcon("Images/HardSelected.png");	
			btnHard.setIcon(iconbtnHardSelected);
			ImageIcon iconbtnEasy = new ImageIcon("Images/easy2.png");
			btnEasy.setIcon(iconbtnEasy);
			ImageIcon iconbtnMedium = new ImageIcon("Images/medium.png");
			btnMedium.setIcon(iconbtnMedium);
			
			controller.startSound(5);
		}
		
		if (e.getSource() == btnStart) {
			
			
			String check = "Enter your name here";
			String checkP1 = "Enter Player 1's name";
			String checkP2 = "Enter Player 2's name";
					
			String username = tf.getText();
			String usernameP1 = tfP1.getText();
			String usernameP2 = tfP2.getText();
			
			if(singleplayer && username.contains(check)) {
	
				contentPanel.add(lblArrow);
				lblArrow.setBounds(300, 155, 80, 80);
				contentPanel.add(lblError);
				lblError.setBounds(100, 165, 275, 105);
	
				
			}
			
			else if(!username.contains(check) && singleplayer && username.length() <= 10 && username.length() > 0 && mode && theme){
				controller.startGame(tf.getText(), null);
				controller.startSound(5);
				
			}
			
			else if (singleplayer && !username.contains(check) && !mode && theme) {
				System.out.println("select a mode pls");
			}
			
			else if (singleplayer && !username.contains(check) && mode && !theme){
				System.out.println("select a theme pls");
			}
			
			else if (singleplayer && !username.contains(check) && !mode && !theme) {
				System.out.println("select a theme & a mode pls");
				lblArrow.setIcon(null);
				lblError.setIcon(null);
			}
			
			if(!usernameP1.contains(checkP1) && !usernameP2.contains(checkP2) && !singleplayer && usernameP1.length() 
					<= 10 && usernameP2.length() <= 10 && usernameP1.length() > 0 && usernameP2.length() > 0 && !mode && !theme){
				controller.startGame(tfP1.getText(), tfP2.getText());
				controller.startSound(5);
			}
			
			else if (!singleplayer && usernameP1.contains(checkP1) && !usernameP2.contains(checkP2)){
//				contentPanel.add(lblArrow);
//				lblArrow.setBounds(220, 150, 80, 80);
//				contentPanel.add(lblError);
//				lblError.setBounds(20, 165, 275, 105);
				
			}
			
			else if (!singleplayer && !usernameP1.contains(checkP1) && usernameP2.contains(checkP2)){
//				contentPanel.add(lblArrowLeft);
//				lblArrowLeft.setBounds(685, 100, 80, 80);
//				contentPanel.add(lblError2);
//				lblError2.setBounds(700, 100, 275, 105);
				
			}
		}

		if (e.getSource() == btnBush) {
			bush();
			
		}

		if (e.getSource() == btnPipe) {
			pipe();
			
		}
		
		
	}

	public void pipe() {
		
		SwingUtilities.invokeLater(new Runnable() {
			AudioClip pipeSound = null;

			public void run() {
					try {
						URL url = new File("Music/mario.au").toURI().toURL();
						pipeSound = Applet.newAudioClip(url);
						
						pipeSound.play();

					} catch (MalformedURLException e) {
						System.out.println(e);
					}
				}
			
		});
		ImageIcon iconlblMario = new ImageIcon("Images/Mario.png");
		lblMario = new JLabel(iconlblMario);
		lblMario.setBounds(805, 465, 39, 47);
		

		  
		contentPanel.add(lblMario);
		
	
		}

	public void bush() {
		
		SwingUtilities.invokeLater(new Runnable() {
			AudioClip bushSound = null;

			public void run() {
					try {
						URL url = new File("Music/Yoshi.au").toURI().toURL();
						bushSound = Applet.newAudioClip(url);
						
						bushSound.play();

					} catch (MalformedURLException e) {
						System.out.println(e);
					}
				}
			
		});
		ImageIcon iconlblYoshi = new ImageIcon("Images/Yoshi.png");
		lblYoshi = new JLabel(iconlblYoshi);
		

		  
		contentPanel.add(lblYoshi);
		lblYoshi.setBounds(160, 555, 39, 47);
		
	
		}
	
	public void cloud() {
		
		SwingUtilities.invokeLater(new Runnable() {
			AudioClip bushSound = null;

			public void run() {
					try {
						URL url = new File("Music/lakitu.au").toURI().toURL();
						cloudSound = Applet.newAudioClip(url);
						
						cloudSound.play();

					} catch (MalformedURLException e) {
						System.out.println(e);
					}
				}
			
		});
		
		ImageIcon iconlblLakitu = new ImageIcon("Images/Lakitu.png");
		lblLakitu = new JLabel(iconlblLakitu);
		
		contentPanel.add(lblLakitu);
		lblLakitu.setBounds(60, 210, 90, 120);
					
		
	}


}
