package GUI;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ControllerGUI extends Applet {

	private StartGUI start = new StartGUI(this);
	private AudioClip audioClip;
	private JFrame frame;
	private int level, mode=0; //Bara ett spelläge än
	private RoundController rc;

	public ControllerGUI() {

	}

	public void chooseSingle() {
		// SwingUtilities.invokeLater(
		// new Runnable(){
		// public void run(){
		frame.getContentPane().removeAll();
		frame.add(new ChooseGameGUI(this, true));
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();

		// }
		// });

	}

	public void chooseMulti() {
		// SwingUtilities.invokeLater(
		// new Runnable(){
		// public void run(){
		frame.getContentPane().removeAll();
		frame.add(new ChooseGameGUI(this, false));
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		//
		// }
		// });

	}

	public void startGame() {
		rc = new RoundController(level, mode, this);
	}

	public void settings() {
		frame.add(new SettingsPanel());

	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}
	
	public void printGameBoard(Card[][] gameBoard){
		// SwingUtilities.invokeLater(
		// new Runnable(){
		// public void run(){
		frame.getContentPane().removeAll();
		frame.add(new GameBoardGUI(level, gameBoard));
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		//
		// }
		// });
	}

	public void init() {
		try {
			audioClip = Applet.newAudioClip(new URL("?????"));
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		audioClip.loop();
	}

	public void startFrame() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(new StartGUI(this));
		frame.setVisible(true);
		frame.pack();

	}

}
