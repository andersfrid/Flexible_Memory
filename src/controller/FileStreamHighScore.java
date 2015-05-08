package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileStreamHighScore {
	private String path;
	private ControllerGUI cGUI = new ControllerGUI();
	
	public void read() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))){
			String score = br.readLine();
			
			while(score != null){
				score = br.readLine();
				System.out.println(score);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write(){
		try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))){
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void path(){
		int lvlNbr = cGUI.getLevel();
		
		switch(lvlNbr){
		
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
	
}
