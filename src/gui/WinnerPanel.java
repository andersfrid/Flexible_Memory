package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
 * En panel som visar vem som har vunnit efter varje spel. Finns två knappar,
 * restart och home.
 * 
 * @author David
 *
 */
public class WinnerPanel extends JPanel implements ActionListener {
	private JPanel pnl_bg;
	private JLabel logo;
	private JButton startOver, home;
	private static JFrame frame;
	private ControllerGUI controller = new ControllerGUI();
	private boolean singleplayer;
	private NameConvert converter = new NameConvert();

	private String modeText, levelText;

	/**
	 * Konstruktor där panelen instansieras.
	 */

	public WinnerPanel(Player player1, Player player2,boolean singleplayer, int winnerNbr, int level,String modeText, ControllerGUI controller) {
		this.controller = controller;
		this.singleplayer = singleplayer;
		this.modeText = modeText; // Ska läggas i konstruktorn

		if (level == 0)
			levelText = "Easy";
		else if (level == 1)
			levelText = "Medium";
		else
			levelText = "Hard";

		pnl_bg = new BgPanel();
		pnl_bg.setPreferredSize(new Dimension(1000, 700));
		pnl_bg.setLayout(null);

		if (singleplayer) {
			printSingleplayer(player1);
		} else {
			printMultiplayer(player1, player2, winnerNbr);
		}

		ImageIcon iconLogo = new ImageIcon("Images/logo_small_550x75.png");
		logo = new JLabel(iconLogo);
		logo.setBounds(225, 20, 550, 75);

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

	private void printSingleplayer(Player player) {
		// Namnet
		JPanel pnlWinnerText = new JPanel();
		pnlWinnerText.setBounds(200, 120, 600, 50);
		// pnlWinnerText.setBackground(new Color(255,255,255));
		pnlWinnerText.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));

		Icon[] text = converter.generate(player.getName());
		for (int i = 0; i < text.length; i++) {
			pnlWinnerText.add(new JLabel(text[i]));
		}
		pnlWinnerText.setOpaque(false);
		pnl_bg.add(pnlWinnerText);

		// Finished 'Mode'
		JPanel pnlModeText = new JPanel();
		pnlModeText.setBounds(200, 170, 600, 50);
		// pnlModeText.setBackground(new Color(100,100,100));
		pnlModeText.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));

		text = null;
		text = converter.generate("Finished " + modeText);
		for (int i = 0; i < text.length; i++) {
			pnlModeText.add(new JLabel(text[i]));
		}
		pnlModeText.setOpaque(false);
		pnl_bg.add(pnlModeText);

		// On 'Level'
		JPanel pnlLevelText = new JPanel();
		pnlLevelText.setBounds(200, 220, 600, 50);
		// pnlLevelText.setBackground(new Color(255,255,255));
		pnlLevelText.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));

		text = null;
		text = converter.generate("on " + levelText);
		for (int i = 0; i < text.length; i++) {
			pnlLevelText.add(new JLabel(text[i]));
		}
		pnlLevelText.setOpaque(false);
		pnl_bg.add(pnlLevelText);

		// In 'Rounds
		JPanel pnlRoundsText = new JPanel();
		pnlRoundsText.setBounds(200, 270, 600, 50);
		// pnlRoundsText.setBackground(new Color(100,100,100));
		pnlRoundsText.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));

		text = null;
		text = converter.generate("in " + player.getRoundCount() + " rounds");
		for (int i = 0; i < text.length; i++) {
			pnlRoundsText.add(new JLabel(text[i]));
		}
		pnlRoundsText.setOpaque(false);
		pnl_bg.add(pnlRoundsText);

	}

	private void printMultiplayer(Player player1, Player player2, int winnerNbr) {
		Icon[] text;
		
		if (winnerNbr == 0) {

			//DRAW
			JPanel pnlDrawText = new JPanel();
			pnlDrawText.setBounds(200, 130, 600, 50);
//			pnlDrawText.setBackground(new Color(255, 255, 255));
			pnlDrawText.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));

			text = converter.generate("It is a Draw");
			for (int i = 0; i < text.length; i++) {
				pnlDrawText.add(new JLabel(text[i]));
			}
			pnlDrawText.setOpaque(false);
			pnl_bg.add(pnlDrawText);
			
			//Namnen
			JPanel pnlDrawName = new JPanel();
			pnlDrawName.setBounds(200, 200, 600, 50);
//			pnlDrawName.setBackground(new Color(255, 255, 255));
			pnlDrawName.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));

			text = converter.generate(player1.getName()+" and "+player2.getName());
			for (int i = 0; i < text.length; i++) {
				pnlDrawName.add(new JLabel(text[i]));
			}
			pnlDrawName.setOpaque(false);
			pnl_bg.add(pnlDrawName);
			
			//par
			JPanel pnlDrawPair = new JPanel();
			pnlDrawPair.setBounds(200, 250, 600, 50);
//			pnlDrawPair.setBackground(new Color(255, 255, 255));
			pnlDrawPair.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));

			text = converter.generate(player1.getPairs()+" Pairs");
			for (int i = 0; i < text.length; i++) {
				pnlDrawPair.add(new JLabel(text[i]));
			}
			pnlDrawPair.setOpaque(false);
			pnl_bg.add(pnlDrawPair);
			
		} else {

			Player winner, loser;
			
			if (winnerNbr == 1) {
				winner = player1;
				loser = player2;
			} else {
				winner = player2;
				loser = player1;
			}

			// The Winner Is
			JPanel pnlTheWinnerIs = new JPanel();
			pnlTheWinnerIs.setBounds(200, 120, 600, 50);
//			pnlTheWinnerIs.setBackground(new Color(255, 255, 255));
			pnlTheWinnerIs.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));

			text = converter.generate("The winner is@");
			for (int i = 0; i < text.length; i++) {
				pnlTheWinnerIs.add(new JLabel(text[i]));
			}
			pnlTheWinnerIs.setOpaque(false);
			pnl_bg.add(pnlTheWinnerIs);

			// Vinnaren + antal par

			JPanel pnlWinnerNameAndPair = new JPanel();
			pnlWinnerNameAndPair.setBounds(200, 170, 600, 50);
//			pnlWinnerNameAndPair.setBackground(new Color(100, 100, 100));
			pnlWinnerNameAndPair.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));
			
			text = converter.generate(winner.getName()+" with "+winner.getPairs()+" Pairs");
			for (int i = 0; i < text.length; i++) {
				pnlWinnerNameAndPair.add(new JLabel(text[i]));
			}
			pnlWinnerNameAndPair.setOpaque(false);
			
			pnl_bg.add(pnlWinnerNameAndPair);
			
			//The Loser Is
			JPanel pnlTheLoserIs = new JPanel();
			pnlTheLoserIs.setBounds(200, 250, 600, 50);
//			pnlTheLoserIs.setBackground(new Color(255, 255, 255));
			pnlTheLoserIs.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));

			text = converter.generate("The Loser is@");
			for (int i = 0; i < text.length; i++) {
				pnlTheLoserIs.add(new JLabel(text[i]));
			}
			pnlTheLoserIs.setOpaque(false);
			pnl_bg.add(pnlTheLoserIs);
			
			
			//Förloraren + antal par
			JPanel pnlLoserNameAndPair = new JPanel();
			pnlLoserNameAndPair.setBounds(200, 300, 600, 50);
//			pnlLoserNameAndPair.setBackground(new Color(100, 100, 100));
			pnlLoserNameAndPair.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));

			text = converter.generate(loser.getName()+" with "+loser.getPairs()+" Pairs");
			for (int i = 0; i < text.length; i++) {
				pnlLoserNameAndPair.add(new JLabel(text[i]));
			}
			pnlLoserNameAndPair.setOpaque(false);
			pnl_bg.add(pnlLoserNameAndPair);
		}
			
			//Mode
			JPanel pnlModeText = new JPanel();
			pnlModeText.setBounds(200, 400, 600, 50);
//			pnlModeText.setBackground(new Color(100, 100, 100));
			pnlModeText.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));

			text = converter.generate("Mode@"+modeText);
			for (int i = 0; i < text.length; i++) {
				pnlModeText.add(new JLabel(text[i]));
			}
			pnlModeText.setOpaque(false);
			pnl_bg.add(pnlModeText);
			
			//Level
			JPanel pnlLevelText = new JPanel();
			pnlLevelText.setBounds(200, 450, 600, 50);
//			pnlLevelText.setBackground(new Color(100, 100, 100));
			pnlLevelText.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));

			text = converter.generate("Level@"+levelText);
			for (int i = 0; i < text.length; i++) {
				pnlLevelText.add(new JLabel(text[i]));
			}
			pnlLevelText.setOpaque(false);
			pnl_bg.add(pnlLevelText);
			

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startOver) {
			controller.restart();
			controller.removeWinner();
			controller.stopMusic();

		}
		if (e.getSource() == home) {
			controller.homeWin();
			controller.stopMusic();
		}
	}

	/**
	 * Innre klass som ritar upp bakgrunden på panelen.
	 * 
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
		frame.add(new WinnerPanel(new Player("Andreas", 0), new Player("Pelle",
				1),false,1,0,"Standard",null));
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}

}
