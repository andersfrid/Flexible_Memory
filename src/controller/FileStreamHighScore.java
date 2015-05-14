package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import entity.Player;
import gui.HighScoreGui;

public class FileStreamHighScore implements Serializable {
	
	private ControllerGUI cGUI = new ControllerGUI();
	private HighScoreGui hSG = new HighScoreGui();
	private ArrayList<String> name = new ArrayList<String>();
	private ArrayList<Integer> move = new ArrayList<Integer>();
	private int level;
	private String highScore;
	

	public FileStreamHighScore(Player player1, int level) {
		this.level = level;
		path();
		whatToPrint(player1);

	}

	public void read() {
		try (BufferedReader br = new BufferedReader(new FileReader(
						path()))){
			while(true){
				try{
					String test = br.readLine();
					hSG.fillList(test);

				} catch(IOException e1){
					break;
				}
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			
			e2.printStackTrace();
		}
	}

	public void write(String s) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(
						path(), true))) {
			
			bw.write(s);
			bw.write("\n");
			
			bw.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void whatToPrint(Player player1){
		String names = player1.getName();
		int moves = player1.getRoundCount();
		
		
		highScore = names +  " " + moves;
		write(highScore);
	}

	public String path() {
		int lvlNbr = level;
		String path = "";
		
		switch (lvlNbr) {

		case 0:
			path = "HighScore/easy.txt";
			break;

		case 1:
			path = "HighScore/medium.txt";
			break;

		case 2:
			path = "HighScore/hard.txt";
			break;
		}
		return path;
	}
	
//	public static void main(String[] args) {
//		FileStreamHighScore fshs = new FileStreamHighScore();
//		fshs.write();
//
//	}

}
