package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
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

import org.omg.CORBA.Current;

/**
 * 
 * @author David
 *
 */
public class GameBoardGUI extends JPanel implements ActionListener {
	private JLabel playerOneName, playerTwoName, scorePlayerOne,
			scorePlayerTwo, level, logo;
	private JPanel mainPanel, northPanel, gameArea;
	private JFrame frame;
	private JButton button;
	private JButton[][] buttons;
	private Card[][] gameBoard;
	private int levelNbr;
	private int i;

	public GameBoardGUI(int levelNbr, Card[][] gameBoard) {
		this.levelNbr = levelNbr;
		this.gameBoard = gameBoard;
		// panels
		mainPanel = new BackgroundPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setPreferredSize(new Dimension(1000, 700));

		northPanel = new JPanel();
		northPanel.setPreferredSize(new Dimension(1000, 200));
		northPanel.setOpaque(false);

		mainPanel.add(northPanel, BorderLayout.NORTH);

		// labels
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

		// button
		ImageIcon iconKogg = new ImageIcon("Images/cog2.png");
		button = new JButton(iconKogg);
		button.setBounds(0, 0, 50, 50);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setFocusable(false);
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setContentAreaFilled(false);

		// Gamepanel
		gameArea = new JPanel();
		gameArea.setLayout(new BorderLayout());
		gameArea.setLayout(new GridLayout(4, 6, 4, 4));
		gameArea.setOpaque(false);

		mainPanel.add(gameArea, BorderLayout.CENTER);

		northPanel.add(button);
		northPanel.add(playerOneName);
		northPanel.add(logo);
		northPanel.add(playerTwoName);
		northPanel.add(scorePlayerOne);
		northPanel.add(level);
		northPanel.add(scorePlayerTwo);

		add(mainPanel);
		gameMode();
	}

	public void gameMode() {

		switch (levelNbr) {

		case 0:
			buttons = new JButton[4][6];
			break;
		case 1:
			buttons = new JButton[4][7];
			break;
		case 2:
			buttons = new JButton[5][8];
			break;
		}
		
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				buttons[i][j] = new JButton(gameBoard[i][j].getCardBack());
				System.out.println(gameBoard[i][j].getCardFront());
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

	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < buttons.length; i++){
			for(int j = 0; j < buttons[i].length; j++){
				if(e.getSource() == buttons[i][j]){
					System.out.println("COL:"+i+", ROW:"+j);
					buttons[i][j].setIcon(gameBoard[i][j].getCardFront());
				}
			}
		}
	}

	private class BackgroundPanel extends JPanel {
		private Image backGround = new ImageIcon("Images/mario_1.jpg")
				.getImage();

		public void paintComponent(Graphics g) {
			g.drawImage(backGround, 0, 0, getWidth(), getHeight(), this);
		}
	}
}