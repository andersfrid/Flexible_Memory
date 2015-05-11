package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;

import entity.Player;
import gui.HighScoreGui;

public class FileStreamHighScore implements Serializable {
	private String path;
	private ControllerGUI cGUI = new ControllerGUI();
	private HighScoreGui hSG = new HighScoreGui();
	private Player player = new Player(null, 0);
	private ArrayList<String> test = new ArrayList<String>();

	public FileStreamHighScore() {
		test.add("David");
		test.add("Erik");
		test.add("David");
		test.add("Erika");
//		test.add("Davida");
//		test.add("Enis");
//		test.add("Dennis");
//		test.add("Klas");
	}

	public void read() {
		try (ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(
						"HighScore/easy.txt")))){
			while(true){
				try{
					String test = ois.readUTF();
					hSG.fillList(test);
//					System.out.println(test);
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

	public void write() {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(
						"HighScore/easy.txt")))) {
			for (String test : test) {
				oos.writeUTF(test);
				oos.writeUTF("\n");
			}
			oos.flush();

			read();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void path() {
		int lvlNbr = cGUI.getLevel();

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
	}
	
	public static void main(String[] args) {
		FileStreamHighScore fshs = new FileStreamHighScore();
		fshs.write();

	}

}

// String name = player.getName();
// int pairs = player.getPairs();
// int rounds = player.getRoundCount();
