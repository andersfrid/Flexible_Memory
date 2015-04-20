package entity;

public class Player {
	private String name;
	private int roundCount;
	
	public Player(String name){
		this.name = name;
	}
	
	public int getRoundCount(){
		return roundCount;
	}
	
	public void addRound(){
		roundCount++;
	}
	public void clearRounds(){
		roundCount=0;
	}
}
