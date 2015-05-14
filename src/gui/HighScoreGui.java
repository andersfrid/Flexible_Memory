package gui;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class HighScoreGui extends JPanel {

	private JLabel[] name = new JLabel[10];
	private JLabel[] turns = new JLabel[10];
	private JLabel logo, user, turn;
	private JPanel main, north, east, west;
	private static JFrame frame;
	private String[] score = new String[10];
	private ArrayList<String> score2 = new ArrayList<String>();
	private Image backGround = new ImageIcon("Images/High-Score-Background.png")
	.getImage();

	public HighScoreGui(){
		
	}
	public HighScoreGui(String name) {
		add(main());
	}

	private JPanel main() {
		main = new HighScoreGui();
		main.setLayout(new BorderLayout());
		main.add(north(), BorderLayout.NORTH);
		main.add(west(), BorderLayout.WEST);
		main.add(east(), BorderLayout.EAST);

		return main;
	}

	private JPanel north() {
		north = new JPanel();
		north.setPreferredSize(new Dimension(700, 170));
		north.setLayout(null);
		north.setOpaque(false);
		

		ImageIcon iconLogo = new ImageIcon("Images/logo_small_550x75.png");
		logo = new JLabel(iconLogo);
		logo.setBounds(55, 10, 550, 75);

		ImageIcon iconUserName = new ImageIcon("Images/anvNamn.png");
		user = new JLabel(iconUserName);
		user.setBounds(30, 120, 170, 50);

		ImageIcon iconMoves = new ImageIcon("Images/antalDrag.png");
		turn = new JLabel(iconMoves);
		turn.setBounds(520, 120, 120, 50);

		north.add(logo);
		north.add(user);
		north.add(turn);

		return north;
	}

	private synchronized JPanel west() {
		west = new JPanel();
		west.setLayout(new GridLayout(10, 1));
		west.setPreferredSize(new Dimension (233, 700));
		west.setOpaque(false);
		
		for (int i = 0; i < score.length; i++) {
			name[i] = new JLabel();
			name[i].setText("David");
			name[i].setHorizontalAlignment(JLabel.CENTER);
			west.add(name[i]);
		}
		
		return west;
	}
		
	private synchronized JPanel east() {
		east = new JPanel();
		east.setLayout(new GridLayout(10, 1));
		east.setPreferredSize(new Dimension (233, 700));
		east.setOpaque(false);
		
		for (int i = 0; i < score.length; i++){
			turns[i] = new JLabel();
			turns[i].setText("20");
			turns[i].setHorizontalAlignment(JLabel.CENTER);
			east.add(turns[i]);
		}
		
		return east;
	}
	
	

	public String[] fillList(String name) {
		score2.add(name);

		score = new String[score2.size()];
		score = score2.toArray(score);
		for(String s : score){
			System.out.println(s);
		}
		return score;
	}
	
	/**
	 * Metod som ritar ut bakgrunden på vår panel.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(backGround, 0, 0, getWidth(), getHeight(), this);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setPreferredSize(new Dimension(700, 700));
				frame.setResizable(false);
				frame.add(new HighScoreGui());
				frame.add(new HighScoreGui("David"));
				frame.setVisible(true);
				frame.pack();
				
			}
		});
		
	}
}
