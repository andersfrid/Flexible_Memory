package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controller.ControllerGUI;

public class StartGame {
	private ControllerGUI controller = new ControllerGUI();
	
	public StartGame(){
		controller.startFrame();
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
