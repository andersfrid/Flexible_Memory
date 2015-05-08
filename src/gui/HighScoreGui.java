package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class HighScoreGui extends JPanel {

	private JLabel[] name;
	private JLabel logo, user, points, turn;
	private JPanel main, north, center;

	private JFrame frame;
	private String[] score;
	private ArrayList<String> score2 = new ArrayList<String>();

	public HighScoreGui() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(700, 700));
		frame.setResizable(false);
		frame.add(main());
		frame.setVisible(true);
		frame.pack();

	}

	private JPanel main() {
		main = new JPanel(new BorderLayout());
		main.add(north(), BorderLayout.NORTH);
		main.add(center(), BorderLayout.CENTER);

		return main;
	}

	private JPanel north() {
		north = new JPanel();
		north.setPreferredSize(new Dimension(700, 170));
		north.setBackground(Color.BLUE);
		north.setLayout(null);

		ImageIcon iconLogo = new ImageIcon("Images/logo_small_550x75.png");
		logo = new JLabel(iconLogo);
		logo.setBounds(55, 10, 550, 75);
		;

		user = new JLabel("Användarnamn");
		user.setBounds(55, 120, 70, 70);

		points = new JLabel("Poäng");
		points.setBounds(300, 120, 70, 70);

		turn = new JLabel("Antal drag");
		turn.setBounds(500, 120, 70, 70);

		north.add(logo);
		north.add(user);
		north.add(points);
		north.add(turn);

		return north;
	}

	private JPanel center() {
		center = new JPanel(new GridLayout(10, 0));
		center.setBackground(Color.GREEN);
		for (int i = 0; i < score.length; i++) {
			name[i] = new JLabel(score[i]);
			center.add(name[i]);
		}
		return center;
	}

	public void fillList(String name) {
		score2.add(name);
		System.out.println(name);

		score = new String[score2.size()];
		score = score2.toArray(score);

		for (String s : score)
			System.out.println(s);

	}

	public static void main(String[] args) {
		new HighScoreGui();
	}
}
