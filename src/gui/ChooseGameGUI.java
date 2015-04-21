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
	private JLabel lblEnter = new JLabel();
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
		ImageIcon iconbtnEasy = new ImageIcon("Images/easy2.png");
		btnEasy = new JButton(iconbtnEasy);
		ImageIcon iconbtnMedium = new ImageIcon("Images/medium.png");
		btnMedium = new JButton(iconbtnMedium);
		ImageIcon iconbtnHard = new ImageIcon("Images/hard.png");
		btnHard = new JButton(iconbtnHard);
		ImageIcon iconbtnStart = new ImageIcon("Images/Start.jpg");
		btnStart = new JButton(iconbtnStart);
		ImageIcon iconbtnStandard = new ImageIcon("Images/Standard.jpg");
		btnStandard = new JButton(iconbtnStandard);
		ImageIcon iconbtnFlag = new ImageIcon("Images/Flag.jpg");
		btnFlag = new JButton(iconbtnFlag);
		ImageIcon iconbtnPlus = new ImageIcon("Images/Plus.jpg");
		btnPlus = new JButton(iconbtnPlus);
		ImageIcon iconSettings = new ImageIcon("Images/cog2.png");
		btnSettings = new JButton(iconSettings);
		
	
		btnStandard.setBounds(313, 400, 98, 76);
		btnFlag.setBounds(442, 400, 98, 76);
		btnPlus.setBounds(571, 400, 98, 76);
		btnEasy.setBounds(311, 520, 100, 40);
		btnMedium.setBounds(441, 520, 100, 40);
		btnHard.setBounds(571, 520, 100, 40);
		btnStart.setBounds(336, 590, 312, 59);
		btnSettings.setBounds(10, 10, 50, 50);

		// mainPanel
		mainPanel.setBounds(311, 30, 460, 400);
		mainPanel.setOpaque(false);
		lblTitle.setBounds(0, 0, 1000, 90);
		lblTitle.setFont(r60);

		// set settings invisible
		btnSettings.setBorderPainted(false);
		btnSettings.setBorder(null);
		btnSettings.setFocusable(false);
		btnSettings.setMargin(new Insets(0, 0, 0, 0));
		btnSettings.setContentAreaFilled(false);

		// add components
		contentPanel.add(btnStandard);
		contentPanel.add(btnPlus);
		contentPanel.add(btnFlag);
		contentPanel.add(btnEasy);
		contentPanel.add(btnMedium);
		contentPanel.add(btnHard);
		contentPanel.add(btnSettings);
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
			lblEnter.setBounds(50, 195, 220, 40);
			mainPanel.add(lblEnter);
		
			ImageIcon icontfBackground = new ImageIcon("Images/TextFieldBackground3.jpg");
			lbltfBackground = new JLabel(icontfBackground);
			lbltfBackground.setBounds(80, 230, 150, 50);
			mainPanel.add(lbltfBackground);

			// set stuff invisible
			tf.setBounds(85, 230, 140, 50);
			tf.setFont(bof18);
			tf.setBorder(null);
			tf.setMargin(new Insets(0, 0, 0, 0));
			tf.setOpaque(false);
		}
		
		// multiplayer
		else {
			ImageIcon iconMP = new ImageIcon("Images/multiplayer.png");

			lblTitle.setIcon(iconMP);
			mainPanel.add(lblTitle);
			ImageIcon iconP1 = new ImageIcon("Images/txt_player1_150x50.png");
			ImageIcon iconP2 = new ImageIcon("Images/txt_player2_150x50.png");
			lblUsernameP1.setIcon(iconP1);
			lblUsernameP2.setIcon(iconP2);

			lblUsernameP1.setBounds(0, 150, 150, 60);
			lblUsernameP2.setBounds(225, 150, 150, 60);
			mainPanel.add(tfP1);
			mainPanel.add(tfP2);
			mainPanel.add(lblUsernameP1);
			mainPanel.add(lblUsernameP2);
		}
		
		// set textfield invisible and bounds
		tfP1.setBounds(0, 200, 150, 60);
		tfP1.setBorder(null);
		tfP1.setMargin(new Insets(0, 0, 0, 0));
		tfP1.setOpaque(false);

		tfP2.setBounds(225, 200, 150, 60);
		tfP2.setBorder(null);
		tfP2.setMargin(new Insets(0, 0, 0, 0));
		tfP2.setOpaque(false);


		// actionListener
		btnSettings.addActionListener(this);
		btnEasy.addActionListener(this);
		btnMedium.addActionListener(this);
		btnHard.addActionListener(this);
		btnStart.addActionListener(this);

		add(contentPanel);
	}

	private class BgPanel extends JPanel {
		private java.awt.Image bg = new ImageIcon(
				"Images/retro3.jpg").getImage();

		@Override
		public void paintComponent(Graphics g) {
			g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
		}
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSettings) {
			System.out.println("Inställningar");
		}
		if (e.getSource() == btnEasy) {
			System.out.println("Lätt");
			controller.setLevel(0);
		}
		if (e.getSource() == btnMedium) {
			System.out.println("Medium");
			controller.setLevel(1);
		}
		if (e.getSource() == btnHard) {
			System.out.println("Svårt");
			controller.setLevel(2);
		}
		if (e.getSource() == btnStart) {
			System.out.println("Startar spelet.... INTE");
			controller.startGame();

		}

	}
}
