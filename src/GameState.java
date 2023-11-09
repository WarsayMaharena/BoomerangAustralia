import java.io.IOException;
import java.util.ArrayList;

/*
 * Here is where most of the game functionalities comes to play where different events happens to the players,
 * The events are however envoked in the GameMode functions and its subclasses
*/
public class GameState {
	
	private int maxRounds;

	//constructor that plays the whole game.
	public GameState(Server server, Players players, GameModeAustralia gamemode, FullDeck Fulldeck) throws IOException, ClassNotFoundException{
		
		maxRounds=gamemode.getMaxRounds();
		for(int round=1; round<=maxRounds; round++) {
			
			if(round>1) {
				for(int i=0; i<players.getNumberOfBots()+players.getNumberOfHumanPlayers(); i++) {
					players.getPlayers().get(i).getDraftedCards().clear();
					}
				Fulldeck.DistributeCards(7, players, Fulldeck.getFullDeckCards());
			}
			
			gamemode.ThrowCardMethod(players, server);
			gamemode.CheckSiteBonus(players);
			
			players.ShowYourCards(server);
			players.SendToNextPlayer(players);
			for(int j=0; j<5; j++) {
				players.LookAtYourCards(server);
				players.PickACardToDraft(server);
				gamemode.CheckSiteBonus(players);
				gamemode.CheckRegionBonus(players, Fulldeck);
				gamemode.CheckPairAnimals(players);
				players.ShowYourCards(server);
				
				if(j!=4) {
				players.SendToNextPlayer(players);
				}
			}
			System.out.println("-------CATCH CARD INCOMING---------");
			players.SendToPrevPlayer(players);
			gamemode.CheckPairAnimals(players);
			players.LookAtYourCards(server);
			players.ShowYourCards(server);
			gamemode.CatchCardsScore(players);
		}
		
		System.out.println("ScoreBoard");
		for(int i=0; i<players.getNumberOfBots()+players.getNumberOfHumanPlayers(); i++) {
		
		System.out.println(players.getPlayers().get(i).getPlayerscore());
		}
		
		while(true) {
			
		}
		
	}
	
	//getter for getting max rounds
	public int getMaxRounds() {
		return maxRounds;
	}

	//setter for setting maxrounds
	public void setMaxRounds(int maxRounds) {
		this.maxRounds = maxRounds;
	}
	

	

	
	
	

	


}
