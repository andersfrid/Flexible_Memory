package GUI;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class StartGame {
	
	private JFrame frame;
	
	public StartGame(){
	
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(1000,700));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(new StartGUI());
		frame.setVisible(true);
		frame.pack();
	}
	
	public static void main(String[]args){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						new StartGame();
					}
		});
	}

}
