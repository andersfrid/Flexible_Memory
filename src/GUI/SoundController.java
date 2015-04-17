package GUI;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class SoundController {
	private	boolean playSound = true;
	
	public void soundEffects(){
		AudioClip clip = null;
		if(playSound == true){		
	   	 try {
	   		 URL url = new File("Music/gong.au").toURI().toURL();
	   		 clip = Applet.newAudioClip(url);
	   		 clip.play();
	   		 
	   		 
	   	 }catch(MalformedURLException e){
	   		 System.out.println(e);
	   	 } 
		}
	}
	
	public void stopSound(){
		if(playSound == true){
			playSound = false;
			
		}
		else{
			playSound = true;
			
		}
	}
	
	public void setBoolean(boolean playSound){
		this.playSound = playSound;	
	}
	public boolean getBoolean(){
		return playSound;
		
	}

}
