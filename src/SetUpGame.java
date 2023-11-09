import java.util.ArrayList;
import java.util.Collections;

public class SetUpGame {
	
	public SetUpGame(int NumPlayers, int NumBots) throws Exception{

		//What mode
		String Country = "Australia";
		
		//Create, get all the cards and shuffle them
		FullDeck Fulldeck = new FullDeck(Country);
		
				
		//Create a player object, and create a list for all players 
		Players players = new Players(NumPlayers+NumBots);
		
		
		//Distribute cards to all players
		
		Fulldeck.DistributeCards(7, players, Fulldeck.getFullDeckCards());
		
		players.setIsBot(NumBots);
		players.setNumberOfBots(NumBots);
		players.setNumberOfHumanPlayers(NumPlayers);
		//System.out.println("Bot players: "+players.getNumberOfBots()+"\n Human Players: "+players.getNumberOfHumanPlayers());
		
		for(int playerid=0; playerid<NumPlayers+NumBots; playerid++) {
		System.out.println( players.getPlayers().get(playerid).getIsBot());
		}

		
		//code for Server, Client
		
		
		Server server = new Server(NumPlayers, NumBots, players);
		server.runServer(NumPlayers, NumBots);
		System.out.println("HELLOOOO");
		
		GameModeAustralia GMA = new GameModeAustralia();

		
		//code for Gamestate
		System.out.println("DOES IT STILL WORK");
		GameState gamestate = new GameState(server, players, GMA, Fulldeck);
		
	}
	

}
