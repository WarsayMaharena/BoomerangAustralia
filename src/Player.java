import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/*A class supposed to represent the player, where most methods are tied to the
 * behaviours of the player himself.
 * */

public class Player {
	
	//attributerna för spelarens egenskaper
    private int playerID;
    private boolean online;
    private boolean isBot;
    
    private int playerscore;
    private ArrayList<Card> YourDeck = new ArrayList<Card>();
    private ArrayList<Card> tempYourDeck = new ArrayList<Card>();
    private ArrayList<Card> DraftedCards = new ArrayList<Card>();
    private ArrayList<Card> AllUsedCards = new ArrayList<Card>();
    private ArrayList<Card> PairAnimals = new ArrayList<Card>();
    private Card throwCard;
    private Card catchCard;
    
    
    //getters och setters
    public int getPlayerID() {
    	return this.playerID;
    	
    }
    
    public boolean getOnline() {
    	return this.online;
    	
    }
    
    public boolean getIsBot() {
    	return this.isBot;
    	
    }
    
    
    public ArrayList<Card> getYourDeck(){
    	return this.YourDeck;
    }
    
    public ArrayList<Card> getDraftedCards(){
    	return this.DraftedCards;
    }

    
    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public void setIsBot(boolean isBot) {
        this.isBot = isBot;
    }


    public void setYourDeck(ArrayList<Card> yourDeck) {
        this.YourDeck = yourDeck;
    }

    public void setDraftedCards(ArrayList<Card> draftedCards) {
        this.DraftedCards = draftedCards;
    }

	public Card getThrowCard() {
		return throwCard;
	}

	public void setThrowCard(Card throwCard) {
		this.throwCard = throwCard;
	}

	public Card getCatchCard() {
		return catchCard;
	}

	public void setCatchCard(Card catchCard) {
		this.catchCard = catchCard;
	}
	
	//method so that you get your cards printed to your screen
	public String printCards() {
			
			
			ArrayList<Card> deck = getYourDeck();
			int decksize = deck.size();
			for(int j = 0; j <= decksize-1; j++) {
				Card cards = deck.get(j);
				
			}
			
			String printString = String.format("%27s", "Site [letter] (nr):  ");
			for(int j = 0; j <= decksize-1; j++) {
				Card c = deck.get(j);	
				printString += String.format("%-35s", c.getName()+ " ["+c.getSite()+"] ("+c.getHashtagg()+")");
				
			}
			
			printString += "\n" + String.format("%27s", "Region:  ");
			for(int j = 0; j <= decksize-1; j++) { //print name letter and number of each card
				Card c = deck.get(j); 
				printString += String.format("%-35s", c.getRegion());
			}	
			
			printString +="\n" + String.format("%27s", "Collections:  ");
			for(int j = 0; j <= decksize-1; j++) { //print collections of each card, separate with tab
				Card c = deck.get(j);  
				printString  += String.format("%-35s", c.getCollection());
			}
			
			printString +="\n" + String.format("%27s", "Animals:  ");
			for(int j = 0; j <= decksize-1; j++) { //print animals of each card, separate with tab
				Card c = deck.get(j);  
				printString += String.format("%-35s", c.getAnimal());
			}
			printString +="\n" + String.format("%27s", "Activities:  ");
			for(int j = 0; j <= decksize-1; j++) { //print activities of each card, separate with tab
				Card c = deck.get(j); 
				printString += String.format("%-35s", c.getActivity());
			}
			//System.out.println("-----------------------------------------IM IN HERE");
		    //System.out.println("Player none"+ " with id: none"+"------------IN SETUPGAME-FINALfinal-----"); // Assuming you have a toString method defined in your Player class
		    return printString;
		}
	
	//method to show your cards to the opposing team
	public String ShowYourChosenCard() {
		int decksize = getDraftedCards().size();
		ArrayList<Card> deck = new ArrayList<Card>();
		deck.add(getDraftedCards().get(decksize-1));
		
		
		for(int j = 0; j < 1; j++) {
			Card cards = deck.get(j);
			
		}
		
		String printString = String.format("%27s", "Site [letter] (nr):  ");
		for(int j = 0; j < 1; j++) {
			Card c = deck.get(j);	
			printString += String.format("%-35s", c.getName()+ " ["+c.getSite()+"] ("+c.getHashtagg()+")");
			
		}
		
		printString += "\n" + String.format("%27s", "Region:  ");
		for(int j = 0; j < 1; j++) { //print name letter and number of each card
			Card c = deck.get(j); 
			printString += String.format("%-35s", c.getRegion());
		}	
		
		printString +="\n" + String.format("%27s", "Collections:  ");
		for(int j = 0; j < 1; j++) { //print collections of each card, separate with tab
			Card c = deck.get(j);  
			printString  += String.format("%-35s", c.getCollection());
		}
		
		printString +="\n" + String.format("%27s", "Animals:  ");
		for(int j = 0; j < 1; j++) { //print animals of each card, separate with tab
			Card c = deck.get(j);  
			printString += String.format("%-35s", c.getAnimal());
		}
		printString +="\n" + String.format("%27s", "Activities:  ");
		for(int j = 0; j < 1; j++) { //print activities of each card, separate with tab
			Card c = deck.get(j); 
			printString += String.format("%-35s", c.getActivity());
		}
		//System.out.println("-----------------------------------------IM IN HERE");
	    //System.out.println("Player none"+ " with id: none"+"------------IN SETUPGAME-FINALfinal-----"); // Assuming you have a toString method defined in your Player class
	    return printString;
		
	}

	//getters and setters for the players deck
	public ArrayList<Card> getTempYourDeck() {
		return tempYourDeck;
	}

	public void setTempYourDeck(ArrayList<Card> tempYourDeck) {
		this.tempYourDeck = tempYourDeck;
	}

	public int getPlayerscore() {
		return playerscore;
	}

	public void setPlayerscore(int playerscore) {
		this.playerscore = playerscore;
	}

	public ArrayList<Card> getAllUsedCards() {
		return AllUsedCards;
	}

	public void setAllUsedCards(ArrayList<Card> allUsedCards) {
		AllUsedCards = allUsedCards;
	}

	}


    


