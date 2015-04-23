package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import entity.Card;
import entity.Player;

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
	private ControllerGUI cGUI;

	// temp
	private Card turn1 = null;
	private Card turn2 = null;

	private Player player1, player2;
	private int col, row;
	
	private boolean roundEnable = true;

	public RoundController(int level, int mode, ControllerGUI cGUI) {
		this.cGUI = cGUI;
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

		//Räknar ut hur många bilder det är i mappen
		File f = new File(folderPath);
		int images = 0;
		for (File file : f.listFiles()) {
			if ((file.isFile() && (file.getName().endsWith(".txt") || file
					.getName().endsWith(".jpg")))) {
				images++;
			}
		}
		System.out.println("Number of images: " + images);

		int nbrOfCards = images/2;
		System.out.println(nbrOfCards);

		int[] alreadyPlaced = new int[20];
		for (int i = 0; i < alreadyPlaced.length; i++) {
			alreadyPlaced[i] = -1;
		}

		int count = 0;

		while (!isFilled(currentGameBoard)) {
			
			
			int pairNbr = rand.nextInt(nbrOfCards);

			if (!alreadyPlaced(alreadyPlaced, pairNbr)) {
				for (int i = 0; i <= 1; i++) {
					boolean ok = false;

					do {
						int randCol = rand.nextInt(this.col);
						int randRow = rand.nextInt(this.row);

						if (currentGameBoard[randCol][randRow] == null) {

							String pathToImage = imagePath;
							pathToImage += "" + pairNbr + "_" + i + ".jpg";

							alreadyPlaced[count] = pairNbr; // count läggs till
															// efter loopen

							currentGameBoard[randCol][randRow] = new Card(
									pathToImage, pairNbr);
							System.out.println("Här lägs det in: "
									+ pathToImage);
							ok = true;
						}
					} while (!ok);
				}
				count++;
			}

		}

		paintGameBoard();

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
			row = 6;
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
			row = 6;
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
		case 2: // capitals
			path = "maps/capital/flag_";
			break;
		case 3:
			path = "maps/mult/mult_";
			break;
		case 4:
			path = "maps/plus/plus_";
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
		cGUI.printGameBoard(currentGameBoard, this);
	}

	public boolean isPair(Card card1, Card card2) {
		if (card1.getCompareNbr() == card2.getCompareNbr()) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param card
	 * @return -1 Första rundan -2 inte samma compare. -3 tryckt på samma kort.
	 *         alla andra, det är ett par tabort detta.
	 */
	public int makeRound(Card card) {
		int backValue = -1;

		if (turn1 == null) {
			turn1 = card;
		} else if (turn2 == null) {
			turn2 = card;
		}

		if (turn1 != null && turn2 != null) {
			if (!turn1.equals(turn2)) {
				if (isPair(turn1, turn2)) {
					backValue = turn1.getCompareNbr();
				} else {
					backValue = -2;
				}

				turn1 = null;
				turn2 = null;
			} else {
				turn2 = null;
				backValue = -3;
			}
		}
		return backValue;
	}

	public void setPlayers(String name) {
		player1 = new Player(name);
	}

	public void setPlayers(String name1, String name2) {
		player1 = new Player(name1);
		player2 = new Player(name2);
	}

}
