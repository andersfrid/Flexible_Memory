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
		int col, row;

		switch (level) {
		case 0:
			col = 4;
			row = 4;
			break;
		case 1:
			col = 4;
			row = 6;
			break;
		case 2:
			col = 6;
			row = 6;
			break;

		default:
			col = 4;
			row = 4;
			break;
		}

		// currentGameBoard = new Card[col][row];
		currentGameBoard = new int[col][row];

	}

	/**
	 * Returnerar spelplanen
	 * 
	 * @return
	 */
	public int[][] getGameBoard() {
		return this.currentGameBoard;
	}
}
