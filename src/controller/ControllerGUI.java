package controller;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import entity.Card;
import gui.ChooseGameGUI;
import gui.GameBoardGUI;
import gui.SettingsPanel;
import gui.StartGUI;

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
		//Här
		rc = new RoundController(level, mode, this);
	}

	public void settings() {
		frame.add(new SettingsPanel(new ControllerGUI()));

	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}
	
	public void printGameBoard(Card[][] gameBoard, RoundController rc){
		// SwingUtilities.invokeLater(
		// new Runnable(){
		// public void run(){
		frame.getContentPane().removeAll();
		frame.add(new GameBoardGUI(level, gameBoard,rc));
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		//
		// }
		// });
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
