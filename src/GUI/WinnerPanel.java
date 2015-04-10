package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class WinnerPanel extends JPanel {
	private JPanel panel;
	private JLabel label, logo;
	private JButton startOver, home;
	private JFrame frame;
	
	public WinnerPanel(){
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setPreferredSize(new Dimension(700,700));
		panel.setLayout(null);
		
		label = new JLabel("WINNER WINNER CHICKEN DINNER:");
		label.setBounds(200, 300, 550, 100);
		ImageIcon iconLogo = new ImageIcon("Images/logo_smal_550x75.png");
		logo = new JLabel(iconLogo);
		logo.setBounds(75, 50, 550, 75);
		
		startOver = new JButton("RESTART GAME");
		startOver.setBounds(25, 500, 310, 100);
		
		home = new JButton("HOME");
		home.setBounds(365, 500, 310, 100);
		
		panel.add(label);
		panel.add(logo);
		panel.add(startOver);
		panel.add(home);
		
		frame = new JFrame("Winner");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String[]args){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						new WinnerPanel();
					}
				});
	}

}

