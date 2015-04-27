package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.ControllerGUI;
import entity.Player;

/**
 * En panel som visar vem som har vunnit efter varje spel. Finns två knappar, restart och home.
 * @author David
 *
 */
public class WinnerPanel extends JPanel implements ActionListener{
	private JPanel panel;
	private JLabel logo, winner;
	private JButton startOver, home;
	private JFrame frame;
	private JLabel playerWinner = new JLabel();
	private JLabel playerLoser = new JLabel();
	private Font afb20 = new Font("Agency FB", Font.PLAIN, 72);
	private ControllerGUI controller = new ControllerGUI();
	/**
	 * Konstruktor där panelen instansieras.
	 */
	public WinnerPanel(Player player1, Player player2, int winnerNbr){
		
		if(winnerNbr == 1){
			playerWinner.setText(player1.getName() + " Par: "+player1.getPairs());
		}
		else if(winnerNbr == 2){
			playerWinner.setText(player2.getName() + " Par: "+player2.getPairs());
		}
		else{
			playerWinner.setText("Det blev lika:  "+player1.getPairs());
		}
		
		panel = new BgPanel();
		panel.setPreferredSize(new Dimension(700,700));
		panel.setLayout(null);
		
		playerWinner.setBounds(275, 425, 300, 100);
		playerWinner.setFont(afb20);
		playerWinner.setForeground(Color.BLACK);
		
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
		panel.add(playerWinner);
		
		startOver.addActionListener(this);
		home.addActionListener(this);
		
		add(panel);

		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startOver){
			controller.restart();
			
		}
		if(e.getSource() == home){
			controller.home();
		}
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

}

