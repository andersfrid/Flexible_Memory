package entity;


/**
 * Klassen representerar en spelare
 * @author Andreas
 *
 */
public class Player {
	private String name;
	private int playerID;
	private int roundCount;
	private int pairs;
	
	public Player(String name, int playerID){
		this.name = name;
		this.playerID = playerID;
	}

	public int getID(){
		return playerID;
	}
	
	public String getName(){
		return name;
	}
	
	/**
	 * Lägger till ett par hos spelaren
	 */
	public void addPair(){
		pairs++;
	}
	public int getPairs(){
		return pairs;
	}
	public int getRoundCount(){
		return roundCount;
	}
	/**
	 * Lägger till en runda hos spelaren.
	 */
	public void addRound(){
		roundCount++;
	}
	/**
	 * Rensar både par och rundor hos spelaren
	 */
	public void clear(){
		roundCount=0;
		pairs=0;
	}
}
