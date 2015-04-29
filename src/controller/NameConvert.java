package controller;

import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import entity.Player;


public class NameConvert {
	private Player player1, player2;
	private ControllerGUI controller;
	String imagePath ="Images/Char/";

	public NameConvert(){
		
	}

	public Icon[] generate(String name){

		String word = name;
		word = word.toUpperCase();
		Icon[] letters = new Icon[word.length()];
		for(int i =0; i<word.length(); i++){
			String pathToImage = imagePath;
			pathToImage += ""+ word.charAt(i) + ".png";
			letters[i] = new ImageIcon(pathToImage);
		}
		return letters ;
	}
//	public static void main(String[] arsg) {
//		NameConvert t = new NameConvert();
//		Icon[] letters = t.generate("Anders");
//		for(int i = 0; i< letters.length; i++){
//			System.out.println(letters[i]);
//		}
//	}
}