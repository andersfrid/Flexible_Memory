package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SettingsPanel extends JPanel{
	private JPanel panel;
	private JLabel label, logo;
	private JButton musicButton, soundButton, restartButton, mainMenu, exit;
	private JFrame frame;
	
	public SettingsPanel(){
		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(400,400));
		panel.setBackground(Color.LIGHT_GRAY);
		
//		label = new JLabel("Inställningar");
//		label.setBounds(100, 50, 300, 50);
		logo = new JLabel("FLEXIBLE MEMORY" + "\n" + "Inställningar");
		logo.setBounds(150, 10, 200, 50);
		
		
		restartButton = new JButton("STARTA OM");
		restartButton.setBounds(40, 160, 150, 75);
		mainMenu = new JButton("HUVUD MENYN");
		mainMenu.setBounds(210, 160, 150, 75);
		exit = new JButton("AVSLUTA");
		exit.setBounds(50, 250, 300, 75);
		
		ImageIcon iconMusic = new ImageIcon("Images/b_volume_on_50x50.png");
		musicButton = new JButton(iconMusic);
		musicButton.setBounds(125, 337, 50, 50);
		musicButton.setOpaque(false);
		ImageIcon iconSound = new ImageIcon("Images/b_sfx_on_50x50.png");
		soundButton = new JButton(iconSound);
		soundButton.setBounds(225, 337, 50, 50);
		soundButton.setOpaque(false);
		
		panel.add(logo);
		panel.add(restartButton);
		panel.add(mainMenu);
		panel.add(exit);
		panel.add(musicButton);
		panel.add(soundButton);
		
		frame = new JFrame("Inställningar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String[]args){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						new SettingsPanel();
					}
				});
	}
}
