package GUI;

import java.io.File;
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
	// temp
	private String background = "/maps/background/background_0";
	
	private Card[][] currentGameBoard;
	private Random rand = new Random();

	private int col, row;

	public RoundController(int level, int mode) {
		createNewGameBoard(level, mode);
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
		currentGameBoard = calcGameBoardSize(level);

		String imagePath = getModePath(mode);
		String folderPath = imagePath.substring(0,
				imagePath.lastIndexOf('/') + 1);

		System.out.println(imagePath);
		System.out.println(folderPath);

		int nbrOfCards = (new File(folderPath).listFiles().length) / 2;
		System.out.println(nbrOfCards);

		System.out.println(rand.nextInt(nbrOfCards));

		int[] alreadyPlaced = new int[20];
		int count = 0;

		System.out.println(currentGameBoard.length);

		while (!isFilled(currentGameBoard)) {

			int pairNbr = rand.nextInt(nbrOfCards);

			//if (!alreadyPlaced(alreadyPlaced, pairNbr)) {
				for (int i = 0; i <= 1; i++) {
					boolean ok = false;

					do {
						int randCol = rand.nextInt(this.col);
						int randRow = rand.nextInt(this.row);

						if (currentGameBoard[randCol][randRow] == null) {
							String pathToImage = imagePath;
							pathToImage += "" + pairNbr + "_" + i;

							alreadyPlaced[count] = pairNbr; // count läggs till
															// efter loopen

							currentGameBoard[randCol][randRow] = new Card(pathToImage, pairNbr);
							ok = true;
						}
					} while (!ok);
				}
				count++;
//			}

		}
		System.out.println("toString");

		System.out.println(currentGameBoard.toString());
		for(int i=0; i<currentGameBoard.length; i++){
			for(int j=0; j<currentGameBoard[i].length; j++){
				System.out.print(currentGameBoard[i][j].getCardFront().toString()+", ");
				if(j == currentGameBoard[i].length-1)
					System.out.println("");
			}
		}
	}

	public boolean alreadyPlaced(int[] array, int nbr) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == nbr) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param array
	 * @return
	 */
	public boolean isFilled(Card[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Räknar ut hur spelplanen kommer se ut, skapar planen samt returnerar den
	 * som en array[][]
	 * 
	 * @param level
	 * @return array[][] som representerar spelplanen
	 */
	public Card[][] calcGameBoardSize(int level) {
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
	 * 
	 * @param mode
	 * @return filvägen till bilderna utan till de spelläget som ska köras.
	 */
	public String getModePath(int mode) {
		String path = "";
		switch (mode) {
		case 0: // Standardläge
			path = "maps/standard/standard_";
			break;
		case 1: // flaggor
			path = "maps/flag/flag_";
			break;
		default:
			path = "maps/standard/standard_";
			break;

		// Fler spellägen ska läggas in här!
		}
		return path;
	}

	/**
	 * Returnerar spelplanen
	 * 
	 * @return
	 */
	public Card[][] getGameBoard() {
		return this.currentGameBoard;
	}

	/**
	 * Ritar spelplanen i frame
	 */
	public void paintGameBoard() {

	}

	public static void main(String[] args) {
		new RoundController();
	}
}
