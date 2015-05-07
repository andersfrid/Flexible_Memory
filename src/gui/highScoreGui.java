package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class highScoreGui extends JPanel{
	
	private JLabel[] name;
	private JLabel logo;
	private JPanel main, north, center;
	
	private JFrame frame;
	private ArrayList<String> score = new ArrayList<String>();

	
	public highScoreGui(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(700,700));
		frame.setResizable(false);
		frame.add(main());
		frame.setVisible(true);
		frame.pack();
		
	}
	private JPanel main(){
		main = new JPanel(new BorderLayout());
		main.add(north(),BorderLayout.NORTH);
		main.add(center(), BorderLayout.CENTER);
		
		return main;
	}
	
	private JPanel north(){
		north = new JPanel();
		north.setPreferredSize(new Dimension(700,100));
		north.setBackground(Color.BLUE);
		
		ImageIcon iconLogo = new ImageIcon("Images/logo_small_550x75.png");
		logo = new JLabel(iconLogo);
		logo.setBounds(55, 20, 550, 75);;
		north.add(logo);
		
		return north;
	}
	
	private JPanel center(){
		center = new JPanel(new GridLayout(10,0));
		center.setBackground(Color.GREEN);
//		center.add(score());
		
		return center;
	}
	
	private void score(){
		for(int i = 0; i<score.size(); i++){
			name[i] = new JLabel();
			
		}
				
	}
	
	
	public static void main (String[]args){
		new highScoreGui();
	}
}
