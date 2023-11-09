import java.util.ArrayList;

/*
 * The superclass for all GameModes, Including BoomerangAustralia, Europe and America
 */

public class GameMode {

	//attribute for maxRounds
	private int maxRounds;
	ArrayList<String> regions = new ArrayList<String>();
	
	//getter for MaxRounds
	public int getMaxRounds() {
		return maxRounds;
	}
	
	//Setter for maxrounds
	public void setMaxRounds(int maxRounds) {
		this.maxRounds = maxRounds;
	}
	
	
	//setter for Region
	public void setRegions(ArrayList<String> regions){
		this.regions = regions;
	}
	
	
	//getter for list of all regions
	public ArrayList<String> getRegions(){
		return regions;
	}
	
	
	
	

}
