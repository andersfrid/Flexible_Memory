package controller;

import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import entity.Player;


public class NameConvert {
	private Player player1, player2;
	private ControllerGUI controller;
	
	public NameConvert(ControllerGUI controller){
		this.controller = controller;
		String temp ="";
		String imagePath ="Images/Letters/";
	
		temp = player1.getName();
		temp = temp.toUpperCase();
		for(int i =0; i<temp.length(); i++){
			String pathToImage = imagePath;
			pathToImage += ""+ temp.charAt(i) + ".png";
			
			System.out.println(pathToImage);
		}
		Icon ic = new ImageIcon();
	}
	public static void main(String[] arsg) {
		NameConvert t = new NameConvert(new ControllerGUI());
	}
}