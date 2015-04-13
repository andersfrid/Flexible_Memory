package GUI;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Klassen representerar ett kort på spelplanen om vad den har för
 * någon bild på framsidan och på baksidan.
 * Samt har ett värde som den ska kunna koppla till ett annat kort.
 * @author Andreas
 *
 */
public class Card {
	private Icon cardBack;
	private Icon cardFace;
	private int compareNbr;

	
	public Card(String fileCardBack, String fileCardFace, int compareNbr){
		cardBack = new ImageIcon(fileCardBack);
		cardFace = new ImageIcon(fileCardFace);
		this.compareNbr = compareNbr;
	}
	
	public Icon getCardBack(){
		return cardBack;
	}
	
	public Icon getCardFront(){
		return cardFace;
	}
	
	public int getCompareNbr(){
		return compareNbr;
	}
	
	public void setCardBack(String file){
		cardBack = new ImageIcon(file);
	}
	
	public void setCardFront(String file){
		cardFace = new ImageIcon(file);
	}
	
	public void setCompareNbr(int compareNbr){
		this.compareNbr = compareNbr;
	}
}
