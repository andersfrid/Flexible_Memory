package GUI;


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








/*
 * @auth JGS
 */

public class ChooseGameGUI extends JPanel implements ActionListener {
	
	private JFrame frame = new JFrame("Flexible Memory");
	private JPanel mainPanel, contentPanel, bg, centerPanel;
	private JButton btnEasy = new JButton("Easy");
	private JButton btnMedium = new JButton("Medium");
	private JButton btnHard = new JButton("Hard");
	private JButton btnStart = new JButton("Start Game!");
	private JButton btnSettings;
	private JLabel lblTitleP1 = new JLabel();
	private JLabel lblTitleP2 = new JLabel();
	private JLabel lblUsername = new JLabel();
	private JLabel lblUsernameP1 = new JLabel();
	private JLabel lblUsernameP2 = new JLabel();
	private JLabel lblTitle = new JLabel();
	private JTextField tf = new JTextField();
	private JTextField tfP1 = new JTextField("Enter Player 1's name");
	private JTextField tfP2 = new JTextField("Enter Player 2's name");
	private Font r60 = new Font("Rockwell", Font.PLAIN, 60);
	private Font p50 = new Font("Papyrus", Font.BOLD, 50);
	private Font r20 = new Font("Rockwell", Font.PLAIN, 20);
	private Border blackline, raisedetched, loweredetched,
    raisedbevel, loweredbevel, empty;
	
	public ChooseGameGUI() {
		
//		JPanel bgpanel = new BgPanel(); 
//		bgpanel.setLayout(null);
//		bgpanel.setBounds(0, 0, 1000, 700);
//			setPreferredSize(new Dimension(800, 800));
			
		//primaryPanel
			mainPanel = new JPanel();
			mainPanel.setLayout(null);
			mainPanel.setPreferredSize(new Dimension(200, 200));
			
		
		//contentPanel
			contentPanel = new BgPanel();
			contentPanel.setLayout(null);
			contentPanel.setPreferredSize( new Dimension(1000, 700));
			
			btnEasy.setBounds(311, 420, 100, 40);
			btnMedium.setBounds(441, 420, 100, 40);
			btnHard.setBounds(571, 420, 100, 40);
			btnStart.setBounds(311, 540, 360, 110);
			btnStart.setFont(p50);
			ImageIcon iconSettings = new ImageIcon("Images/cog2.png");
			btnSettings = new JButton(iconSettings);
			btnSettings.setBounds(10, 10, 50, 50);
			

		//mainPanel
			mainPanel.setBounds(311, 30, 460, 400);
			mainPanel.setOpaque(false);
			lblUsername.setBounds(50, 150, 1500, 95);
			lblUsername.setFont(r20);
			lblTitle.setBounds(0, 0, 1000, 90);
			lblTitle.setFont(r60);

		//set settings invisible
			btnSettings.setBorderPainted(false);
			btnSettings.setBorder(null);
			btnSettings.setFocusable(false);
			btnSettings.setMargin(new Insets(0, 0, 0, 0));
			btnSettings.setContentAreaFilled(false);
			
			
			//add components
			contentPanel.add(btnEasy);
			contentPanel.add(btnMedium);
			contentPanel.add(btnHard);
			contentPanel.add(btnSettings);
			contentPanel.add(btnStart);
			contentPanel.add(mainPanel);
			
		//singleplayer
			boolean singleplayer = false;
			
			if(singleplayer == true) {	
				lblTitle.setText("Singleplayer");
			mainPanel.add(lblTitle);
				lblUsername.setText("Enter your name below");
			mainPanel.add(tf);
			mainPanel.add(lblUsername);
			//set stuff invisible
			tf.setBounds(100, 200, 150, 60);
			tf.setBorder(null);
			tf.setMargin(new Insets(0, 0, 0, 0));
			tf.setOpaque(false);
			}
			
			
		//multiplayer	
			else{
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
			
			//set textfield invisible and bounds	
				tfP1.setBounds(0, 200, 150, 60);
				tfP1.setBorder(null);
				tfP1.setMargin(new Insets(0, 0, 0, 0));
				tfP1.setOpaque(false);
			
				tfP2.setBounds(225, 200, 150, 60);
				tfP2.setBorder(null);
				tfP2.setMargin(new Insets(0, 0, 0, 0));
				tfP2.setOpaque(false);
				
				
				mainPanel.add(lblUsernameP1);
				mainPanel.add(lblUsernameP2);
			}
			
			
			
			//actionListener
			btnSettings.addActionListener(this);
			btnEasy.addActionListener(this);
			btnMedium.addActionListener(this);
			btnHard.addActionListener(this);
			btnStart.addActionListener(this);
			
			add(contentPanel);
			
		//Frame
			frame = new JFrame("Flexible Memory");
			frame.setPreferredSize(new Dimension(1000, 700));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.add(contentPanel);
			frame.pack();
	}
	
	private class BgPanel extends JPanel {
	  private  java.awt.Image bg = new ImageIcon("Images/chooserBackground.jpg").getImage();
	    @Override
	    public void paintComponent(Graphics g) {
	        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	    }
	}
	
	
	
		
	public static void main(String[] args) {
		new ChooseGameGUI();
	}

	public void actionPerformed (ActionEvent e){
		if (e.getSource() == btnSettings) {
			System.out.println("Inställningar");
		}
		
		if (e.getSource() == btnEasy) {
			System.out.println("Lätt");
			
		}
		if (e.getSource() == btnMedium) {
			System.out.println("Medium");
			
		}
		if (e.getSource() == btnHard) {
			System.out.println("Svårt");
			
		}
		if (e.getSource() == btnStart) {
			System.out.println("Startar spelet.... INTE");
			
		}
		
		
	}
}
