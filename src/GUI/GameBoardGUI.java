package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * 
 * @author David
 *
 */
public class GameBoardGUI extends JPanel implements ActionListener{
	private JLabel playerOneName, playerTwoName, scorePlayerOne, scorePlayerTwo, level, logo;
	private JPanel mainPanel, northPanel, gameArea;
	private JFrame frame;
	private JButton button;
	private JButton[] buttons = new JButton[40];
	private int i;
	
	public GameBoardGUI(){
		//panels
		mainPanel = new BackgroundPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setPreferredSize(new Dimension(1000,700));
		
		northPanel = new JPanel();
		northPanel.setPreferredSize(new Dimension(1000,200));
		northPanel.setLayout(null);
		northPanel.setOpaque(false);
		
		mainPanel.add(northPanel, BorderLayout.NORTH);
		
		//labels
		ImageIcon iconPlayer1 = new ImageIcon("Images/txt_player1_150x50.png");
		playerOneName = new JLabel(iconPlayer1);
		playerOneName.setBounds(50, 10, 150, 50);
		
		ImageIcon iconLogo = new ImageIcon("Images/logo_small_550x75.png");
		logo = new JLabel(iconLogo);
		logo.setBounds(225, 10, 550, 75);
		
		ImageIcon iconPlayer2 = new ImageIcon("Images/txt_player2_150x50.png");
		playerTwoName = new JLabel(iconPlayer2);
		playerTwoName.setBounds(800, 10, 150, 50);
		
		ImageIcon iconScore1 = new ImageIcon("Images/txt_score_150x50.png");
		scorePlayerOne = new JLabel(iconScore1);
		scorePlayerOne.setBounds(50, 100, 150, 50);
		
		ImageIcon iconLevel = new ImageIcon("Images/txt_medium_200x50.png");
		level = new JLabel(iconLevel);
		level.setBounds(400, 100, 200, 50);
		
		ImageIcon iconScore2 = new ImageIcon("Images/txt_score_150x50.png");
		scorePlayerTwo = new JLabel(iconScore2);
		scorePlayerTwo.setBounds(800, 100, 150, 50);
		
		//button
//		ImageIcon iconKogg = new ImageIcon("Images/kogg.jpg");
//		button = new JButton(iconKogg);
//		button.setBounds(50, 75, 50, 50);
		
		//Gamepanel
		gameArea = new JPanel();
		gameArea.setLayout(new GridLayout(5,8,4,4));
		gameArea.setPreferredSize(new Dimension(100,100));
		gameArea.setOpaque(false);

		ImageIcon cards = new ImageIcon("Images/card_95x120.jpg");
		for(i =0; i<buttons.length; i++){
			buttons[i] = new JButton(cards);
			buttons[i].setSize(95, 120);
			gameArea.add(buttons[i]);
			
		}
		mainPanel.add(gameArea, BorderLayout.CENTER);
		
		northPanel.add(playerOneName);
		northPanel.add(logo);
		northPanel.add(playerTwoName);
		northPanel.add(scorePlayerOne);
		northPanel.add(level);
		northPanel.add(scorePlayerTwo);
//		northPanel.add(button);
		
		
		add(mainPanel);
		
//		frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setResizable(false);
//		frame.add(mainPanel);
//		frame.pack();
//		frame.setVisible(true);

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button){
			
		}
		
	}
	
	
	
	private class BackgroundPanel extends JPanel {
		private Image backGround = new ImageIcon("Images/mario_1.jpg").getImage();
	 
		public void paintComponent(Graphics g) {
	        g.drawImage(backGround, 0, 0, getWidth(), getHeight(), this);
	    }
	}
		
//	public static void main(String[]args){
//		SwingUtilities.invokeLater(
//				new Runnable(){
//					public void run(){
//						new GameBoardGUI();
//						
//			}
//		});	
//	}
}