package entity;

public class Player {
	private String name;
	private int roundCount;
	private int pairs;
	
	public Player(String name){
		this.name = name;
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
