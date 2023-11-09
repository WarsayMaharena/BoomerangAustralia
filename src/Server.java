import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
	private ServerSocket aSocket;
	private ArrayList<Client> clients = new ArrayList<Client>();
	
	public Server(int numberPlayers, int numberOfBots, Players players) throws Exception {
        //for(int i=0; i<numberOfBots; i++) { 
        //	Player ThisPlayer = players.getPlayers().get(i);
        //	ThisPlayer.setIsBot(true);   
        //}
        
      /*  for(int i = 0; i<numberPlayers+numberOfBots; i++) {
        	Player ThisPlayer = players.getPlayers().get(i);
        	  
        	System.out.println("bot value: "+ThisPlayer.getIsBot());
        }*/

        //System.out.println(players.getPlayers().size());
        System.out.println(numberPlayers);
        if(numberPlayers>1) {
            aSocket = new ServerSocket(2048);
        }
        /*
        ArrayList<Client> addedclient=new ArrayList<Client>();
        
        for(int i=numberOfBots+1; i<numberOfBots+numberPlayers; i++) {
        	System.out.println("HELLO---------");
        	Socket connectionSocket = aSocket.accept();
            ObjectInputStream inFromClient = new ObjectInputStream(connectionSocket.getInputStream());
            ObjectOutputStream outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());
            Client client = new Client(outToClient, inFromClient, connectionSocket);
            addedclient.add(client);
            //Player ThisPlayer = players.getPlayers().get(i);
            //ThisPlayer.setConnection(connectionSocket);
            //ThisPlayer.setInFromClient(inFromClient);
            //ThisPlayer.setOutToClient(outToClient);
            System.out.println("Connected to player " + i);
            outToClient.writeObject("You connected to the server as player " + i + "\n");
            String message = (String) inFromClient.readObject();
            System.out.println("message: "+ message);
        }
        while(true) {
        	
        }*/
        
	}
	
	public void runServer(int numberPlayers, int numberOfBots) throws Exception{
	       ArrayList<Client> addedclient=new ArrayList<Client>();
	        
	        for(int i=numberOfBots+1; i<numberOfBots+numberPlayers; i++) {
	        	System.out.println("HELLO--");
	        	Socket connectionSocket = aSocket.accept();
	            ObjectInputStream inFromClient = new ObjectInputStream(connectionSocket.getInputStream());
	            ObjectOutputStream outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());
	            Client client = new Client(outToClient, inFromClient, connectionSocket);
	            addedclient.add(client);
	            //Player ThisPlayer = players.getPlayers().get(i);
	            //ThisPlayer.setConnection(connectionSocket);
	            //ThisPlayer.setInFromClient(inFromClient);
	            //ThisPlayer.setOutToClient(outToClient);
	            System.out.println("Connected to player " + i);
	            outToClient.writeObject("You connected to the server as player " + i + "\n");
	            //String message = (String) inFromClient.readObject();
	            //System.out.println("message: "+ message);
	        }
	        
	        setClients(addedclient);
	        //System.out.println(clients.get(0));
	        //System.out.println(clients.get(1));
	       
	       // MsgClient(0,"Hello from the server client 1");
	       // MsgClient(1,"Hello from the server client 2");
	       //clients.get(0).getServerOutput().writeObject("Hello from the server client 1");
	       //clients.get(1).getServerOutput().writeObject("Hello from the server client 2");
	       //MsgClient(0,"Your Turn");
	       //String newmsg = readClient(0);
	       //System.out.println(newmsg);
	       
	      // clients.get(0).getServerOutput().writeObject("Your Turn");
	      // String msg = (String) clients.get(0).getServerInput().readObject();
	      // System.out.println(msg);
	       
	       //MsgClient(1,"Your Turn");
	       //newmsg = readClient(1);
	       //System.out.println(newmsg+"done with server???");
	        
	      // clients.get(1).getServerOutput().writeObject("Your Turn");
	      // msg = (String) clients.get(1).getServerInput().readObject();
	      // System.out.println(msg);
	       
		
		
	}
	
    // Getter for clients
    public ArrayList<Client> getClients() {
        return clients;
    }

    // Setter for clients
    public void setClients(ArrayList<Client> clientsList) {
        clients = clientsList;
    }
    
    public String readClient(int i) throws ClassNotFoundException, IOException {
    	String getClientMessage = (String) clients.get(i).getServerInput().readObject();
    	return getClientMessage;
    	
    }
    
    public void MsgClient (int i, String msg) throws IOException {
    	clients.get(i).getServerOutput().writeObject(msg);
    }
    
    
	
}
