package controller;



import javax.swing.Icon;
import javax.swing.ImageIcon;

public class NameConvert {
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