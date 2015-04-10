package GUI;

public class ControllerGUI {
	private StartGUI sGui;
	private ChooseGameGUI cgGui;
	private GameBoardGUI gbGui;
	
	public void chooseSingle(){
		new ChooseGameGUI();
	}
	public void chooseMulti(){
	}
	
	 public static void main(String args[]){
		 new StartGUI();
	 }
}
