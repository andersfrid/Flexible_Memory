package entity;

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
	
	public void addPair(){
		pairs++;
	}
	public int getPairs(){
		return pairs;
	}
	
	public int getRoundCount(){
		return roundCount;
	}
	public void addRound(){
		roundCount++;
	}
	public void clear(){
		roundCount=0;
		pairs=0;
	}
}
