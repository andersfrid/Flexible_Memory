package gui;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import java.awt.Image;


import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;


import controller.FileStreamHighScore;
import controller.NameConvert;

/**
 * En klass som ritar upp vårat highScoreGUI för singelplayer spelet.
 * @author David, Andreas
 *
 */
public class HighScoreGui extends JPanel {

	private JLabel logo, user, turn, pos;
	private JPanel main, north, center;
	private NameConvert converter = new NameConvert();
	private FileStreamHighScore fshs = new FileStreamHighScore();
	private Image backGround = new ImageIcon("Images/High-Score-Background.png")
			.getImage();

	/**
	 * Konstruktor som lägger in allt som vi ritar upp i metoder, så att vi kan måla upp det i en frame i controllerGUI.
	 */
	public HighScoreGui() {
		add(main());
	}

	/**
	 * Main panelen där alla andra huvud paneler läggs.
	 * @return en panel med andra paneler i sig.
	 */
	private JPanel main() {
		main = new JPanel();
		main.setLayout(new BorderLayout());
		main.add(north(), BorderLayout.NORTH);
		main.add(center(), BorderLayout.CENTER);
		main.setOpaque(false);

		return main;
	}

	/**
	 * Norr panelen som ligger högst upp, innehåller ett par labels, (logga, användarnamn, possition, och hur många drag man tagit).
	 * @return en panel med labels i sig.
	 */
	private JPanel north() {
		north = new JPanel();
		north.setPreferredSize(new Dimension(1000, 170));
		north.setLayout(null);
		north.setOpaque(false);

		ImageIcon iconLogo = new ImageIcon("Images/logo_small_550x75.png");
		logo = new JLabel(iconLogo);
		logo.setBounds(225, 20, 550, 75);

		ImageIcon iconUserName = new ImageIcon("Images/namesHigh.png");
		user = new JLabel(iconUserName);
		user.setBounds(350, 120, 250, 50);
		
		ImageIcon iconPos = new ImageIcon("Images/#.png");
		pos = new JLabel(iconPos);
		pos.setBounds(70, 120, 250, 50);

		ImageIcon iconMoves = new ImageIcon("Images/roundsHigh.png");
		turn = new JLabel(iconMoves);
		turn.setBounds(650, 120, 250, 50);

		north.add(logo);
		north.add(user);
		north.add(turn);
		north.add(pos);

		return north;
	}

	/**
	 * Center panelen som returnrar en panel som skall ligga i center, innehåller själva highscore värdena.
	 * @return en panel.
	 */
	private JPanel center() {
		center = new JPanel();
		center.setLayout(null);
		center.setOpaque(true);
		center.setPreferredSize(new Dimension(100, 500));
		center.add(nameList());
		center.setOpaque(false);
		
		return center;
	}

	/**
	 * En panel som skapar andra paneler i sig och genererar fram namn och possition och hur många drag med snyggare text.
	 * @return
	 */
	public JPanel nameList() {
		JPanel panel = new JPanel();

		String[][] score = fshs.getScore(0);
		panel.setLayout(null);
		panel.setBounds(150, 10, 700, 500);

		
		JPanel namePanel;
		JPanel placePanel;
		JPanel roundsPanel;
		Icon[] text;
		
		//genererar paneler för att visa vilken placering med snygga bokstäver.
		for (int i = 0; i < 8; i++) {
			placePanel = new JPanel();
			placePanel.setBounds(15, i * 60 + 10, 50, 50);
			placePanel.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));
			placePanel.setOpaque(false);
			
			if (i < score.length) {
				text = converter.generate("" + (i + 1), 1);
				for (int j = 0; j < text.length; j++) {
					placePanel.add(new JLabel(text[j]));
				}
			}
			panel.add(placePanel);

			//genererar paneler för namnet på den som har spelet med snygga bokstäver.
			namePanel = new JPanel();
			namePanel.setBounds(110, i * 60 + 10, 410, 50);
			namePanel.setLayout(new FlowLayout(FlowLayout.CENTER, -12, 0));
			namePanel.setOpaque(false);
			
			if (i < score.length) {
				text = converter.generate(score[i][0], 1);
				for (int j = 0; j < text.length; j++) {
					namePanel.add(new JLabel(text[j]));
				}
			}

			panel.add(namePanel);

			//genererar paneler för hur många rundor det tog för spelaren att klara en runda.
			roundsPanel = new JPanel();
			roundsPanel.setBounds(550, i * 60 + 10, 120, 50);
			roundsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, -12, 0));
			panel.add(roundsPanel);
			roundsPanel.setOpaque(false);
			
			if (i < score.length) {
				text = converter.generate(score[i][1], 1);
				for (int j = 0; j < text.length; j++) {
					roundsPanel.add(new JLabel(text[j]));
				}
			}

		}
		panel.setOpaque(false);
		return panel;
	}

	/**
	 * Metod som ritar ut bakgrunden på vår panel.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(backGround, 0, 0, getWidth(), getHeight(), this);
	}
}
