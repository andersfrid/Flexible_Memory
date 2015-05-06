package controller;

import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import entity.Player;

public class NameConvert {
	private Player player1, player2;
	private ControllerGUI controller;
	String pathToGreen = "Images/Char_green/";
	String pathToOrange = "Images/Char/";

	public Icon[] generate(String word, int colorNbr) {
		// 0 = orange, 1 = green

		String pathToImage = "";
		if (colorNbr == 0) {
			pathToImage = pathToOrange;
		} else {
			pathToImage = pathToGreen;
		}

		word = word.toUpperCase();

		Icon[] letters = new Icon[word.length()];

		for (int i = 0; i < word.length(); i++) {
			String imagePath = pathToImage;

			char symbol = word.charAt(i);
			if (symbol == ' ') {
				symbol = '_';
			}

			imagePath += "" + symbol + ".png";
			
			letters[i] = new ImageIcon(imagePath);

		}
		return letters;
	}
}