package GUI;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartMenyGUI extends JFrame {
	private JButton jbtSingle = new JButton("Singelplayer");
	private JButton jbtMulti = new JButton("Mulitplayer");
	private JButton jbtClose = new JButton("Avsluta");
	private JPanel pnlNorth = new JPanel();
	private JPanel pnlCenter = new JPanel();
	private JFrame frame = new JFrame();
	
	public StartMenyGUI(){
		setLayout(null);
		setPreferredSize(new Dimension(800,800));
	
		pnlNorth.setBounds(0, 0, 800, 400);
		pnlCenter.setBounds(0, 400, 800, 400);
		add(pnlNorth);
		add(pnlCenter);
		
		jbtSingle.setBounds(x, y, 310, 100);
		jbtMulti.setBounds(x, y, 310, 100);
		jbtClose.setBounds(x, y, 640, 100);
		
		pnlCenter.add(jbtSingle);
		pnlCenter.add(jbtMulti);
		pnlCenter.add(jbtClose);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
			
		
	}
}
