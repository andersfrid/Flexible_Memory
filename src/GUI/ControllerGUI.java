package GUI;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ControllerGUI extends Applet{
	
	private StartGUI start = new StartGUI(null);
	private AudioClip audioClip;
	private JFrame frame;
	
	public ControllerGUI() {
		
	}
	
	public void chooseSingle(){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						frame.getContentPane().removeAll();
						frame.add(new ChooseGameGUI());
						frame.getContentPane().revalidate();
						frame.getContentPane().repaint();
					
					}
				});

	}
	public void chooseMulti(){
	}
	
	public void startGame(){
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(1000,700));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(new StartGUI(this));
		frame.setVisible(true);
		frame.pack();
	}
	
		
	
	public void init(){
		try {
			audioClip = Applet.newAudioClip( new URL( "file:\\Users\\Anders\\Pictures\\gong.au"));
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		audioClip.loop();
	}

}
