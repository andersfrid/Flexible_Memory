package gui;

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
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.ControllerGUI;

/*
 * @auth JGS
 */

public class ChooseGameGUI extends JPanel implements ActionListener {

	private JFrame frame = new JFrame("Flexible Memory");
	private JPanel mainPanel, contentPanel, bg;
	private JButton btnEasy, btnMedium, btnHard, btnSettings, btnStart, btnStandard, btnFlag, btnPlus;
	private JLabel lblTitleP1 = new JLabel();
	private JLabel lblTitleP2 = new JLabel();
	private JLabel lblUsernameP1 = new JLabel();
	private JLabel lblUsernameP2 = new JLabel();
	private JLabel lblTitle = new JLabel();
	private JLabel lbltfBackground = new JLabel();
	private JLabel lbltfBackground2 = new JLabel();
	private JLabel lblEnter = new JLabel();
	private JLabel lblTheme = new JLabel();
	private JLabel lblDifficulty = new JLabel();
	private JTextField tf = new JTextField();
	private JTextField tfP1 = new JTextField("Enter Player 1's name");
	private JTextField tfP2 = new JTextField("Enter Player 2's name");
	private Font r60 = new Font("Rockwell", Font.PLAIN, 60);
	private Font p50 = new Font("Papyrus", Font.BOLD, 50);
	private Font r20 = new Font("Rockwell", Font.PLAIN, 20);
	private Font bof18 = new Font("Baskerville Old Face", Font.BOLD, 18);

	private Border blackline, raisedetched, loweredetched, raisedbevel,
			loweredbevel, empty;
	private boolean singlePlayer;
	private ControllerGUI controller;

	public ChooseGameGUI(ControllerGUI controller, boolean singlePlayer) {

		this.singlePlayer = singlePlayer;
		this.controller = controller;
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
		ImageIcon iconbtnStandard = new ImageIcon("Images/Standard.jpg");
		btnStandard = new JButton(iconbtnStandard);
		ImageIcon iconbtnFlag = new ImageIcon("Images/Flag.jpg");
		btnFlag = new JButton(iconbtnFlag);
		ImageIcon iconbtnPlus = new ImageIcon("Images/Plus.jpg");
		btnPlus = new JButton(iconbtnPlus);
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
		lblTheme.setBounds(340, 210, 288, 46);
		btnStandard.setBounds(313, 275, 98, 76);
		btnFlag.setBounds(442, 275, 98, 76);
		btnPlus.setBounds(571, 275, 98, 76);
		lblDifficulty.setBounds(350, 360, 304, 39);
		btnEasy.setBounds(311, 420, 100, 40);
		btnMedium.setBounds(441, 420, 100, 40);
		btnHard.setBounds(571, 420, 100, 40);
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

		// add components
		contentPanel.add(btnSettings);
		contentPanel.add(lblTheme);
		contentPanel.add(btnStandard);
		contentPanel.add(btnFlag);
		contentPanel.add(btnPlus);
		contentPanel.add(lblDifficulty);
		contentPanel.add(btnEasy);
		contentPanel.add(btnMedium);
		contentPanel.add(btnHard);
		contentPanel.add(btnStart);
		contentPanel.add(mainPanel);

		// singleplayer

		if (singlePlayer == true) {

			
			
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
			lbltfBackground.setBounds(105, 127, 150, 50);
			mainPanel.add(lbltfBackground);

			// set stuff invisible
			tf.setBounds(110, 130, 140, 50);
			tf.setFont(bof18);
			tf.setBorder(null);
			tf.setMargin(new Insets(0, 0, 0, 0));
			tf.setOpaque(false);
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
			
		}
		
		// set textfield invisible and bounds
		tfP1.setBounds(5, 110, 150, 60);
		tfP1.setBorder(null);
		tfP1.setMargin(new Insets(0, 0, 0, 0));
		tfP1.setOpaque(false);

		tfP2.setBounds(225, 110, 150, 60);
		tfP2.setBorder(null);
		tfP2.setMargin(new Insets(0, 0, 0, 0));
		tfP2.setOpaque(false);


		// actionListener
		btnSettings.addActionListener(this);
		btnEasy.addActionListener(this);
		btnMedium.addActionListener(this);
		btnHard.addActionListener(this);
		btnStart.addActionListener(this);
		btnFlag.addActionListener(this);
		btnStandard.addActionListener(this);
		btnPlus.addActionListener(this);

		add(contentPanel);
	}

	private class BgPanel extends JPanel {
		private java.awt.Image bg = new ImageIcon(
				"Images/retro4.jpg").getImage();

		@Override
		public void paintComponent(Graphics g) {
			g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
		}
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnStandard){
	controller.setMode(0);
	
	ImageIcon iconbtnStandardSelected = new ImageIcon("Images/StandardSelected.jpg");
	btnStandard.setIcon(iconbtnStandardSelected);
	ImageIcon iconbtnFlag = new ImageIcon("Images/Flag.jpg");
	btnFlag.setIcon(iconbtnFlag);
	ImageIcon iconbtnPlus = new ImageIcon("Images/Plus.jpg");
	btnPlus.setIcon(iconbtnPlus);
	
		
		}
		
		if(e.getSource() == btnFlag){
			System.out.println("FLAGGOR!!");
			controller.setMode(1);
	
			ImageIcon iconbtnFlagSelected = new ImageIcon("Images/FlagSelected.jpg");
			btnFlag.setIcon(iconbtnFlagSelected);
			ImageIcon iconbtnStandard = new ImageIcon("Images/Standard.jpg");
			btnStandard.setIcon(iconbtnStandard);
			ImageIcon iconbtnPlus = new ImageIcon("Images/Plus.jpg");
			btnPlus.setIcon(iconbtnPlus);
			
		}
	
		if(e.getSource() == btnPlus){
			controller.setMode(4);
			ImageIcon iconbtnPlusSelected = new ImageIcon("Images/PlusSelected.jpg");
			btnPlus.setIcon(iconbtnPlusSelected);
			ImageIcon iconbtnFlag = new ImageIcon("Images/Flag.jpg");
			btnFlag.setIcon(iconbtnFlag);
			ImageIcon iconbtnStandard = new ImageIcon("Images/Standard.jpg");
			btnStandard.setIcon(iconbtnStandard);
			
		}
		
		if (e.getSource() == btnSettings) {
			System.out.println("Inställningar");
		}
		if (e.getSource() == btnEasy) {
			ImageIcon iconbtnEasySelected = new ImageIcon("Images/EasySelected.png");
			
	
			controller.setLevel(0);
			btnEasy.setIcon(iconbtnEasySelected);
			ImageIcon iconbtnMedium = new ImageIcon("Images/medium.png");
			btnMedium.setIcon(iconbtnMedium);
			ImageIcon iconbtnHard = new ImageIcon("Images/hard.png");
			btnHard.setIcon(iconbtnHard);
		}
		if (e.getSource() == btnMedium) {
			ImageIcon iconbtnMediumSelected = new ImageIcon("Images/MediumSelected.png");
			
			controller.setLevel(1);
			btnMedium.setIcon(iconbtnMediumSelected);
			ImageIcon iconbtnEasy = new ImageIcon("Images/easy2.png");
			btnEasy.setIcon(iconbtnEasy);
			ImageIcon iconbtnHard = new ImageIcon("Images/hard.png");
			btnHard.setIcon(iconbtnHard);
			}
		if (e.getSource() == btnHard) {
			ImageIcon iconbtnHardSelected = new ImageIcon("Images/HardSelected.png");
			
			controller.setLevel(2);
			btnHard.setIcon(iconbtnHardSelected);
			ImageIcon iconbtnEasy = new ImageIcon("Images/easy2.png");
			btnEasy.setIcon(iconbtnEasy);
			ImageIcon iconbtnMedium = new ImageIcon("Images/medium.png");
			btnMedium.setIcon(iconbtnMedium);
			}
		if (e.getSource() == btnStart) {
			System.out.println("Startar spelet.... INTE");
			controller.startGame();

		}

	}
}
