package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.ControllerGUI;

/**
 * @author JGS
 */

public class ChooseGameGUI extends JPanel implements ActionListener {

	private JPanel mainPanel, contentPanel;
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
	private JLabel lblUsernameP1 = new JLabel();
	private JLabel lblUsernameP2 = new JLabel();
	private JLabel lblTitle = new JLabel();
	private JLabel lblError = new JLabel();
	private JLabel lblError2 = new JLabel();
	private JLabel lblArrow = new JLabel();
	private JLabel lblArrow2 = new JLabel();
	private JLabel lblArrow3 = new JLabel();
	private JLabel lblArrowLeft = new JLabel();
	private JLabel lblErrorTheme = new JLabel();
	private JLabel lblErrorTheme2 = new JLabel();
	private JLabel lblErrorMode = new JLabel();
	private JLabel lblErrorMode2 = new JLabel();
	private JLabel lblArrowLeft2 = new JLabel();
	private JLabel lblArrowLeft3 = new JLabel();
	private JLabel lbltfBackground = new JLabel();
	private JLabel lbltfBackground2 = new JLabel();
	private JLabel lblEnter = new JLabel();
	private JLabel lblTheme = new JLabel();
	private JLabel lblDifficulty = new JLabel();
	private JTextField tf = new JTextField("Enter your name here");
	private JTextField tfP1 = new JTextField("Enter Player 1's name");
	private JTextField tfP2 = new JTextField("Enter Player 2's name");
	private Font afb20 = new Font("Agency FB", Font.PLAIN, 20);
	private ControllerGUI controller;
	private boolean mode = false;
	private boolean theme = false;
	private boolean singleplayer;
 /**
  * Constructor to know what mode is chosen in StartGUI, also paints 2 panels, one for the upper part of the screen
  * (singleplayer or multiplayer labels) and one for the lower parts (which always is the same no matter what mode is chosen
  * in StartGUI.
  * @param controller
  * @param singleplayer
  */
	public ChooseGameGUI(ControllerGUI controller, boolean singleplayer) {

		this.controller = controller;
		this.singleplayer = singleplayer;

		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setPreferredSize(new Dimension(200, 200));
		mainPanel.setBounds(311, 30, 460, 400);
		mainPanel.setOpaque(false);

		contentPanel = new BgPanel();
		contentPanel.setLayout(null);
		contentPanel.setPreferredSize(new Dimension(1000, 700));

		ImageIcon iconSettings = new ImageIcon("Images/cog2.png");
		btnSettings = new JButton(iconSettings);
		ImageIcon iconlblTheme = new ImageIcon("Images/Theme.png");
		lblTheme = new JLabel(iconlblTheme);
		ImageIcon iconlblArrow = new ImageIcon("Images/Arrow.png");
		lblArrow = new JLabel(iconlblArrow);
		lblArrow2 = new JLabel(iconlblArrow);
		lblArrow3 = new JLabel(iconlblArrow);
		ImageIcon iconlblErrorMode = new ImageIcon("Images/ErrorMode.png");
		lblErrorMode = new JLabel(iconlblErrorMode);
		lblErrorMode2 = new JLabel(iconlblErrorMode);
		ImageIcon iconlblArrowLeft = new ImageIcon("Images/ArrowLeft.png");
		lblArrowLeft = new JLabel(iconlblArrowLeft);
		ImageIcon iconlblArrowLeft2 = new ImageIcon("Images/ArrowLeft3.png");
		lblArrowLeft2 = new JLabel(iconlblArrowLeft2);
		lblArrowLeft3 = new JLabel(iconlblArrowLeft2);
		ImageIcon iconlblError = new ImageIcon("Images/Error.png");
		lblError = new JLabel(iconlblError);
		ImageIcon iconlblError2 = new ImageIcon("Images/Error.png");
		lblError2 = new JLabel(iconlblError2);
		ImageIcon iconlblErrorTheme = new ImageIcon("Images/ErrorTheme.png");
		lblErrorTheme = new JLabel(iconlblErrorTheme);
		lblErrorTheme2 = new JLabel(iconlblErrorTheme);
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

		// set things invisible
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

			ImageIcon iconMP = new ImageIcon("Images/multiplayer.png");
			ImageIcon iconP1 = new ImageIcon("Images/Player1.png");
			ImageIcon iconP2 = new ImageIcon("Images/Player2.png");
			ImageIcon icontfBackground = new ImageIcon("Images/TextFieldBackground3.jpg");

			lblTitle.setBounds(20, 0, 1000, 90);
			lblTitle.setIcon(iconMP);
			
			lblUsernameP1.setIcon(iconP1);
			lblUsernameP2.setIcon(iconP2);
			lblUsernameP1.setBounds(0, 70, 150, 60);
			lblUsernameP2.setBounds(225, 70, 150, 60);
			
			mainPanel.add(lblTitle);
			mainPanel.add(tfP1);
			mainPanel.add(tfP2);
			mainPanel.add(lblUsernameP1);
			mainPanel.add(lblUsernameP2);

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
/** 
 * @author Anders
 * Background class
 *
 */
	private class BgPanel extends JPanel {
		private java.awt.Image bg = new ImageIcon(
				"Images/retro4.jpg").getImage();
		public void paintComponent(Graphics g) {
			g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
		}
	}
	/**
	 * ActionListeners to register different events, e.g someone clicks the cloud, a sound + a picture should
	 * pop-up.
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnStandard){
			theme = true;
			controller.setMode(0);
			
			ImageIcon iconbtnStandardSelected = new ImageIcon("Images/StandardSelected.jpg");
			ImageIcon iconbtnFlag = new ImageIcon("Images/Flag.jpg");
			ImageIcon iconbtnPlus = new ImageIcon("Images/Plus.jpg");
			
			btnStandard.setIcon(iconbtnStandardSelected);
			btnFlag.setIcon(iconbtnFlag);
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
			ImageIcon iconbtnPlus = new ImageIcon("Images/Plus.jpg");
			ImageIcon iconbtnStandard = new ImageIcon("Images/Standard.jpg");
			btnFlag.setIcon(iconbtnFlagSelected);
			btnPlus.setIcon(iconbtnPlus);
			btnStandard.setIcon(iconbtnStandard);
			controller.startSound(5);
		}

		if(e.getSource() == btnPlus){

			theme = true;
			controller.setMode(4);

			ImageIcon iconbtnPlusSelected = new ImageIcon("Images/PlusSelected.jpg");
			ImageIcon iconbtnStandard = new ImageIcon("Images/Standard.jpg");
			ImageIcon iconbtnFlag = new ImageIcon("Images/Flag.jpg");
			btnPlus.setIcon(iconbtnPlusSelected);
			btnStandard.setIcon(iconbtnStandard);
			btnFlag.setIcon(iconbtnFlag);
			controller.startSound(5);
		}

		if (e.getSource() == btnSettings) {
			controller.settings();
			controller.startSound(5);
		}

		if (e.getSource() == btnEasy) {
			mode = true;

			ImageIcon iconbtnEasySelected = new ImageIcon("Images/EasySelected.png");
			ImageIcon iconbtnHard = new ImageIcon("Images/hard.png");
			ImageIcon iconbtnMedium = new ImageIcon("Images/medium.png");
			controller.setLevel(0);
			btnEasy.setIcon(iconbtnEasySelected);
			btnMedium.setIcon(iconbtnMedium);
			btnHard.setIcon(iconbtnHard);
			controller.startSound(5);
		}
		
		if (e.getSource() == btnMedium) {
			mode = true;
			
			controller.setLevel(1);
			ImageIcon iconbtnEasy = new ImageIcon("Images/easy2.png");
			ImageIcon iconbtnMediumSelected = new ImageIcon("Images/MediumSelected.png");
			ImageIcon iconbtnHard = new ImageIcon("Images/hard.png");
			btnEasy.setIcon(iconbtnEasy);
			btnMedium.setIcon(iconbtnMediumSelected);
			btnHard.setIcon(iconbtnHard);
			controller.startSound(5);
		}
		if (e.getSource() == btnHard) {
			mode = true;
			controller.setLevel(2);

			ImageIcon iconbtnEasy = new ImageIcon("Images/easy2.png");
			ImageIcon iconbtnMedium = new ImageIcon("Images/medium.png");
			ImageIcon iconbtnHardSelected = new ImageIcon("Images/HardSelected.png");	
			btnEasy.setIcon(iconbtnEasy);
			btnMedium.setIcon(iconbtnMedium);
			btnHard.setIcon(iconbtnHardSelected);
			controller.startSound(5);
		}
		if (e.getSource() == btnStart) {
			//Singleplayer
			String check = "Enter your name here";
			String username = tf.getText();
			
			if(!username.contains(check) && singleplayer && username.length() <= 10 && username.length() > 0
					&& mode && theme){
				controller.startGame(tf.getText(), null);
				controller.startSound(5);
			}
			else if(singleplayer && username.contains(check) || username.length() < 1) {
				ImageIcon iconlblArrow = new ImageIcon("Images/Arrow.png");
				lblArrow.setIcon(iconlblArrow);
				ImageIcon iconlblError = new ImageIcon("Images/Error.png");
				lblError.setIcon(iconlblError);
				lblArrow.setBounds(300, 155, 80, 80);
				contentPanel.add(lblArrow);
 				contentPanel.add(lblError);
				lblError.setBounds(100, 165, 275, 105);
				System.out.println("namn = fel");	}
			else if (singleplayer && username.length() > 10) {
				ImageIcon iconlblArrow = new ImageIcon("Images/Arrow.png");
				lblArrow.setIcon(iconlblArrow);
				ImageIcon iconlblError = new ImageIcon("Images/Error.png");
				lblError.setIcon(iconlblError);
				lblArrow.setBounds(300, 155, 80, 80);
				contentPanel.add(lblArrow);
 				contentPanel.add(lblError);
				lblError.setBounds(100, 165, 275, 105);
				System.out.println("namn = fel");
				}
			else if (singleplayer && username.length() < 10 && !username.contains(check) && username.length() > 0 && !theme) {
				lblArrow.setIcon(null);
				lblError.setIcon(null);
				lblArrow.setIcon(null);
				lblError.setIcon(null);
				lblArrowLeft2.setIcon(null);
				errorTheme();
				System.out.println("theme = fel");
			}
			else if (singleplayer && username.length() < 10 && !username.contains(check) && username.length() > 0 && theme && !mode) {
				
				lblArrow.setIcon(null);
				lblError.setIcon(null);
				lblArrowLeft3.setIcon(null);
				lblErrorTheme2.setIcon(null);
				
				errorMode();
			}
			else if (singleplayer && !username.contains(check) && !mode && !theme) {
				System.out.println("select a theme & a mode pls");
				lblArrow.setIcon(null);
				lblError.setIcon(null);
			}
			//Multiplayer
			String checkP1 = "Enter Player 1's name";
			String checkP2 = "Enter Player 2's name";
			String usernameP1 = tfP1.getText();
			String usernameP2 = tfP2.getText();
			if(!usernameP1.contains(checkP1) && !usernameP2.contains(checkP2) && !singleplayer && 
					usernameP1.length() <= 10 && usernameP2.length() <= 10 && usernameP1.length() > 0 && 
					usernameP2.length() > 0 && mode && theme){
				controller.startGame(tfP1.getText(), tfP2.getText());
				controller.startSound(5);
			}
			else if (!singleplayer && !usernameP1.contains(checkP1) && usernameP2.contains(checkP2) && 
					usernameP1.length() > 0){
				lblArrow.setIcon(null);
				lblError.setIcon(null);
				errortfP2();				
			}
			else if (!singleplayer && !usernameP2.contains(checkP2) && usernameP1.contains(checkP1) && 
					usernameP2.length() > 0){
				lblArrowLeft.setIcon(null);
				lblError2.setIcon(null);
				errortfP1();
			}
			else if (!singleplayer && usernameP1.contains(checkP1) && usernameP2.contains(checkP2)){
				errortfP1();	
				errortfP2();
			}
			else if (!singleplayer && !theme && !usernameP1.contains(checkP1) && !usernameP2.contains(checkP2)
			&& usernameP1.length() > 0 && usernameP2.length() > 0) {
				lblArrow.setIcon(null);
				lblError.setIcon(null);
				lblArrowLeft.setIcon(null);
				lblError2.setIcon(null);
				errorTheme();
			}
			else if (!singleplayer && !mode && !usernameP1.contains(checkP1) && !usernameP2.contains(checkP2)
					&& usernameP1.length() > 0 && usernameP2.length() > 0){
				lblArrowLeft2.setIcon(null);
				lblErrorTheme.setIcon(null);
				errorMode();		
			}
			controller.repaintSettings();
		}
		if (e.getSource() == btnBush) {
			bush();	
		}
		if (e.getSource() == btnPipe) {
			pipe();	
		}
	}
	public void pipe() {
		controller.startSound(8);
		ImageIcon iconlblMario = new ImageIcon("Images/Mario.png");
		lblMario = new JLabel(iconlblMario);
		lblMario.setBounds(805, 465, 39, 47);
		contentPanel.add(lblMario);
	}
	public void bush() {
		controller.startSound(7);
		ImageIcon iconlblYoshi = new ImageIcon("Images/Yoshi.png");
		lblYoshi = new JLabel(iconlblYoshi);
		contentPanel.add(lblYoshi);
		lblYoshi.setBounds(160, 555, 39, 47);
	}
	public void cloud() {
		controller.startSound(6);
		ImageIcon iconlblLakitu = new ImageIcon("Images/Lakitu.png");
		lblLakitu = new JLabel(iconlblLakitu);
		contentPanel.add(lblLakitu);
		lblLakitu.setBounds(60, 210, 90, 120);
	}
	public void errortfP1() {
		contentPanel.add(lblArrow);
		lblArrow.setBounds(220, 150, 80, 80);
		contentPanel.add(lblError);
		lblError.setBounds(20, 165, 275, 105);
	}
	public void errortfP2() {
		contentPanel.add(lblArrowLeft);
		lblArrowLeft.setBounds(685, 100, 80, 80);
		contentPanel.add(lblError2);
		lblError2.setBounds(700, 100, 275, 105);
		}
	public void errorMode() {
	if(!singleplayer) {
		contentPanel.add(lblArrow2);
		lblArrow2.setBounds(215, 430, 80, 80);
		contentPanel.add(lblErrorMode);
		lblErrorMode.setBounds(100, 455, 150, 93);
	}	
	else 
		contentPanel.add(lblArrow3);
		lblArrow3.setBounds(215, 430, 80, 80);
		contentPanel.add(lblErrorMode2);
		lblErrorMode2.setBounds(100, 455, 150, 93);	
	
}	
	public void errorTheme() {
		if(!singleplayer) {
		contentPanel.add(lblArrowLeft2);
		lblArrowLeft2.setBounds(680, 280, 80, 80);
		contentPanel.add(lblErrorTheme);
		lblErrorTheme.setBounds(720, 305, 150, 76);
		}
	
	else {
		contentPanel.add(lblArrowLeft3);
		lblArrowLeft3.setBounds(680, 280, 80, 80);
		contentPanel.add(lblErrorTheme2);
		lblErrorTheme2.setBounds(720, 305, 150, 76);		
		}
	}
}