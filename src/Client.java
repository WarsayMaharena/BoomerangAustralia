import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	//socket connection
    private Socket aSocket;
    private ObjectOutputStream outToServer;
    private ObjectInputStream inFromServer;
    
    //Input and Output from the servers perspective
    private Socket connect;
    private ObjectOutputStream ServerOutput;
    private ObjectInputStream ServerInput;
    

    //constructor for the client
    public Client(String ipAddress) throws IOException {
        aSocket = new Socket(ipAddress, 2048);
        outToServer = new ObjectOutputStream(aSocket.getOutputStream());
        inFromServer = new ObjectInputStream(aSocket.getInputStream());
    }
    
    //second constructor from the servers perspective
    public Client(ObjectOutputStream out, ObjectInputStream in, Socket connect) {
    	setServerOutput(out);
    	setServerInput(in);
    	setConnect(connect);
    	
    	
    }
    
    // Getter for ServerInput
    public ObjectInputStream getServerInput() {
        return ServerInput;
    }

    // Setter for ServerInput
    public void setServerInput(ObjectInputStream inStream) {
        ServerInput = inStream;
    }
    
    // getter for ServerOutput
    public ObjectOutputStream getServerOutput() {
        return ServerOutput;
    }

    // Setter for ServerOutput
    public void setServerOutput(ObjectOutputStream outStream) {
        ServerOutput = outStream;
    }
    
    //getter for socket connection
    public Socket getConnect() {
    	return this.connect;
    }
    
    
    public void setConnect(Socket connect) {
    	this.connect=connect;
    }

    //where the client reads and responds messages from and to the server
    public void runClient() throws IOException, ClassNotFoundException {
        String nextMessage = "";
        while (!nextMessage.contains("winner")) {
            nextMessage = (String) inFromServer.readObject();
            System.out.println(nextMessage);
            if(nextMessage.contains("Your Turn") || nextMessage.contains("keep")) {
                System.out.println("TYPE SOMETHING");
            	Scanner in = new Scanner(System.in);
	            outToServer.writeObject(in.nextLine());
            }
        }
    }
}
	
