package GUI;

import java.awt.*;

import javax.swing.*;

public class RoundButton extends JButton {
	private Shape icon;
	public RoundButton(Shape iconKogg) {
		this.icon = iconKogg;
	}


	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			
			g.setClip(icon);
		} else {
//			g.setColor(getBackground());
		}
		g.fillOval(0, 0, 50, 50);

	}

	protected void paintBorder(Graphics g) {
		g.setClip((Shape) icon);
		g.drawOval(0, 0, 50, 50);
	}
}
