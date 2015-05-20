package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

import entity.Player;
import gui.HighScoreGui;


/**
 * En klass som skriver användarens namn och hur många drag han behövde för att klara en nivå till en fil.
 * Beroende på vilken nivå användaren har valt att spela på.
 * @author David, Andreas
 *
 */
public class FileStreamHighScore implements Serializable {

	public FileStreamHighScore(Player player, int level) {
		writeAndSort(player, level);
	}
	
	public FileStreamHighScore(){
		
	}

	/**
	 * Metod som hämtar det som finns på filerna och kan användas då för att se vad som finns på filen.
	 * @param level
	 * @return en array med värdena från filen.
	 */
	public String[][] getScore(int level) {
		File file = getPath(level);
		int count = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while (br.readLine() != null) {
				count++;
			}
		} catch (Exception e) {
		}

		String[][] score = new String[count][2];

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String read;
			for(int i = 0; i < score.length; i++){
				read = br.readLine();
				score[i][0] = read.substring(0, read.indexOf("."));
				score[i][1] = read.substring(read.indexOf(".") + 1);
			}
		} catch (Exception e) {}

		return score;
	}

	/**
	 * Metod som väljer vilken typ av fil som skall användas när det skall läsas och skrivas till fil.
	 * @param level
	 * @return en sökväg.
	 */
	public File getPath(int level) {
		int lvlNbr = level;
		File path;

		switch (lvlNbr) {

		case 0:
			path = new File("HighScore/easy.txt");
			break;

		case 1:
			path = new File("HighScore/medium.txt");
			break;

		case 2:
			path = new File("HighScore/hard.txt");
			break;

		default:
			path = new File("HighScore/easy.txt");
			break;
		}
		return path;
	}

	/**
	 * En metod som skriver och sorterar användaren efter deras poäng till rätt fil.
	 * @param player
	 * @param level
	 */
	public void writeAndSort(Player player, int level) {
		File file = getPath(level);
		String read;
		int count = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			while ((read = br.readLine()) != null) {
				count++;
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String readName;
			String[][] name = new String[count + 1][2];
			for (int i = 0; i < name.length - 1; i++) {
				readName = br.readLine();
				name[i][0] = readName.substring(0, readName.indexOf("."));
				name[i][1] = readName.substring(readName.indexOf(".") + 1);
				
			}

			name[name.length - 1][0] = player.getName();
			name[name.length - 1][1] = "" + player.getRoundCount();

			
			file.delete();
			File newFile = new File("HighScore/easy.txt");
			newFile.createNewFile();

			// Sortera

			boolean flag = true;
			String temp1;
			String temp2;
			while (flag) {
				flag = false;
				for (int i = 0; i < name.length - 1; i++) {

					if (Integer.parseInt(name[i][1]) > Integer
							.parseInt(name[i + 1][1])) { 
															
						temp1 = name[i][0];
						temp2 = name[i][1];
						name[i][0] = name[i + 1][0];
						name[i][1] = name[i + 1][1];

						name[i + 1][0] = temp1;
						name[i + 1][1] = temp2;
						flag = true;
					}

				}

			}
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFile,
					true))) {
				for (int i = 0; i < name.length; i++) {
					bw.write(name[i][0] + "." + name[i][1] + "\n");
				}
			}

		} catch (IOException e) {

		}

	}
}
