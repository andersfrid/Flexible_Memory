package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.ControllerGUI;
import controller.NameConvert;
import entity.Player;

/**
 * En panel som visar vem som har vunnit efter varje spel. Finns två knappar, restart och home.
 * @author David
 *
 */
public class WinnerPanel extends JPanel implements ActionListener{
	private JPanel pnl_bg;
	private JLabel logo;
	private JButton startOver, home;
	private static JFrame frame;
	private ControllerGUI controller = new ControllerGUI();
	private boolean singleplayer;
	private NameConvert converter;
	
	private String modeText;
	private int Level;
	
	/**
	 * Konstruktor där panelen instansieras.
	 */
	
	public WinnerPanel(Player player1, Player player2, int winnerNbr, ControllerGUI controller){
		this.controller = controller;
		
		this.singleplayer = true;
		this.modeText = "hej";	//Ska läggas i konstruktorn
		this.Level = 0;
		
		pnl_bg = new BgPanel();
		pnl_bg.setPreferredSize(new Dimension(1000,700));
		pnl_bg.setLayout(null);
		
		if(singleplayer){
			
			printSingleplayer(player1);
		}
		else{
			printMultiplayer();
		}
		
		ImageIcon iconLogo = new ImageIcon("Images/logo_smaller_320x75.png");
		logo = new JLabel(iconLogo);
		logo.setBounds(340, 0, 320, 75);
		
		ImageIcon restart = new ImageIcon("Images/restartgame.jpg");
		startOver = new JButton(restart);
		startOver.setBounds(180, 580, 310, 100);
		
		ImageIcon homeImg = new ImageIcon("Images/home.jpg");
		home = new JButton(homeImg);
		home.setBounds(510, 580, 310, 100);
		
		pnl_bg.add(logo);
		pnl_bg.add(startOver);
		pnl_bg.add(home);
		
		startOver.addActionListener(this);
		home.addActionListener(this);
		
		add(pnl_bg);

		controller.startMusic(2);
	}
	
	//FELLLLLLLL!!!!!!
	private void printSingleplayer(Player player){
		player.toString();
		
		JPanel pnl_winnerText = new JPanel();
		pnl_winnerText.setBounds(200, 100, 600, 50);
		pnl_winnerText.setBackground(new Color(255,255,255));
		System.out.println(player.getName());
		
		Icon[] text = converter.generate("Hej");
		for (int i = 0; i < text.length; i++) {
			pnl_winnerText.add(new JLabel(text[i]));
		}
		
		
		pnl_bg.add(pnl_winnerText);

		controller.startMusic(2);
	}
	
	private void printMultiplayer(){
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startOver){
			controller.restart();
			controller.removeWinner();
			controller.stopMusic();
			
		}
		if(e.getSource() == home){
			controller.homeWin();
			controller.stopMusic();
		}
	}
	/**
	 * Innre klass som ritar upp bakgrunden på panelen.
	 * @author David
	 *
	 */
	private class BgPanel extends JPanel {
	    Image bg = new ImageIcon("Images/WinnerBackground.jpg").getImage();
	    @Override
	    public void paintComponent(Graphics g) {
	        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	    }
	}

	public static void main(String[] args) {
		frame = new JFrame("test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new WinnerPanel(new Player("Andreas",0), null, 0 , null));
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
	
}

