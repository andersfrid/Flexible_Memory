package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.FileStreamHighScore;
import controller.NameConvert;

public class HighScoreGui extends JPanel {

	private JLabel logo, user, turn;
	private JPanel main, north, center;
	private static JFrame frame;
	private NameConvert converter = new NameConvert();
	private FileStreamHighScore fshs = new FileStreamHighScore();

	private Image backGround = new ImageIcon("Images/High-Score-Background.png")
			.getImage();

	public HighScoreGui() {
		add(main());
	}

	private JPanel main() {
		main = new JPanel();
		main.setLayout(new BorderLayout());
		main.add(north(), BorderLayout.NORTH);
		main.add(center(), BorderLayout.CENTER);
		main.setOpaque(false);

		return main;
	}

	private JPanel north() {
		north = new JPanel();
		north.setPreferredSize(new Dimension(1000, 170));
		north.setLayout(null);
		north.setOpaque(false);
//		north.setBackground(Color.BLUE);

		ImageIcon iconLogo = new ImageIcon("Images/logo_small_550x75.png");
		logo = new JLabel(iconLogo);
		logo.setBounds(225, 20, 550, 75);

		ImageIcon iconUserName = new ImageIcon("Images/namesHigh.png");
		user = new JLabel(iconUserName);
		user.setBounds(200, 120, 250, 50);

		ImageIcon iconMoves = new ImageIcon("Images/roundsHigh.png");
		turn = new JLabel(iconMoves);
		turn.setBounds(650, 120, 250, 50);

		north.add(logo);
		north.add(user);
		north.add(turn);

		return north;
	}

	private JPanel center() {
		center = new JPanel();
		center.setLayout(null);
		center.setOpaque(true);
//		center.setBackground(Color.RED);
		center.setPreferredSize(new Dimension(100, 500));
		center.add(nameList());
		center.setOpaque(false);
		return center;
	}

	public JPanel nameList() {
		JPanel panel = new JPanel();

		String[][] score = fshs.getScore(0);
		panel.setLayout(null);
		panel.setBounds(150, 10, 700, 500);
//		panel.setBackground(new Color(123, 123, 123));
		
		JPanel namePanel;
		JPanel placePanel;
		JPanel roundsPanel;
		Icon[] text;
		
		for (int i = 0; i < 8; i++) {
			placePanel = new JPanel();
//			placePanel.setBackground(new Color(244, 210, 210));
			placePanel.setBounds(15, i * 60 + 10, 50, 50);
			placePanel.setLayout(new FlowLayout(FlowLayout.CENTER, -19, 0));

			if (i < score.length) {
				text = converter.generate("" + (i + 1), 1);
				for (int j = 0; j < text.length; j++) {
					placePanel.add(new JLabel(text[j]));
				}
			}
			panel.add(placePanel);

			namePanel = new JPanel();
//			namePanel.setBackground(new Color(200, 255, 100));
			namePanel.setBounds(110, i * 60 + 10, 410, 50);
			namePanel.setLayout(new FlowLayout(FlowLayout.CENTER, -12, 0));

			if (i < score.length) {
				text = converter.generate(score[i][0], 1);
				for (int j = 0; j < text.length; j++) {
					namePanel.add(new JLabel(text[j]));
				}
			}

			panel.add(namePanel);

			roundsPanel = new JPanel();
//			roundsPanel.setBackground(new Color(230, 210, 1));
			roundsPanel.setBounds(550, i * 60 + 10, 120, 50);
			roundsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, -12, 0));
			panel.add(roundsPanel);

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

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setPreferredSize(new Dimension(1000, 700));
				frame.setResizable(false);
				frame.add(new HighScoreGui());
				frame.setVisible(true);
				frame.pack();

			}
		});

	}
}
