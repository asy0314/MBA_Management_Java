//Name: Sunyoung An
//Due Date: July 27, 2021
//Title: NBATeam
//Description: A class with the array of players' names and ages. It is a class file, and the main method is in the file 'NBAPlayoff.java'.
//==============================================================================
import java.util.ArrayList;

public class NBATeam {
	
	// String field for team name
	private String teamName;
	
	// ArrayList to store the names of all players in this team
	private ArrayList<String> playerNames;
	
	// ArrayList to store the ages of all players in this team
	private ArrayList<Integer> playerAges;
	
	// constructor with a given team name
	public NBATeam(String name) {
		
		// assign the team name
		this.teamName = name;
		
		// initialize the ArrayLists
		this.playerNames = new ArrayList<String>();
		this.playerAges = new ArrayList<Integer>();
	}
	
	// add a new player for this team
	public void addAPlayer(String name, int age) {
		
		// add the new player's name into the ArrayList of names 
		this.playerNames.add(name);
		
		// add the new player's age into the ArrayList of ages
		this.playerAges.add(Integer.valueOf(age));
	}
	
	// returns the max value of the players ages
	public int getMaxAge() {
		
		// return 0 by default if there is no player yet in this team
		if (this.playerAges.size() == 0) {
			return 0;
		}
		
		// initialize a temporary max value as the first value in the age ArrayList
		int max = this.playerAges.get(0);
		
		// for each value in the age ArrayList
		for (int age : this.playerAges) {
			// if the value is greater than the current max value
			if (age > max) {
				// replace the max value
				max = age;
			}
		}
		
		return max;
	}
	
	// returns the min value of the players ages
	public int getMinAge() {
		
		// return 0 by default if there is no player yet in this team
		if (this.playerAges.size() == 0) {
			return 0;
		}
		
		// initialize a temporary min value as the first value in the age ArrayList
		int min = this.playerAges.get(0);
		
		// for each value in the age ArrayList
		for (int age : this.playerAges) {
			
			// if the value is less than the current min value
			if (age < min) {
				
				// replace the max value
				min = age;
			}
		}
		
		return min;
		
	}
	
	// returns the average value (as an integer) of the players ages
	public int getAvgAge() {
		
		// return 0 by default if there is no player yet in this team
		if (this.playerAges.size() == 0) {
			return 0;
		}
		
		// initialize variable to sum all ages
		// double type is used to calculate average
		double sum = 0;
		
		// for each value in the age ArrayList
		for (int age : this.playerAges) {
			// add to 
			sum += age;
		}
		
		// calculate the average value as an integer
		// using Math.round and type-casting
		int avg = (int) Math.round(sum / this.playerAges.size());
		
		return avg;
	}
	
	// returns the number of the players
	public int getNumOfPlayer() {
		return this.playerNames.size();
	}
	
	// returns the names ArrayList
	public ArrayList<String> getNames() {
		return this.playerNames;
	}
	
}
