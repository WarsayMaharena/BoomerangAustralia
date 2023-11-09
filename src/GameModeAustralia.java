import java.io.IOException;
import java.util.ArrayList;
import java.lang.Math;

public class GameModeAustralia extends GameMode{

	//constructor for an AustraliaMode
	public GameModeAustralia() {
		setMaxRounds(4);
        ArrayList<String> states = new ArrayList<>();
        states.add("Western Australia");
        states.add("Northern Territory");
        states.add("Queensland");
        states.add("South Australia");
        states.add("New South Wales");
        states.add("Victoria");
        states.add("Tasmania");
		ArrayList<String> Ausstates = new ArrayList<>(states);
		setRegions(Ausstates);
		
	}
	
	//throw at the start of the round
	public void ThrowCardMethod(Players players, Server server) throws ClassNotFoundException, IOException {
		//System.out.println("in this method-----------------------------");
		players.LookAtYourCards(server);
		players.PickACardToDraft(server);
		
		int i=1;
		ArrayList<Player> AddedPlayers=players.getPlayers();
		
		for (Player player : AddedPlayers) {
		    // Access the YourDeck ArrayList
			ArrayList<Card> deck = new ArrayList<Card>(player.getDraftedCards());
			player.setThrowCard(deck.get(0));
			
			//System.out.println("size: "+deck.size()+ " Card id : " +deck.get(0));
			deck.remove(0);
			//System.out.println("size: "+deck.size()+ " Card id : ");
			
			for(int j = 0; j <1; j++) {

				/*System.out.println();
				System.out.println("Name: " + player.getThrowCard().getName());
				System.out.println("Site: " + player.getThrowCard().getSite());
				System.out.println("Region: " + player.getThrowCard().getRegion());
				System.out.println("Hashtag: " + player.getThrowCard().getHashtagg());
				System.out.println("Collection: " + player.getThrowCard().getCollection());
				System.out.println("Animal: " + player.getThrowCard().getAnimal());
				System.out.println("Activity: " + player.getThrowCard().getActivity()+"\n");*/
				
			}
		    //System.out.println("Player "+i+ " with id: "+player+"------HELLO------IN SETUPGAME-FINALfinal-----"); // Assuming you have a toString method defined in your Player class
		    i++;
		}
	
		
	}
	
	//Last round, calculates the throw-catch card score.
	public void CatchCardsScore(Players players) {
		for(Player player:players.getPlayers()) {
			int res = player.getThrowCard().getHashtagg() - player.getYourDeck().get(0).getHashtagg();
			System.out.println(Math.abs(res));
			res=res+player.getPlayerscore();
			Math.abs(res);
			player.setPlayerscore(res);
		}
		
	}
	
	//checks if they have visited the site, if yes they will get 1 point
	public void CheckSiteBonus(Players players) {
		
		boolean value = false;
		for(Player player:players.getPlayers()) {
			ArrayList<Card> AllUsedCards = new ArrayList<Card>();
			AllUsedCards = player.getAllUsedCards();
			AllUsedCards.addAll(player.getDraftedCards());
			player.setAllUsedCards(AllUsedCards);
			int size = player.getAllUsedCards().size();
			Card DraftedCard=player.getAllUsedCards().get(size-1);
			for(int i=0; i<size-1; i++) {
				if(player.getAllUsedCards().get(i).getSite() == DraftedCard.getSite()) {
					System.out.println("No points!");
					value =true;
					break;
				}
				
				else {
					int res =player.getPlayerscore()+1;
					player.setPlayerscore(res);
				}
			}
		}
	}
	
	
	//check every player if they have completed a whole region, if yes 3 bonus points
	public void CheckRegionBonus(Players players, FullDeck Fulldeck) {
		ArrayList<String> regions = getRegions();
		
		int i = 0;
		int k = 0;
		for(int j=0; j<players.getNumberOfBots()+players.getNumberOfHumanPlayers(); j++) {
			for(String region: regions) {
				for(Card place: Fulldeck.getFullDeckCards()) {
					if(place.getRegion() == region) {
						i++;
					}
				}
				for(Card card:players.getPlayers().get(j).getAllUsedCards()) {
					if(card.getRegion() == region) {
						k++;
					}
				}
			if(k==i) {
				int res =players.getPlayers().get(j).getPlayerscore()+3;
				players.getPlayers().get(j).setPlayerscore(res);
				
			}
			}
		
		
		}
	}
	
	//checks if there is an animal pair inside your AllUsedCard, considering that you can't get points for animal pair you have already had.
	public void CheckPairAnimals(Players players) {
		int CheckFirstIndex=0;
		int CheckSecondIndex=0;
		for(int j=0; j<players.getNumberOfBots()+players.getNumberOfHumanPlayers(); j++) {
			for(Card c:players.getPlayers().get(j).getAllUsedCards()) {
				for(Card Anotherc:players.getPlayers().get(j).getAllUsedCards()) {
					if(c.getAnimal() == Anotherc.getAnimal() && CheckFirstIndex!=CheckSecondIndex && c.getAnimal() != "") {
						if(c.getAnimal()=="Kangaroos") {
							int res =players.getPlayers().get(j).getPlayerscore()+3;
							players.getPlayers().get(j).setPlayerscore(res);
						}
						if(c.getAnimal()=="Wombats") {
							int res =players.getPlayers().get(j).getPlayerscore()+5;
							players.getPlayers().get(j).setPlayerscore(res);
						}
						if(c.getAnimal()=="Koalas ") {
							int res =players.getPlayers().get(j).getPlayerscore()+7;
							players.getPlayers().get(j).setPlayerscore(res);
						}
						if(c.getAnimal()=="Emus") {
							int res =players.getPlayers().get(j).getPlayerscore()+4;
							players.getPlayers().get(j).setPlayerscore(res);
						}
						
						if(c.getAnimal()=="Platypuses") {
							int res =players.getPlayers().get(j).getPlayerscore()+9;
							players.getPlayers().get(j).setPlayerscore(res);
						}
						
						

						
					}
					CheckFirstIndex++;
				}
				CheckSecondIndex++;
				
			}
		}
		
	}
	

}
