import java.util.ArrayList;
import java.util.Collections;

public class FullDeck {
	private ArrayList<Card> FullDeckCards = new ArrayList<Card>();
	
	public FullDeck(String Country) {
		ArrayList<Card> list = new ArrayList<Card>();
        for (int i = 1; i <= 28; i++) {
            String cStr = "c" + i;
    		Card card = new Card(Country, cStr);
    		list.add(card);
        }
        Collections.shuffle(list);        
        setFullDeckCards(list);
        //System.out.println("OVER HEEEREEE"+getFullDeckCards().size());
	}
	
	public void DistributeCards(int NumCards, Players players, ArrayList<Card> list){
		int i =1;
		ArrayList<Card> ShuffledCards = new ArrayList<Card>(list);
		ArrayList<Player> AddedPlayers=players.getPlayers();
		for (Player player : AddedPlayers) {
		    // Access the YourDeck ArrayList
			//System.out.println("BREAK POINTOuterLoop------------- "+getFullDeckCards().size());
			ArrayList<Card> deck = new ArrayList<Card>();
			for(int j = 0; j <= NumCards-1; j++) {
				//System.out.println("BREAK POINTinnerloop------------- "+getFullDeckCards().size());
				deck.add(ShuffledCards.get(0));
				/*System.out.println("BREAK POINTinnerloop------------- "+getFullDeckCards().size());
				System.out.println(ShuffledCards.get(0));
				System.out.println("Name: " + deck.get(j).getName());
				System.out.println("Site: " + deck.get(j).getSite());
				System.out.println("Region: " + deck.get(j).getRegion());
				System.out.println("Hashtag: " + deck.get(j).getHashtagg());
				System.out.println("Collection: " + deck.get(j).getCollection());
				System.out.println("Animal: " + deck.get(j).getAnimal());
				System.out.println("Activity: " + deck.get(j).getActivity()+"\n");*/
				ShuffledCards.remove(0);
				//System.out.println("BREAK POINTinnerloop------------- "+getFullDeckCards().size());
			}
		    //System.out.println("Player "+i+ " with id: "+player+"----INSIDE FULLDECK--------------"); // Assuming you have a toString method defined in your Player class
		    i++;
		    //System.out.println("BREAK POINTinnerloop------------- "+getFullDeckCards().size());
		    player.setYourDeck(deck);
		    //System.out.println("BREAK POINTinnerloop------------- "+getFullDeckCards().size());
		}
		
		
	}
	
    public ArrayList<Card> getFullDeckCards() {
        return this.FullDeckCards;
    }

    public void setFullDeckCards(ArrayList<Card> FullDeckCards) {
        this.FullDeckCards = FullDeckCards;
    }

}
