package controller;

import java.applet.Applet;
import java.applet.AudioClip;





import javax.swing.JFrame;




import javax.swing.JLabel;

import entity.Card;
import entity.Player;
import gui.ChooseGameGUI;
import gui.GameBoardGUI;
import gui.SettingsPanel;
import gui.StartGUI;
import gui.WinnerPanel;

/**
 * En panel och sound kontroller som hanterar hur vi byter mellan våra paneler. 
 * Även hur vi hanterar vår musik ifrån SoundController.
 * @author David Anders Andreas Joakim
 *
 */
public class ControllerGUI extends Applet {

	private AudioClip audioClip;
	private JFrame frame;
	private JFrame frameSett;
	private JFrame frameWin;
	private int level, mode=0; //Bara ett spelläge än
	private RoundController rc;
	private SoundController s = new SoundController();
	private StartGUI start;
	private boolean singleplayer;
	private String p1,p2;
	private GameBoardGUI gameBoardGUI;
	
	/**
	 * Byter panel till singelplayer när användaren väljer singelplayer.
	 */
	public void chooseSingle() {
		singleplayer = true;
		frame.getContentPane().removeAll();
		frame.add(new ChooseGameGUI(this, true));
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
	}

	/**
	 * Byter panel till multiplayer delen, när användaren väljer multiplayer.
	 */
	public void chooseMulti() {
		singleplayer = false;
		frame.getContentPane().removeAll();
		frame.add(new ChooseGameGUI(this, false));
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
	
	}

	/**
	 * Startar RoundController, med de värden vi väljer att skicka med.
	 */
	public void startGame(String p1, String p2) {
		this.p1 = p1;
		this.p2 = p2;
		rc = new RoundController(level, mode, singleplayer,p1,p2,this);
	}

	/**
	 * Startar en ny frame med en settingsruta där användaren kan ändra lite inställningar.
	 */
	public void settings() {
		frameSett = new JFrame("Settings");
		frameSett.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frameSett.setResizable(false);
		frameSett.add(new SettingsPanel(this,1));		
		frameSett.setVisible(true);
		frameSett.pack();
	}

	/**
	 * En del setters och getters. Som ändrar musik och nivåer i spelet.
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}
	public boolean getMusic(){
		return s.getMusic();
	}
	public boolean getSound(){
		return s.getSound();
	}
	
	public void startSound(int soundNbr){
		s.startEffects(soundNbr);
	}
	
	public void stopSound(){
		s.stopSound();
	}
	public void startMusic(int musicNbr){
		s.startMusic(musicNbr);
	}
	public void stopMusic(){
		s.stopMusic();
	}
	
	public void nextSong(int songNumber){
		s.musicChooser(songNumber);
	}
	
	/**
	 * Ritar ut våran spelplans panel med de valen som användaren har valt i tematmenyen.
	 * @param gameBoard
	 * @param rc
	 */
	public void printGameBoard(Card[][] gameBoard, RoundController rc, String modeName, String player1Name, String player2Name){
		gameBoardGUI = new GameBoardGUI(level, gameBoard,this,rc, modeName, singleplayer, player1Name, player2Name);
		frame.getContentPane().removeAll();
		frame.add(gameBoardGUI);
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
	}
	
	public void updateRoundStat(Player player){
		System.err.println(player.getName());
		gameBoardGUI.updateStats(player.getRoundCount(), player.getPairs(), player.getID());
		System.err.println(player.getID());
	}
	
	/**
	 * Startar en första frame och lägger vår start panel i den.
	 */ 
	public void startFrame() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(new StartGUI(this));
		frame.setVisible(true);
		frame.pack();

	}
	public void restart(){
		frame.getContentPane().removeAll();
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		startGame(p1, p2);
	}
	public void home(){
		removeSettings();
		frame.getContentPane().removeAll();
		frame.add(new StartGUI(this));
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		
	}
	public void homeWin(){
		removeWinner();
		frame.getContentPane().removeAll();
		frame.add(new StartGUI(this));
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
	}

	public void removeSettings(){
		
		frameSett.dispose();
		frameSett.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void removeWinner(){
		frameWin.remove(this);
		frameWin.getContentPane().removeAll();
//		frameSett.setVisible(false);
		frameWin.dispose();
	}
	public void winner(Player player1,Player player2, int winnerNbr){
		frameWin= new JFrame("Winner");
		frameWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		frameWin.add(new WinnerPanel(player1, player2, winnerNbr,this));
		frameWin.setResizable(false);
		frameWin.pack();
		frameWin.setVisible(true);
	}
	public void repaintSettings(){
		frameSett.getContentPane().removeAll();
		frameSett.add(new SettingsPanel(this,0));
		frameSett.getContentPane().revalidate();
		frameSett.getContentPane().repaint();
	}

}
