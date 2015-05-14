package controller;

import java.io.File;
import java.util.Random;
import entity.Card;
import entity.Player;

/**
 * 
 * Klassen ska sköta mestadels av logiken som sker när man spelar en runda.
 * 
 * @author Andréas
 *
 */
public class RoundController {
	
	private Card[][] currentGameBoard;
	private Random rand = new Random();
	private ControllerGUI cGUI;
	private Card turn1;
	private Card turn2;
	private Player player1, player2;
	private Player currentPlayer;
	private int col, row;
	private int mode;
	private int level;
	private boolean singleplayer;

	public RoundController(int level, int mode, boolean singleplayer,
			String player1Name, String player2Name, ControllerGUI cGUI) {
		this.mode = mode;
		this.level = level;
		this.cGUI = cGUI;
		this.singleplayer = singleplayer;
		player1 = new Player(player1Name, 1);
		player2 = new Player(player2Name, 2);
		currentPlayer = player1;
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
		
		// Räknar ut hur många bilder det är i mappen
		File f = new File(folderPath);
		int images = 0;
		for (File file : f.listFiles()) {
			if ((file.isFile() && (file.getName().endsWith(".txt") || file
					.getName().endsWith(".jpg")))) {
				images++;
			}
		}

		int nbrOfCards = images / 2;

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
							ok = true;
						}
					} while (!ok);
				}
				count++;
			}

		}
		paintGameBoard();
	}

	/**
	 * Kontrollerar om nuffran som skickas in finns i arrayen.
	 * @param array
	 * @param nbr
	 * @return om nuffran finns i arrayen
	 */
	public boolean alreadyPlaced(int[] array, int nbr) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == nbr) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Kontrollerar om arrayen är helt fylld
	 * @param array
	 * @return är arrayen fylld.
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
		case 0: // standard
			path = "maps/standard/standard_";
			break;
		case 1: // flaggor
			path = "maps/flag/flag_";
			break;
		case 2: // capitals
			path = "maps/capital/flag_";
			break;
		case 3:	// multi
			path = "maps/mult/mult_";
			break;
		case 4:	//plus
			path = "maps/plus/plus_";
			break;
		default: //standard
			path = "maps/standard/standard_";
			break;

		// Fler spellägen ska läggas in här!
		}
		return path;
	}

	/**
	 * Får namnet som de spelläget heter.
	 * @param nbr
	 * @return
	 */
	public String getModeName(int nbr) {
		String modeName = "";
		switch (nbr) {
		case 0: // Standardläge
			modeName = "Standard";
			break;
		case 1: // flaggor
			modeName = "Flags";
			break;
		case 2: // capitals
			modeName = "Flags@C";
			break;
		case 3:
			modeName = "Math@M";
			break;
		case 4:
			modeName = "Math@P";
			break;
		default:
			modeName = "Standard";
			break;
		}
		return modeName;
	}

	/**
	 * Ritar spelplanen i GameBoardGUI
	 */
	public void paintGameBoard() {
		cGUI.printGameBoard(currentGameBoard, this, getModeName(this.mode), player1.getName(), player2.getName());
	}

	/**
	 * Kontrollerar om det är ett par.
	 * @param card1
	 * @param card2
	 * @return om de är ett par.
	 */
	public boolean isPair(Card card1, Card card2) {
		if (card1.getCompareNbr() == card2.getCompareNbr()) {
			return true;
		}
		return false;
	}

	/**
	 * Spelet är över det finns inga kort kvar.
	 * Den här metoden räknar ut vem som är vinnaren och skickar vidare
	 * det till Winnerpanel så de kan skrivas ut. (går genom controllerGUI.
	 */
	public void winner() {
		if (singleplayer) {
			cGUI.winner(player1,null,singleplayer,1,level,getModeName(mode));
			cGUI.fileStream(player1, level);
		} else {
			if (player1.getPairs() == player2.getPairs()) { // Lika
				cGUI.winner(player1,player2,singleplayer,0,level,getModeName(mode));
			}
			else {
				if (player1.getPairs() > player2.getPairs()) { // Spelare 1 vann
					cGUI.winner(player1,player2,singleplayer,1,level,getModeName(mode));
				}
				else { // Spelare 2 vann
					cGUI.winner(player1,player2,singleplayer,2,level,getModeName(mode));
				}
			}
		}
	}

	/**
	 * Någon har gjort ett drag.
	 * Metoden kollar vem som gjort draget lägger på antal rundor samt ev ger poäng
	 * om det är ett par.
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
				currentPlayer.addRound();
				if (isPair(turn1, turn2)) {
					backValue = turn1.getCompareNbr();
					currentPlayer.addPair();
					cGUI.updateRoundStat(currentPlayer);
					// Lägger till ett par hos spelaren
				} else {
					backValue = -2;
					cGUI.updateRoundStat(currentPlayer);
					swapPlayer();
				}

				turn1 = null;
				turn2 = null;

			} else {
				turn2 = null;
				backValue = -3; // Spelaren klickar på samma kort som redan är
								// uppe.
			}
		}
		return backValue;
	}

	/**
	 * Byter spelarens tur.
	 */
	public void swapPlayer() {
		if (!singleplayer) {
			if (currentPlayer.equals(player1)) {
				currentPlayer = player2;
				cGUI.swapHighlightPlayer(2);
			} else if (currentPlayer.equals(player2)) {
				currentPlayer = player1;
				cGUI.swapHighlightPlayer(1);
			}
		}
	}

}
