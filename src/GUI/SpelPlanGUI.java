package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SpelPlanGUI extends JPanel{
	private JLabel playerOneName, playerTwoName, scorePlayerOne, scorePlayerTwo, level, logo;
	private JPanel panel, northPanel;
	private JFrame frame;
	private JButton button;

	public SpelPlanGUI(){
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(1000,700));
		panel.setBackground(Color.WHITE);
		
		northPanel = new JPanel();
		northPanel.setPreferredSize(new Dimension(1000,200));
		northPanel.setBackground(Color.LIGHT_GRAY);
		northPanel.setLayout(null);
		
		panel.add(northPanel, BorderLayout.NORTH);
		
		playerOneName = new JLabel("PLAYER ONE");
		playerOneName.setBounds(150, 10, 250, 100);
		logo = new JLabel("FLEXIBLE MEMORY!!!!!!!!!!!!");
		logo.setBounds(300, 10, 500, 100);
		playerTwoName = new JLabel("PLAYER TWO");
		playerTwoName.setBounds(550, 10, 750, 100);
		scorePlayerOne = new JLabel("Score: 0");
		scorePlayerOne.setBounds(160, 100, 250, 100);
		level = new JLabel("Vilken nivå du spelar");
		level.setBounds(300, 100, 500, 100);
		scorePlayerTwo = new JLabel("Score: 10");
		scorePlayerTwo.setBounds(550, 100, 750, 100);
		
		button = new RoundButton("KUGGHJUL");
		button.setBounds(50, 75, 50, 50);
		
		northPanel.add(playerOneName);
		northPanel.add(logo);
		northPanel.add(playerTwoName);
		northPanel.add(scorePlayerOne);
		northPanel.add(level);
		northPanel.add(scorePlayerTwo);
		northPanel.add(button);

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
		
	public static void main(String[]args){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						new SpelPlanGUI();
						
			}
		});
		
	}
}