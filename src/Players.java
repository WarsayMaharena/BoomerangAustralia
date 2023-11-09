import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Players {
	private ArrayList<Player> players = new ArrayList<Player>();
	private int NumberOfBots;
	private int NumberOfHumanPlayers;
	
	public Players(int NumPlayers) {
		ArrayList<Player> AddedPlayers = new ArrayList<Player>();
		for(int i=0; i<=NumPlayers-1; i++) {
			Player player = new Player();
			AddedPlayers.add(player);
		}
		setPlayers(AddedPlayers);
	
	}
	
	public void setIsBot(int numberOfBots){
        for(int i=0; i<numberOfBots; i++) { 
        	Player ThisPlayer = getPlayers().get(i);
        	ThisPlayer.setIsBot(true);   
        }
	}
	
    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

	public int getNumberOfBots() {
		return NumberOfBots;
	}

	public void setNumberOfBots(int numberOfBots) {
		NumberOfBots = numberOfBots;
	}

	public int getNumberOfHumanPlayers() {
		return NumberOfHumanPlayers;
	}

	public void setNumberOfHumanPlayers(int numberOfHumanPlayers) {
		NumberOfHumanPlayers = numberOfHumanPlayers;
	}
	
	public void LookAtYourCards(Server server) throws IOException {
		System.out.println("\n\nHOSTS CARD\n\n");
		int Hostindex = getNumberOfBots();
		int MaxPlayers= getNumberOfHumanPlayers()+Hostindex;
		System.out.println(getPlayers().get(Hostindex).printCards());
		int j = 0;
		for(int i = Hostindex + 1; i<MaxPlayers; i++) {
			String clientmsg = getPlayers().get(i).printCards();
			//System.out.println("helloclient");
			server.MsgClient(j, clientmsg);
			j++;
		}
		//System.out.println("does it work duuuuuuuuuuuuuuuude");
		

	}
	
	public void ShowYourCards(Server server) throws IOException {
		System.out.println("\n\nOPPENNENTS CARDS\n\n");
		int Hostindex = getNumberOfBots();
		int MaxPlayers= getNumberOfHumanPlayers()+Hostindex;
		String msg = "";
		for(int i=0; i<MaxPlayers; i++) {
			if(i==Hostindex) {
				continue;
			}
			else {
				msg = "Playerid: "+(i+1)+"\n"+getPlayers().get(i).ShowYourChosenCard()+msg+"\n\n"; 
			}
		}
		System.out.println(msg);
		int j = 0;
		String msg1="";
		for(int i = Hostindex + 1; i<MaxPlayers; i++) {
			for(int k = 0; k<Hostindex+1; k++) {
				msg1 = "Playerid: "+(k+1)+"\n"+getPlayers().get(k).ShowYourChosenCard()+msg1+"\n\n";
			}
			String clientmsg = msg1;
			//System.out.println("helloclient");
			server.MsgClient(j, clientmsg);
			j++;
		}
	}
	
	public void PickACardToDraft(Server server) throws IOException, ClassNotFoundException {
		
		//For Bots
		int Hostindex = getNumberOfBots();
		int MaxPlayers=getNumberOfHumanPlayers()+Hostindex;
		//System.out.println(getPlayers().get(Hostindex).printCards());
		int j = 0;
		//System.out.println(Hostindex+"BOTS LOOP HERE");
		//System.out.println("-----------------------------------------------------------------");
		for(int i=0; i<Hostindex; i++) {
			//System.out.println("-----------------------------------------------------------------");
			ArrayList<Card> CurrentDeck=new ArrayList<Card>(getPlayers().get(i).getYourDeck());
			getPlayers().get(i).getDraftedCards().add(CurrentDeck.get(0));
			//System.out.println("HELLOHELLOHELLO "+ getPlayers().get(i).getYourDeck().get(0));
			getPlayers().get(i).getYourDeck().remove(0);
			//System.out.println("HELLOHELLOHELLO "+ getPlayers().get(i).getYourDeck().get(0));
			//System.out.println("HELLOHELLOHELLO "+ getPlayers().get(i).getDraftedCards().get(0));
			//System.out.println("HELLOHELLOHELLO "+ getPlayers().get(i).getYourDeck().size());
			//System.out.println("HELLOHELLOHELLO "+ getPlayers().get(i).getDraftedCards().size());
			
		}
		System.out.println("-----------------------------------------------------------------");
		
		
		System.out.println("Your Turn");
		HostPlayersSelectADraft(Hostindex);
		ClientPlayerSelectDraft(server, Hostindex);
		

		
		
		
	}
	
	public void HostPlayersSelectADraft(int Hostindex) {
		ArrayList<Card> CurrentDeck=new ArrayList<Card>(getPlayers().get(Hostindex).getYourDeck());
		
		boolean value=false;
		while(true) {
			Scanner in = new Scanner(System.in);
			System.out.println("hello");
			String input = in.nextLine();
			int NumberCard = 0;
			for(Card cards:CurrentDeck) {
				//System.out.println(input);
				//System.out.println(cards.getSite());
				//System.out.println(cards);
				//System.out.println(NumberCard);
				
				if(input.equals(cards.getSite())) {
					//System.out.println("does it get in here"+input+"\n");
					value=true;
					break;
				}
				NumberCard++;
			}
			
				//System.out.println("draftlop");
			if(value==true) {
				getPlayers().get(Hostindex).getDraftedCards().add(CurrentDeck.get(NumberCard));
				//System.out.println("HELLOHELLOHELLO "+ getPlayers().get(Hostindex).getYourDeck().get(NumberCard));
				getPlayers().get(Hostindex).getYourDeck().remove(NumberCard);
				System.out.println("found it");
				//System.out.println("HELLOHELLOHELLO "+ getPlayers().get(Hostindex).getYourDeck().get(NumberCard));
				//System.out.println("HELLOHELLOHELLO "+ getPlayers().get(Hostindex).getDraftedCards().get(0));
				//System.out.println("HELLOHELLOHELLO "+ getPlayers().get(Hostindex).getYourDeck().size());
				//System.out.println("HELLOHELLOHELLO "+ getPlayers().get(Hostindex).getDraftedCards().size());
				break;
				}
			else{
				System.out.println("Cant find it");
				}
			
			
		}
		//System.out.println("OUTSIDE THE LOOPALOOP");
		
	}
	
	public void ClientPlayerSelectDraft(Server server, int Hostindex) throws ClassNotFoundException, IOException {
		//System.out.println("clientfunc1");
		int j=0;
		for(int i=Hostindex+1; i<NumberOfBots+NumberOfHumanPlayers; i++) {
			//System.out.println("clientfunc2");
			ArrayList<Card> CurrentDeck=new ArrayList<Card>(getPlayers().get(i).getYourDeck());
			boolean value=false;
			while(true) {
				//System.out.println("clientfunc3");
				server.MsgClient(j, "Pick A Card, Your Turn");
				String input= (String) server.readClient(j);
				//System.out.println("helloAMIINHERE");
				int NumberCard = 0;
				for(Card cards:CurrentDeck) {
					//System.out.println(input);
					//System.out.println(cards.getSite());
					//System.out.println(cards);
					//System.out.println(NumberCard);
					
					if(input.equals(cards.getSite())) {
						System.out.println("does it get in here"+input+"\n");
						value=true;
						break;
					}
					NumberCard++;
				}
				
					System.out.println("draftlop");
				if(value==true) {
					getPlayers().get(i).getDraftedCards().add(CurrentDeck.get(NumberCard));
					//System.out.println("HELLOHELLOHELLO "+ getPlayers().get(i).getYourDeck().get(NumberCard));
					getPlayers().get(i).getYourDeck().remove(NumberCard);
					//System.out.println("found it");
					//System.out.println("HELLOHELLOHELLO "+ getPlayers().get(i).getYourDeck().get(NumberCard));
					//System.out.println("HELLOHELLOHELLO "+ getPlayers().get(i).getDraftedCards().get(0));
					//System.out.println("HELLOHELLOHELLO "+ getPlayers().get(i).getYourDeck().size());
					//System.out.println("HELLOHELLOHELLO "+ getPlayers().get(i).getDraftedCards().size());
					break;
					}
				else{
					server.MsgClient(j, "Couldnt find it");
					//System.out.println("Cant find ityepyepyep");
					}
				
				
			}
		System.out.println("OUTSIDE THE LOOPALOOP");
		j++;
		}
	}
	
	public void SendToNextPlayer(Players players) {
		for(int i =0; i<getNumberOfBots()+getNumberOfHumanPlayers(); i++) {
			ArrayList<Card> tempdeck = new ArrayList<Card>(players.getPlayers().get(i).getYourDeck());
			players.getPlayers().get(i).setTempYourDeck(tempdeck);
		}
		for(int i =0; i<getNumberOfBots()+getNumberOfHumanPlayers()-1; i++) {
			ArrayList<Card> tempdeck = new ArrayList<Card>(players.getPlayers().get(i).getTempYourDeck());
			players.getPlayers().get(i+1).setYourDeck(tempdeck);
		}
		ArrayList<Card> tempdeck = new ArrayList<Card>(players.getPlayers().get(getNumberOfBots()+getNumberOfHumanPlayers()-1).getTempYourDeck());
		players.getPlayers().get(0).setYourDeck(tempdeck);
	}
	
	public void SendToPrevPlayer(Players players) {
		for(int i =0; i<getNumberOfBots()+getNumberOfHumanPlayers(); i++) {
			ArrayList<Card> tempdeck = new ArrayList<Card>(players.getPlayers().get(i).getYourDeck());
			players.getPlayers().get(i).setTempYourDeck(tempdeck);
		}
		for(int i = getNumberOfBots()+getNumberOfHumanPlayers()-1; i>0; i--) {
			ArrayList<Card> tempdeck = new ArrayList<Card>(players.getPlayers().get(i).getTempYourDeck());
			players.getPlayers().get(i-1).setYourDeck(tempdeck);
		}
		ArrayList<Card> tempdeck = new ArrayList<Card>(players.getPlayers().get(0).getTempYourDeck());
		players.getPlayers().get(getNumberOfBots()+getNumberOfHumanPlayers()-1).setYourDeck(tempdeck);
		
	}
	
	

}
