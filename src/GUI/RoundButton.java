package GUI;

import java.awt.*;
import javax.swing.*;

public class RoundButton extends JButton {
	public RoundButton(String label) {

	}


	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			
			g.setColor(Color.GREEN);
		} else {
			g.setColor(getBackground());
		}
		g.fillOval(0, 0, 50, 50);

	}

	protected void paintBorder(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawOval(0, 0, 50, 50);
	}
}
