import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;

//Card object that is supposed to represent a card
public class Card {
	
	//its attributes
	private String  name, site, region, collection, animal, activity;
	private int hashtagg;
	
	public Card(String Country, String CardNumber) {

		
        switch (Country) {
        case "Australia":
    		Ausmethod(Country, CardNumber);
            break;
        default:
            System.out.println("Unknown location: " + Country);
            break;
    }
	}
		
	//Methos to convert the json file into objects
	void Ausmethod(String country, String keyToPrint) {
		//change to src/Cards.json if you wanna run it in eclipse, otherwise use 
		String jsonFilePath = "Cards.json";
        
		try {
			// Create a FileReader to read the JSON file
			FileReader fileReader = new FileReader(jsonFilePath);
			
			// Parse the JSON file using Gson and JsonParser
			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = jsonParser.parse(fileReader).getAsJsonObject();
			
			// Get the specified object by its key
			JsonObject selectedObject = jsonObject.getAsJsonObject(keyToPrint);
			
			// Create a Gson object
			Gson gson = new Gson();
			
			// Deserialize the JSON object into a TouristSite object
			AUSCard touristSite = gson.fromJson(selectedObject, AUSCard.class);
			
			// Print the content of the selected object
			//System.out.println("Tourist Site " + keyToPrint + ":");
			this.name = touristSite.getName();
			this.site = touristSite.getSite();
			this.region = touristSite.getRegion();
			this.hashtagg = touristSite.getHashtagg();
			this.collection = touristSite.getCollection();
			this.animal = touristSite.getAnimal();
			this.activity = touristSite.getActivity();
			
			
			
			// Close the FileReader
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//getters and setters for each attibute
    public String getName() {
    	return this.name;
    }
    
    public String getSite() {
    	return this.site;
    }
    
    public String getRegion() {
    	return this.region;
    }
    
    public int getHashtagg() {
    	return this.hashtagg;
    }
    
    public String getCollection() {
    	return this.collection;
    }
    
    public String getAnimal() {
    	return this.animal;
    }
    
    public String getActivity() {
    	return this.activity;
    }
	
		        
		        
	
	

	    
	 

}
