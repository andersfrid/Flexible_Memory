package GUI;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Start menu GUI
 * @author Anders Frid
 *
 */
public class StartGUI extends JPanel implements ActionListener{
	private JButton jbtSingle, jbtMulti, jbtClose, jbtMusic, jbtFx;
	private JLabel lblLogo;
	private JPanel pnlCenter = new JPanel();
	private JFrame frame = new JFrame();
	private StartBGMusic sm = new StartBGMusic();
	
	public StartGUI()
	{
		
		JPanel bgpanel = new BgPanel(); 
		bgpanel.setLayout(null);
		bgpanel.setBounds(0, 0, 1000, 700);
		pnlCenter.setLayout(null);
		pnlCenter.setBounds(0, 0, 1000, 700);
		pnlCenter.setOpaque(false);

		ImageIcon iconLogo = new ImageIcon("Images/logo_big_800x275.png");
		lblLogo = new JLabel(iconLogo);
		
		ImageIcon iconSingle = new ImageIcon("Images/b_singelplayer310x100.png");
		jbtSingle = new JButton(iconSingle);
		
		ImageIcon iconMulti = new ImageIcon("Images/b_multiplayer_310x100.png");
		jbtMulti = new JButton(iconMulti);
		
		ImageIcon iconClose = new ImageIcon("Images/b_exit_640x100.png");
		jbtClose = new JButton(iconClose);
		
		ImageIcon iconMusic = new ImageIcon("Images/music.jpg");
		jbtMusic = new JButton(iconMusic);
		
		ImageIcon iconFx = new ImageIcon("Images/fx.png");
		jbtFx = new JButton(iconFx);
		
		lblLogo.setBounds(0, 0, 1000, 300);
		jbtSingle.setBounds(180, 400, 310, 100);
		jbtMulti.setBounds(510, 400, 310, 100);
		jbtClose.setBounds(180, 550, 640, 100);
		jbtMusic.setBounds(10, 600, 40, 40);
		jbtFx.setBounds(70, 600, 40, 40);
		
		
		bgpanel.add(pnlCenter);
		pnlCenter.add(lblLogo);
		pnlCenter.add(jbtSingle);
		pnlCenter.add(jbtMulti);
		pnlCenter.add(jbtClose);
		pnlCenter.add(jbtMusic);
		pnlCenter.add(jbtFx);
		
		jbtSingle.addActionListener(this);
		jbtMulti.addActionListener(this);
		jbtClose.addActionListener(this);
		jbtMusic.addActionListener(this);
		jbtFx.addActionListener(this);
		
			
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(1000, 700));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setContentPane(bgpanel);
		frame.add(pnlCenter);
		frame.setVisible(true);
		frame.pack();
		
		sm.init();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtSingle){
			
		}
		if(e.getSource() == jbtMulti){
			
		}
		if(e.getSource() == jbtClose){
			System.exit(0);
		}
		if(e.getSource() == jbtMusic){
			sm.audioClip.stop();
		}
		if(e.getSource() == jbtFx){
			
		}
	}
	
	private class StartBGMusic extends Applet { //Plays the background music
		AudioClip audioClip;	
		
		public void init(){
			try {
				audioClip = Applet.newAudioClip( new URL( "file:\\Users\\Anders\\Pictures\\gong.au"));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			audioClip.loop();
		}
    }
	
	private class BgPanel extends JPanel {
	    Image bg = new ImageIcon("Images/mario.jpg").getImage();
	    @Override
	    public void paintComponent(Graphics g) {
	        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	    }
	}
	
    public static void main(String args[]){
    	SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
                new StartGUI();
            }
        });
    }

}
