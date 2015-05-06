package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import org.omg.CORBA.Current;

import com.sun.xml.internal.bind.api.impl.NameConverter;

import controller.ControllerGUI;
import controller.NameConvert;
import controller.RoundController;
import entity.Card;

/**
 * 
 * @author David
 *
 */
public class GameBoardGUI extends JPanel implements ActionListener {
	private JLabel playerOneName, playerTwoName, scorePlayerOne,
			scorePlayerTwo, level, logo, player1Pairs, player2Pairs,
			player1Rounds, player2Rounds;
	private JPanel mainPanel, northPanel, gameArea, pnlPlayerOne, pnlPlayerTwo,
			pnlMiddle, pnlNameOne, pnlNameTwo, pnlPlayer1Pairs,
			pnlPlayer1Rounds, pnlPlayer2Pairs, pnlPlayer2Rounds;
	private JFrame frame;
	private JButton button;
	private JButton[][] buttons;
	private Card[][] gameBoard;
	private RoundController rc;
	private int levelNbr;
	private ControllerGUI cg;
	private NameConvert converter = new NameConvert();
	private String player1Name, player2Name;

	public GameBoardGUI(int levelNbr, Card[][] gameBoard, ControllerGUI cg,
			RoundController rc, String modeName, boolean singleplayer,
			String player1Name, String player2Name) {

		this.cg = cg;
		this.levelNbr = levelNbr;
		this.gameBoard = gameBoard;
		this.rc = rc;
		this.player1Name = player1Name;
		this.player2Name = player2Name;
		
		// panels
		mainPanel = new BackgroundPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setPreferredSize(new Dimension(1000, 700));

		northPanel = new JPanel();
		northPanel.setLayout(null);
		northPanel.setPreferredSize(new Dimension(1000, 200));
		northPanel.setOpaque(false);

		mainPanel.add(northPanel, BorderLayout.NORTH);

		// PlayerOne
		pnlPlayerOne = new JPanel();
		pnlPlayerOne.setLayout(null);
		pnlPlayerOne.setBounds(5, 65, 400, 300);

		pnlPlayerOne.setOpaque(false);

		// pnlNamePlayerOne
		pnlNameOne = new JPanel();
		pnlNameOne.setOpaque(false);
		pnlNameOne.setBounds(10, 5, 380, 45);
		pnlNameOne.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));

		setPlayerName(player1Name, 1);

		pnlPlayer1Pairs = new JPanel();
		pnlPlayer1Pairs.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));
		pnlPlayer1Pairs.setBounds(10, 50, 380, 45);
		pnlPlayer1Pairs.setOpaque(false);

		Icon[] pairText = converter.generate("Pairs@",0);
		for (int i = 0; i < pairText.length; i++) {
			pnlPlayer1Pairs.add(new JLabel(pairText[i]));
		}

		player1Pairs = new JLabel(new ImageIcon("Images/Letters/-.png"));
		pnlPlayer1Pairs.add(player1Pairs);

		pnlPlayer1Rounds = new JPanel();
		pnlPlayer1Rounds.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));
		pnlPlayer1Rounds.setBounds(10, 95, 380, 45);
		pnlPlayer1Rounds.setOpaque(false);

		Icon[] roundsText = converter.generate("Rounds@",0);
		for (int i = 0; i < roundsText.length; i++) {
			pnlPlayer1Rounds.add(new JLabel(roundsText[i]));
		}

		player1Rounds = new JLabel(new ImageIcon("Images/Letters/-.png"));
		pnlPlayer1Rounds.add(player1Rounds);

		pnlPlayerOne.add(pnlNameOne);
		pnlPlayerOne.add(pnlPlayer1Rounds);
		pnlPlayerOne.add(pnlPlayer1Pairs);

		// Slut på player1
		// **************//

		// **Middle_pnl**

		pnlMiddle = new JPanel();
		pnlMiddle.setBounds(410, 60, 180, 300);
		pnlMiddle.setLayout(null);
		pnlMiddle.setOpaque(false);

		JPanel pnlMode = new JPanel();
		JPanel pnlLevel = new JPanel();
		Icon[] modeText, levelText;

		pnlMode.setBounds(10, 20, 160, 50);
		pnlMode.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));
		pnlMode.setOpaque(false);

		modeText = converter.generate(modeName,0);
		for (int i = 0; i < modeText.length; i++) {
			pnlMode.add(new JLabel(modeText[i]));
		}

		pnlLevel.setBounds(10, 80, 160, 50);
		pnlLevel.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));
		pnlLevel.setOpaque(false);

		String level = "";
		if (levelNbr == 0)
			level = "Easy";
		else if (levelNbr == 1)
			level = "Medium";
		else
			level = "Hard";

		levelText = converter.generate(level,0);

		for (int i = 0; i < levelText.length; i++) {
			pnlLevel.add(new JLabel(levelText[i]));
		}

		pnlMiddle.add(pnlMode);
		pnlMiddle.add(pnlLevel);

		// **Slut på Middlepanelen**//

		// PlayerTwo Panel ****

		pnlPlayerTwo = new JPanel();
		pnlPlayerTwo.setLayout(null);
		pnlPlayerTwo.setBounds(595, 65, 400, 300);
		pnlPlayerTwo.setOpaque(false);

		// Namnet TWO
		pnlNameTwo = new JPanel();
		pnlNameTwo.setBounds(10, 5, 380, 45);
		pnlNameTwo.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));
		pnlNameTwo.setOpaque(false);
		setPlayerName(player2Name, 2);

		// Pairs TWO
		pnlPlayer2Pairs = new JPanel();
		pnlPlayer2Pairs.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));
		pnlPlayer2Pairs.setBounds(10, 50, 380, 45);
		pnlPlayer2Pairs.setOpaque(false);

		for (int i = 0; i < pairText.length; i++) {
			pnlPlayer2Pairs.add(new JLabel(pairText[i]));
		}

		player2Pairs = new JLabel(new ImageIcon("Images/Letters/-.png"));

		pnlPlayer2Pairs.add(player2Pairs);

		// Rounds TWO
		pnlPlayer2Rounds = new JPanel();
		pnlPlayer2Rounds.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));
		pnlPlayer2Rounds.setBounds(10, 95, 380, 45);
		pnlPlayer2Rounds.setOpaque(false);

		for (int i = 0; i < roundsText.length; i++) {
			pnlPlayer2Rounds.add(new JLabel(roundsText[i]));
		}

		player2Rounds = new JLabel(new ImageIcon("Images/Letters/-.png"));
		pnlPlayer2Rounds.add(player2Rounds);

		if (!singleplayer) {
			pnlPlayerTwo.add(pnlNameTwo);
			pnlPlayerTwo.add(pnlPlayer2Pairs);
			pnlPlayerTwo.add(pnlPlayer2Rounds);

		}
		// **Slut på playertwo***///

		// *Tar bort massa konstig färg på paneler:

		// Lägger till alla paneler i northpanel
		northPanel.add(pnlPlayerOne);
		northPanel.add(pnlPlayerTwo);
		northPanel.add(pnlMiddle);

		// Lägger till namnen:

		// labels
		ImageIcon iconPlayer1 = new ImageIcon();
		playerOneName = new JLabel(iconPlayer1);
		playerOneName.setBackground(new Color(0, 0, 0));
		playerOneName.setBounds(50, 10, 150, 50);

		ImageIcon iconLogo = new ImageIcon("Images/logo_small_550x75.png");
		logo = new JLabel(iconLogo);
		logo.setBounds(225, 0, 550, 75);

		ImageIcon iconPlayer2 = new ImageIcon("");
		playerTwoName = new JLabel(iconPlayer2);
		playerTwoName.setBounds(800, 10, 150, 50);

		ImageIcon iconScore1 = new ImageIcon("");
		scorePlayerOne = new JLabel(iconScore1);
		scorePlayerOne.setBounds(50, 100, 150, 50);

		ImageIcon iconScore2 = new ImageIcon("");
		scorePlayerTwo = new JLabel(iconScore2);
		scorePlayerTwo.setBounds(800, 100, 150, 50);

		// button
		ImageIcon iconKogg = new ImageIcon("Images/cog2.png");
		button = new JButton(iconKogg);
		button.setBounds(5, 5, 50, 50);

		button.setBorderPainted(false);
		button.setBorder(null);
		button.setFocusable(false);
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setContentAreaFilled(false);

		// Gamepanel
		gameArea = new JPanel();
		gameArea.setLayout(new BorderLayout());
		gameArea.setOpaque(false);

		mainPanel.add(gameArea, BorderLayout.CENTER);

		northPanel.add(button);
		northPanel.add(playerOneName);
		northPanel.add(logo);
		northPanel.add(playerTwoName);
		northPanel.add(scorePlayerOne);
		northPanel.add(scorePlayerTwo);

		button.addActionListener(this);

		add(mainPanel);
		gameMode();
	}

	/**
	 * Metod som målar upp vilken nivå som blivit vald med rätt antal knappar och var de skall ligga.
	 * Sätter även en bild på alla knapparna och ger dem en actionlistener.
	 */
	public void gameMode() {

		switch (levelNbr) {
		case 0:
			buttons = new JButton[4][6];
			gameArea.setLayout(new GridLayout(4, 6, 4, 4));
			break;
		case 1:
			buttons = new JButton[4][7];
			gameArea.setLayout(new GridLayout(4, 7, 4, 4));
			break;
		case 2:
			buttons = new JButton[5][8];
			gameArea.setLayout(new GridLayout(5, 8, 4, 4));
			break;
		}

		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				buttons[i][j] = new JButton(gameBoard[i][j].getCardBack());
				buttons[i][j].setSize(120, 95);
				buttons[i][j].setBorderPainted(false);
				buttons[i][j].setBorder(null);
				buttons[i][j].setFocusable(false);
				buttons[i][j].setMargin(new Insets(0, 0, 0, 0));
				buttons[i][j].setContentAreaFilled(false);
				buttons[i][j].addActionListener(this);
				gameArea.add(buttons[i][j]);
			}
		}
	}

	/**
	 * Metod som returnerar hur många kort som finns kvar på spelplanen, används för att se när någon vunnit.
	 * @return
	 */
	public int cardsLeft() {
		int count = 0;
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				if (gameBoard[i][j] != null) {
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * Metod som tar bort kort när man har lyckts välja rätt par när man spelar.
	 * Startar även vinnarpanelen när alla kort är borta.
	 * @param compareNbr
	 */
	public void removeCards(int compareNbr) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				for (int i = 0; i < gameBoard.length; i++) {
					for (int j = 0; j < gameBoard[i].length; j++) {
						if (gameBoard[i][j] != null) {
							if (gameBoard[i][j].getCompareNbr() == compareNbr) {
								gameBoard[i][j] = null;
								buttons[i][j].setEnabled(false);
								buttons[i][j].setIcon(null);
							}
						}
					}
				}

				try {
					Thread.sleep(1000);
					if (cardsLeft() <= 0) {
						rc.winner();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Lägger ut namn på de som spelar.
	 * @param name
	 * @param player
	 */
	public void setPlayerName(String name, int player) {
		if (name != null) {
			
			Icon[] newName;
			
			if(player == 1)
				newName = converter.generate(name,1);
			else
				newName = converter.generate(name,0);
			
			if (player == 2) {
				pnlNameTwo.removeAll();
				for (int i = 0; i < newName.length; i++) {
					pnlNameTwo.add(new JLabel(newName[i]));
				}
			} else {
				pnlNameOne.removeAll();
				for (int i = 0; i < newName.length; i++) {
					pnlNameOne.add(new JLabel(newName[i]));
				}
			}
		}
	}

	public void swapCurrentPlayer(int player){
		pnlNameOne.removeAll();
		pnlNameTwo.removeAll();
		
		if(player == 1){ //Byter till första spelaren grön
			Icon[] name = converter.generate(this.player1Name,1);
			for (int i = 0; i < name.length; i++) {
				pnlNameOne.add(new JLabel(name[i]));
			}
			name = converter.generate(this.player2Name,0);
			for (int i = 0; i < name.length; i++) {
				pnlNameTwo.add(new JLabel(name[i]));
			}
		}
		else if(player == 2){ //Byter till andra spelaren grön
			Icon[] name = converter.generate(this.player1Name,0);
			for (int i = 0; i < name.length; i++) {
				pnlNameOne.add(new JLabel(name[i]));
			}
			name = converter.generate(this.player2Name,1);
			for (int i = 0; i < name.length; i++) {
				pnlNameTwo.add(new JLabel(name[i]));
			}
		}
	}
	
	/**
	 * Metod som vänder tillbaka korten när de är fel val.
	 */
	public void clearGameBoard() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				for (int i = 0; i < gameBoard.length; i++) {
					for (int j = 0; j < gameBoard[i].length; j++) {
						if (gameBoard[i][j] != null) {
							buttons[i][j].setIcon(gameBoard[i][j].getCardFront());
						}
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});

	}

	/**
	 * Metod som lyssnar på när en användare klickar på korten "Knapparna".
	 */
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				if (e.getSource() == buttons[i][j]) {
					
					buttons[i][j].setIcon(gameBoard[i][j].getCardFront());

					int backValue = rc.makeRound(gameBoard[i][j]);

					if (backValue == -1) {
						cg.startSound(1);
					} else if (backValue == -2) {
						cg.startSound(1);
						cg.startSound(2);
						clearGameBoard();
					} else if (backValue == -3) {
						cg.startSound(4);
					} else {
						cg.startSound(1);
						cg.startSound(3);
						removeCards(backValue);
					}
				}
			}
		}
		if (e.getSource() == button) {
			cg.startSound(5);
			cg.settingsGame();
		}
	}

	/**
	 * Metod som updaterar spelarnas poäng och hur många runder de har använts under spelets gång.
	 * @param rounds
	 * @param pairs
	 * @param player
	 */
	public void updateStats(int rounds, int pairs, int player) {
		String p = "", r = "";
		
		if(pairs == 0){
			p = "#";
		}
		else{
			p = ""+pairs;
		}
		
		if(rounds == 0){
			r = "#";
		}
		else{
			r = ""+rounds;
		}
		
		Icon[] pairsIcon = converter.generate("Pairs@" + p,0);
		Icon[] roundsIcon = converter.generate("Round@" + r,0);

		if (player == 1) {
			pnlPlayer1Pairs.removeAll();
			pnlPlayer1Rounds.removeAll();
			
			for (int i = 0; i < pairsIcon.length; i++) {
				pnlPlayer1Pairs.add(new JLabel(pairsIcon[i]));
			}

			for (int i = 0; i < roundsIcon.length; i++) {
				pnlPlayer1Rounds.add(new JLabel(roundsIcon[i]));
			}
		} else {
			pnlPlayer2Pairs.removeAll();
			pnlPlayer2Rounds.removeAll();
			
			for (int i = 0; i < pairsIcon.length; i++) {
				pnlPlayer2Pairs.add(new JLabel(pairsIcon[i]));
			}

			for (int i = 0; i < roundsIcon.length; i++) {
				pnlPlayer2Rounds.add(new JLabel(roundsIcon[i]));
			}
			
		}
		
		northPanel.repaint();
		northPanel.revalidate();
	}

	/**
	 * Inre klass som ritar ut bakgrunden på panelen.
	 * @author David
	 *
	 */
	private class BackgroundPanel extends JPanel {

		private Image backGround = new ImageIcon("Images/mario_1.jpg")
				.getImage();

		public void paintComponent(Graphics g) {
			g.drawImage(backGround, 0, 0, getWidth(), getHeight(), this);
		}
	}

}