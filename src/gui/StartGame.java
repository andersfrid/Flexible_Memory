package gui;


import javax.swing.SwingUtilities;

import controller.ControllerGUI;

/**
 * En klass som startar vårat spel
 * @author	Anders, David
 *
 */
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
