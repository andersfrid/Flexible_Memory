package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * En panel som visar vem som har vunnit efter varje spel. Finns två knappar, restart och home.
 * @author David
 *
 */
public class WinnerPanel extends JPanel {
	private JPanel panel;
	private JLabel logo, winner;
	private JButton startOver, home;
	private JFrame frame;
	
	/**
	 * Konstruktor där panelen instansieras.
	 */
	public WinnerPanel(){
		
		panel = new BgPanel();
		panel.setPreferredSize(new Dimension(700,700));
		panel.setLayout(null);
		
		ImageIcon iconLogo = new ImageIcon("Images/logo_small_550x75.png");
		logo = new JLabel(iconLogo);
		logo.setBounds(75, 50, 550, 75);
		
		ImageIcon winnerLogo = new ImageIcon("Images/winner1.png");
		winner = new JLabel(winnerLogo);
		winner.setBounds(150,100,400,360);
		
		ImageIcon startLogo = new ImageIcon("Images/restartgame.jpg");
		startOver = new JButton(startLogo);
		startOver.setBounds(25, 560, 310, 100);
		
		ImageIcon homeLogo = new ImageIcon("Images/home.jpg");
		home = new JButton(homeLogo);
		home.setBounds(365, 560, 310, 100);
		
		panel.add(winner);
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
	/**
	 * Innre klass som ritar upp bakgrunden på panelen.
	 * @author David
	 *
	 */
	private class BgPanel extends JPanel {
	    Image bg = new ImageIcon("Images/mario_1.jpg").getImage();
	    @Override
	    public void paintComponent(Graphics g) {
	        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	    }
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

