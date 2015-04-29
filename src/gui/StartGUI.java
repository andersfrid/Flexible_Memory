package gui;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


import controller.ControllerGUI;


/**
 * Start menu GUI där spelet startas. Man kan välja singelplayer eller multiplayer och starta spelet.
 * @author Anders Frid
 *
 */
public class StartGUI extends JPanel implements ActionListener{
	private JButton jbtSingle, jbtMulti, jbtClose, jbtMusic, jbtFx, jbtSettings;
	private JLabel lblLogo;
	private JPanel pnlCenter = new JPanel();
	private ControllerGUI controller;
	
	/**
	 * Konstruktor som ritar upp panelen och dess komponenter. 
	 * Har en referens till en kontroller som styr musik och vilka GUI som skall ritas upp.
	 * @param controller 
	 */
	
	public StartGUI(ControllerGUI controller){
		this.controller = controller;
		
		JPanel bgPanel = new BgPanel(); 
		bgPanel.setPreferredSize(new Dimension(1000,700));
		bgPanel.setLayout(null);
		
		pnlCenter.setLayout(null);
		pnlCenter.setBounds(0, 0, 1000, 700);
		pnlCenter.setOpaque(false);

		ImageIcon iconLogo = new ImageIcon("Images/logo_big_800x275.png");
		lblLogo = new JLabel(iconLogo);
		
		ImageIcon iconSingle = new ImageIcon("Images/b_singleplayer310x100.png");
		jbtSingle = new JButton(iconSingle);
		
		ImageIcon iconMulti = new ImageIcon("Images/b_multiplayer_310x100.png");
		jbtMulti = new JButton(iconMulti);
		
		ImageIcon iconClose = new ImageIcon("Images/b_exit_640x100.png");
		jbtClose = new JButton(iconClose);
		
	
		jbtMusic = new JButton();
		
		
		jbtFx = new JButton();
		
		
		lblLogo.setBounds(0, 0, 1000, 300);
		
		jbtSingle.setBounds(180, 400, 310, 100);
		jbtSingle.setBorderPainted(false);
		
		jbtMulti.setBounds(510, 400, 310, 100);
		jbtMulti.setBorderPainted(false);
		
		jbtClose.setBounds(180, 520, 640, 100);
		jbtClose.setBorderPainted(false);
		
		jbtMusic.setBounds(10, 600, 50, 50);
		jbtMusic.setBorderPainted(false);
		jbtMusic.setBorder(null);
		jbtMusic.setFocusable(false);
		jbtMusic.setMargin(new Insets(0,0,0,0));
		jbtMusic.setContentAreaFilled(false	);
		
		jbtFx.setBounds(70, 600, 50, 50);
		jbtFx.setBorderPainted(false);
		jbtFx.setBorder(null);
		jbtFx.setFocusable(false);
		jbtFx.setMargin(new Insets(0,0,0,0));
		jbtFx.setContentAreaFilled(false);
		
		bgPanel.add(pnlCenter);
		pnlCenter.add(lblLogo);
		pnlCenter.add(jbtSingle);
		pnlCenter.add(jbtMulti);
		pnlCenter.add(jbtClose);
		pnlCenter.add(jbtMusic);
		pnlCenter.add(jbtFx);

		
		jbtSingle.addActionListener(this);
		jbtMulti.addActionListener(this);
		jbtClose.addActionListener(this);
		jbtMusic.addActionListener(this);
		jbtFx.addActionListener(this);
		
		volumePic();
		musicPic();
	
		add(bgPanel);
		
		controller.startMusic(1);
		
	}
	/**
	 * Ändrar bilden på effektknappen beroende på om användaren mutat eller vill ha effekt ljud.
	 */
	public void volumePic() {
		boolean playSound = controller.getSound();

		if (playSound == true) {

			ImageIcon iconSound = new ImageIcon("Images/b_sfx_on_50x50.png");
			jbtFx.setIcon(iconSound);
		} else {

			ImageIcon iconSound = new ImageIcon("Images/b_sfx_off_50x50.png");
			jbtFx.setIcon(iconSound);
		}
	}

	/**
	 * Ändrar bilden på musikknappen beroende på om det är mutat eller spelas musik.
	 */
	public void musicPic() {
		boolean playMusic = controller.getMusic();

		if (playMusic == true) {

			ImageIcon iconMusic = new ImageIcon("Images/b_volume_on_50x50.png");
			jbtMusic.setIcon(iconMusic);
		} else {

			ImageIcon iconMusic = new ImageIcon("Images/b_volume_off_50x50.png");
			jbtMusic.setIcon(iconMusic);
		}
	}

	/**
	 * En aktionlistener som kontrollerar vad våra knappar gör.
	 */
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == jbtSingle){
			controller.chooseSingle();
			controller.startSound(5);
		}
		if(e.getSource() == jbtMulti){
			controller.chooseMulti();
			controller.startSound(5);
		}
		if(e.getSource() == jbtClose){
			System.exit(0);
		}
		if(e.getSource() == jbtMusic){
			controller.stopMusic();
			musicPic();
		}
		if(e.getSource() == jbtFx){
			controller.stopSound();
			volumePic();
		}
		
	}
	/**
	 * En inre klass som ritar upp bakgrunden på panelen.
	 * @author Anders Frid
	 *
	 */
	private class BgPanel extends JPanel {
	    Image bg = new ImageIcon("Images/mario_1.jpg").getImage();
	    @Override
	    public void paintComponent(Graphics g) {
	        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	    }
	}
}
