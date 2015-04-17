package GUI;

import java.util.Timer;

public class TaBortMig {
	Timer timer = new Timer();
	
	public TaBortMig(){
			timer.schedule(new TimerT(), 3000,1000);
	}
	public static void main(String[] args) {
		new TaBortMig();
	}
}
