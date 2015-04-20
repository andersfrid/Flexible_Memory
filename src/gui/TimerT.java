package gui;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TimerT {
	private Random rand = new Random();

	public TimerT() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(rand.nextInt(21));
		}
	}

	public static void main(String[] args) {
		new TimerT();
	}
}
