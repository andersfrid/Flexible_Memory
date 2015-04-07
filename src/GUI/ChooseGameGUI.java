package GUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ChooseGameGUI extends JPanel {
	
	private JFrame frame = new JFrame("Flexible Memory");
	private JPanel mainPanel, contentPanel;
	private JButton btnEasy = new JButton("Easy");
	private JButton btnMedium = new JButton("Medium");
	private JButton btnHard = new JButton("Hard");
	private JButton btnSettings = new JButton("X");
	private JButton btnStart = new JButton("Start Game!");
	private JLabel lblTitle = new JLabel("Flexible Memory");
	private Font r28 = new Font("Rockwell", Font.PLAIN, 40);
	private Font p28 = new Font("Papyrus", Font.BOLD, 50);	
	private Border blackline, raisedetched, loweredetched,
    raisedbevel, loweredbevel, empty;
	
	ChooseGameGUI() {
		
			setPreferredSize(new Dimension(800, 800));
			
		//primaryPanel
			mainPanel = new JPanel();
			mainPanel.setLayout(null);
			mainPanel.setPreferredSize(new Dimension(800, 800));
			
		
		//secondaryPanel
			contentPanel = new JPanel();
			contentPanel.setLayout(null);
			contentPanel.setPreferredSize( new Dimension(800, 800));
			btnEasy.setBounds(200, 200, 100, 40);
			btnMedium.setBounds(350, 200, 100, 40);
			btnHard.setBounds(500, 200, 100, 40);
			btnSettings.setBounds(10, 20, 50, 50);
			btnStart.setBounds(225, 300, 370, 110);
			lblTitle.setBounds(250, 30, 1000, 90);
			lblTitle.setFont(r28);
			btnStart.setFont(p28);
			lblTitle.setBorder(blackline);
			contentPanel.add(btnEasy);
			contentPanel.add(btnMedium);
			contentPanel.add(btnHard);
			contentPanel.add(lblTitle);
			contentPanel.add(btnSettings);
			contentPanel.add(btnStart);
		//southPanel
		
		
		//mainPanel	
			mainPanel.add(contentPanel);
		//Frame
			frame = new JFrame("Flexible Memory");
			frame.setPreferredSize(new Dimension(1000, 700));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.add(mainPanel);
			frame.add(contentPanel);
			frame.pack();
	}
	
	
	
	public static void main(String[] args) {
		new ChooseGameGUI();
	}
}
