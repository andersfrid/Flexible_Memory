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
	private Icon cardBack = new ImageIcon("maps/background/bak_1.jpg");
	private Icon cardFace;
	private int compareNbr;
	private boolean isCompared = false;

	
	public Card(String fileCardFace, int compareNbr){
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
	
	//Ska vända kortet?
	public void turnCard(){
	}
}
