package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ControllerGUI;
import controller.NameConvert;
import entity.Player;

/**
 * Panelen visar vinnaren (och förloraren)
 *
 * @author David, Andréas
 *
 */
public class WinnerPanel extends JPanel implements ActionListener {
	private JPanel pnl_bg;
	private JLabel logo;
	private JButton startOver, home, highScore;
	private ControllerGUI controller;
	private boolean singleplayer;
	private String modeText, levelText;
	private NameConvert converter = new NameConvert();
	private Image bg = new ImageIcon("Images/WinnerBackground.jpg").getImage();

	
	public WinnerPanel(){
		
	}
	
	/**
	 * Panelen skapas med rätt resultat.
	 */
	public WinnerPanel(Player player1, Player player2, boolean singleplayer,
			int winnerNbr, int level, String modeText, ControllerGUI controller) {

		this.controller = controller;
		this.singleplayer = singleplayer;
		this.modeText = modeText;

		if (level == 0)
			levelText = "Easy";
		else if (level == 1)
			levelText = "Medium";
		else
			levelText = "Hard";

		pnl_bg = new WinnerPanel();
		pnl_bg.setPreferredSize(new Dimension(1000, 700));
		pnl_bg.setLayout(null);

		// Printar ut singleplayer-vyn eller multiplayer-vyn
		// beroende av vad som har spelats.
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
		controller.stopMusic(2);
		controller.startMusic(2);
	}

	private void printSingleplayer(Player player) {
		/* namn på spelaren */
		JPanel pnlWinnerText = new JPanel();
		pnlWinnerText.setBounds(200, 120, 600, 50);
		pnlWinnerText.setLayout(new FlowLayout(FlowLayout.CENTER, -15, 0));

		Icon[] text = converter.generate(player.getName(), 1);
		for (int i = 0; i < text.length; i++) {
			pnlWinnerText.add(new JLabel(text[i]));
		}
		pnlWinnerText.setOpaque(false);
		pnl_bg.add(pnlWinnerText);

		/* "Finished 'MODE' " */
		JPanel pnlModeText = new JPanel();
		pnlModeText.setBounds(200, 170, 600, 50);
		pnlModeText.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));
		text = converter.generate("Finished " + modeText, 0);
		for (int i = 0; i < text.length; i++) {
			pnlModeText.add(new JLabel(text[i]));
		}
		pnlModeText.setOpaque(false);
		pnl_bg.add(pnlModeText);

		/* "On 'LEVEL' " */
		JPanel pnlLevelText = new JPanel();
		pnlLevelText.setBounds(200, 220, 600, 50);
		pnlLevelText.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));
		text = converter.generate("on " + levelText, 0);
		for (int i = 0; i < text.length; i++) {
			pnlLevelText.add(new JLabel(text[i]));
		}
		pnlLevelText.setOpaque(false);
		pnl_bg.add(pnlLevelText);

		/* " In 'Rounds' " */
		JPanel pnlRoundsText = new JPanel();
		pnlRoundsText.setBounds(200, 270, 600, 50);
		// pnlRoundsText.setBackground(new Color(100,100,100));
		pnlRoundsText.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));
		text = converter
				.generate("in " + player.getRoundCount() + " rounds", 0);
		for (int i = 0; i < text.length; i++) {
			pnlRoundsText.add(new JLabel(text[i]));
		}
		pnlRoundsText.setOpaque(false);
		pnl_bg.add(pnlRoundsText);
		
		ImageIcon score = new ImageIcon("Images/greenHighScore.png");
		highScore = new JButton(score);
		highScore.setBounds(350, 350, 300, 200);
		highScore.setBorderPainted(false);
		highScore.setBorder(null);
		highScore.setFocusable(false);
		highScore.setMargin(new Insets(0, 0, 0, 0));
		highScore.setContentAreaFilled(false);
		
		highScore.addActionListener(this);
		
		pnl_bg.add(highScore);

	}

	private void printMultiplayer(Player player1, Player player2, int winnerNbr) {
		Icon[] text;

		if (winnerNbr == 0) {

			/* "It is a draw" */
			JPanel pnlDrawText = new JPanel();
			pnlDrawText.setBounds(200, 130, 600, 50);
			pnlDrawText.setLayout(new FlowLayout(FlowLayout.CENTER, -15, 0));
			text = converter.generate("It is a Draw", 1);
			for (int i = 0; i < text.length; i++) {
				pnlDrawText.add(new JLabel(text[i]));
			}
			pnlDrawText.setOpaque(false);
			pnl_bg.add(pnlDrawText);

			/* " 'Player1Name' and 'Player2Name' " */
			JPanel pnlDrawName = new JPanel();
			pnlDrawName.setBounds(200, 200, 600, 50);
			pnlDrawName.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));
			text = converter.generate(
					player1.getName() + " and " + player2.getName(), 0);
			for (int i = 0; i < text.length; i++) {
				pnlDrawName.add(new JLabel(text[i]));
			}
			pnlDrawName.setOpaque(false);
			pnl_bg.add(pnlDrawName);

			/* " 'PlayersPair' Pairs" */
			JPanel pnlDrawPair = new JPanel();
			pnlDrawPair.setBounds(200, 250, 600, 50);
			pnlDrawPair.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));
			text = converter.generate(player1.getPairs() + " Pairs", 0);
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

			/* "The winner is:" */
			JPanel pnlTheWinnerIs = new JPanel();
			pnlTheWinnerIs.setBounds(200, 120, 600, 50);
			pnlTheWinnerIs.setLayout(new FlowLayout(FlowLayout.CENTER, -15, 0));
			text = converter.generate("The winner is@", 1);
			for (int i = 0; i < text.length; i++) {
				pnlTheWinnerIs.add(new JLabel(text[i]));
			}
			pnlTheWinnerIs.setOpaque(false);
			pnl_bg.add(pnlTheWinnerIs);

			/* " 'WinnerName' with 'WinnerPairs' Pairs" */
			JPanel pnlWinnerNameAndPair = new JPanel();
			pnlWinnerNameAndPair.setBounds(200, 170, 600, 50);
			pnlWinnerNameAndPair.setLayout(new FlowLayout(FlowLayout.CENTER,
					-15, 0));
			text = converter.generate(
					winner.getName() + " with " + winner.getPairs() + " Pairs",
					1);
			for (int i = 0; i < text.length; i++) {
				pnlWinnerNameAndPair.add(new JLabel(text[i]));
			}
			pnlWinnerNameAndPair.setOpaque(false);
			pnl_bg.add(pnlWinnerNameAndPair);

			/* "The Loser is:" */
			JPanel pnlTheLoserIs = new JPanel();
			pnlTheLoserIs.setBounds(200, 250, 600, 50);
			pnlTheLoserIs.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));
			text = converter.generate("The Loser is@", 0);
			for (int i = 0; i < text.length; i++) {
				pnlTheLoserIs.add(new JLabel(text[i]));
			}
			pnlTheLoserIs.setOpaque(false);
			pnl_bg.add(pnlTheLoserIs);

			/* " 'LoserName' with 'LoserPairs' Pairs " */
			JPanel pnlLoserNameAndPair = new JPanel();
			pnlLoserNameAndPair.setBounds(200, 300, 600, 50);
			pnlLoserNameAndPair.setLayout(new FlowLayout(FlowLayout.CENTER,
					-19, 0));
			text = converter
					.generate(loser.getName() + " with " + loser.getPairs()
							+ " Pairs", 0);
			for (int i = 0; i < text.length; i++) {
				pnlLoserNameAndPair.add(new JLabel(text[i]));
			}
			pnlLoserNameAndPair.setOpaque(false);
			pnl_bg.add(pnlLoserNameAndPair);
		}

		/* "Mode: 'MODE'" */
		JPanel pnlModeText = new JPanel();
		pnlModeText.setBounds(200, 400, 600, 50);
		pnlModeText.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));
		text = converter.generate("Mode@" + modeText, 0);
		for (int i = 0; i < text.length; i++) {
			pnlModeText.add(new JLabel(text[i]));
		}
		pnlModeText.setOpaque(false);
		pnl_bg.add(pnlModeText);

		/* "Level: 'Level'" */
		JPanel pnlLevelText = new JPanel();
		pnlLevelText.setBounds(200, 450, 600, 50);
		pnlLevelText.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));
		text = converter.generate("Level@" + levelText, 0);
		for (int i = 0; i < text.length; i++) {
			pnlLevelText.add(new JLabel(text[i]));
		}
		pnlLevelText.setOpaque(false);
		pnl_bg.add(pnlLevelText);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startOver) {
			controller.startSound(5);
			controller.restart();
			controller.removeWinner();
			controller.stopMusic(3);
			controller.startMusic(1);
		}
		if (e.getSource() == home) {
			controller.startSound(5);
			controller.homeWin();
			controller.stopMusic(3);
			controller.startMusic(1);
		}
		if (e.getSource() == highScore){
			controller.highScoreGUI();
		}
	}
	
	/**
	 * Metod som ritar ut bakgrunden på vår panel.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	}
}
