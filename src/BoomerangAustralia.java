public class BoomerangAustralia{
	public static void main(String[] args) throws Exception {

		//must have valid parameters
        if (args.length > 2 || args.length==0) {
            System.out.println("Please provide two or one argument(s).");
            
            //client function
        } else if(args.length == 1) {
        	Client client = new Client(args[0]);
        	client.runClient();
        	System.out.println("you connected as client");
        	
        	//at most 4 players
        } else if(Integer.parseInt(args[0])+Integer.parseInt(args[1])>4){
        	System.out.println("Maximum amount of 4 players");
        	
        	//server
        } else {
        	System.out.println("You are the server");
        	int arg1=Integer.parseInt(args[0]);
        	int arg2=Integer.parseInt(args[1]);
        	new SetUpGame(arg1, arg2);
        }
        
    }
	
}