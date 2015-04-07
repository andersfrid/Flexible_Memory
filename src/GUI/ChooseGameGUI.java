package GUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


import com.sun.prism.Image;

public class ChooseGameGUI extends JPanel {
	
	private JFrame frame = new JFrame("Flexible Memory");
	private JPanel mainPanel, contentPanel, bg;
	private JButton btnEasy = new JButton("Easy");
	private JButton btnMedium = new JButton("Medium");
	private JButton btnHard = new JButton("Hard");
	private JButton btnStart = new JButton("Start Game!");
	private JLabel lblTitle = new JLabel("Flexible Memory");
	private Font r28 = new Font("Rockwell", Font.PLAIN, 40);
	private Font p28 = new Font("Papyrus", Font.BOLD, 50);
	private Border blackline, raisedetched, loweredetched,
    raisedbevel, loweredbevel, empty;
	
	ChooseGameGUI() {
		
		JPanel bgpanel = new BgPanel(); 
		bgpanel.setLayout(null);
		bgpanel.setBounds(0, 0, 1000, 700);
			setPreferredSize(new Dimension(800, 800));
			
		//primaryPanel
			mainPanel = new JPanel();
			mainPanel.setLayout(null);
			mainPanel.setPreferredSize(new Dimension(800, 800));
			
		
		//secondaryPanel
			bgpanel.add(contentPanel);
			contentPanel = new JPanel();
			contentPanel.setLayout(null);
			contentPanel.setPreferredSize( new Dimension(800, 800));
			
			
			btnEasy.setBounds(200, 200, 100, 40);
			btnMedium.setBounds(350, 200, 100, 40);
			btnHard.setBounds(500, 200, 100, 40);
			btnStart.setBounds(225, 300, 370, 110);
			lblTitle.setBounds(250, 30, 1000, 90);
			lblTitle.setFont(r28);
			btnStart.setFont(p28);
			lblTitle.setBorder(blackline);
			ImageIcon iconSettings = new ImageIcon("Images/cog2.png");
			JButton btnSettings = new JButton(iconSettings);
			btnSettings.setBounds(10, 10, 50, 50);
			
			
			contentPanel.add(btnEasy);
			contentPanel.add(btnMedium);
			contentPanel.add(btnHard);
			contentPanel.add(lblTitle);
			contentPanel.add(btnSettings);
			contentPanel.add(btnStart);
		//southPanel
		
		
		//mainPanel	
			mainPanel.add(contentPanel);
		//Frame
			frame = new JFrame("Flexible Memory");
			frame.setPreferredSize(new Dimension(1000, 700));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setContentPane(bgpanel);
			frame.setVisible(true);
			frame.add(mainPanel);
			frame.add(contentPanel);
			frame.pack();
	}
	
	private class BgPanel extends JPanel {
	    Image bg = new ImageIcon("Images/chooserBackground.png").getImage();
	    @Override
	    public void paintComponent(Graphics g) {
	        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	    }
	}
	
	
		
	public static void main(String[] args) {
		new ChooseGameGUI();
	}
}
