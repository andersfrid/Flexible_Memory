package GUI;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
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
	private JPanel MainPanel, northPanel;
	private JFrame frame;
	private JButton button;
	
	public GameBoardGUI(){
		//panels
		MainPanel = new BackgroundPanel();
		MainPanel.setLayout(new BorderLayout());
		MainPanel.setPreferredSize(new Dimension(1000,700));
		
		northPanel = new JPanel();
		northPanel.setPreferredSize(new Dimension(1000,200));
		northPanel.setLayout(null);
		northPanel.setOpaque(false);
		
		MainPanel.add(northPanel, BorderLayout.NORTH);
		//labels
		playerOneName = new JLabel("PLAYER ONE");
		playerOneName.setBounds(150, 10, 250, 100);
		ImageIcon iconLogo = new ImageIcon("Images/logo_smal_550x75.png");
		logo = new JLabel(iconLogo);
		logo.setBounds(300, 10, 550, 75);
		playerTwoName = new JLabel("PLAYER TWO");
		playerTwoName.setBounds(550, 10, 750, 100);
		scorePlayerOne = new JLabel("Score: 0");
		scorePlayerOne.setBounds(160, 100, 250, 100);
		level = new JLabel("Vilken nivå du spelar");
		level.setBounds(300, 100, 500, 100);
		scorePlayerTwo = new JLabel("Score: 10");
		scorePlayerTwo.setBounds(550, 100, 750, 100);
		//button
		button = new RoundButton("KUGGHJUL");
		button.setBounds(50, 75, 50, 50);
		
		northPanel.add(playerOneName);
		northPanel.add(logo);
		northPanel.add(playerTwoName);
		northPanel.add(scorePlayerOne);
		northPanel.add(level);
		northPanel.add(scorePlayerTwo);
		northPanel.add(button);
		//frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(MainPanel);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button){
			
		}
		
	}
	
	private class BackgroundPanel extends JPanel {
		private Image backGround = new ImageIcon("Images/mario.jpg").getImage();
	 
		public void paintComponent(Graphics g) {
	        g.drawImage(backGround, 0, 0, getWidth(), getHeight(), this);
	    }
	}
		
	public static void main(String[]args){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						new GameBoardGUI();
						
			}
		});	
	}
}