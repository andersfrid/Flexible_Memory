package GUI;

import java.util.ArrayList;
import java.util.Random;

/**
 * Klassen ska sköta logiken som sker under rundan Exempelvis ska den skapa
 * spelplanen. Kolla om två vända är likadana.
 * 
 * @author Andreas
 *
 */
public class RoundController {
	//temp
	private String background = "/maps/background/background_0";
	
	private int[][] currentGameBoard;
	private Random rand = new Random();
	
	public RoundController() {
	}

	/**
	 * Gör en spelplan.
	 * 
	 * @param level
	 *            easy=0/medium=1/hard=2
	 * @param mode
	 *            De olika spellägena som ska finnas.
	 * @return En spelplan som ska ritas
	 */
	public void createNewGameBoard(int level, int mode) {
		
	}

	/**
	 * Räknar ut hur spelplanen kommer se ut, skapar planen samt returnerar den
	 * som en array[][]
	 * 
	 * @param level
	 * @return array[][] som representerar spelplanen
	 */
	public Card[][] calcGameBoardSize(int level) {
		int col, row;
		switch (level) {
		case 0:
			col = 4;
			row = 5;
			break;
		case 1:
			col = 4;
			row = 7;
			break;
		case 2:
			col = 5;
			row = 8;
			break;
		default:
			col = 4;
			row = 5;
			break;
		}

		Card[][] gameBoard = new Card[col][row];
		return gameBoard;
	}
	
	/**
	 * Får filvägen till den spelläge som har valts.
	 * @param mode
	 * @return filvägen till bilderna utan till de spelläget som ska köras.
	 */
	public String getModePath(int mode){
		String path = "";
		switch(mode){
			case 0: //Standardläge
				path = "/maps/standard/standard_";
				break;
			case 1: //flaggor
				path = "/maps/flag/flag_";
				break;
			default :
				path = "/maps/standard/standard_";
				break;
				
			//Fler spellägen ska läggas in här!
		}
		return path;
	}

	/**
	 * Returnerar spelplanen
	 * 
	 * @return
	 */
	public int[][] getGameBoard() {
		return this.currentGameBoard;
	}

	/**
	 * Ritar spelplanen i frame
	 */
	public void paintGameBoard() {

	}
}
