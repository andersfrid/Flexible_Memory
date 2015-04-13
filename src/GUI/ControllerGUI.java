package GUI;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class ControllerGUI extends Applet{
	private AudioClip audioClip;
	
	public ControllerGUI() {
		
	}
	
	public void chooseSingle(int choose){
	
		if(choose==1){
			System.out.println("hej");
		}
	}
	public void chooseMulti(){
	}
	
		
	
	public void init(){
		try {
			audioClip = Applet.newAudioClip( new URL( "file:\\Users\\Anders\\Pictures\\gong.au"));
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		audioClip.loop();
	}

}
