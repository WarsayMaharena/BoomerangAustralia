import com.google.gson.annotations.SerializedName;

//WHere the json parser reads and converts the json objects into java objects

public class AUSCard {
    @SerializedName("name")
    private String name;

    @SerializedName("site")
    private String site;

    @SerializedName("region")
    private String region;

    @SerializedName("hashtagg")
    private int hashtagg;

    @SerializedName("collection")
    private String collection;

    @SerializedName("animal")
    private String animal;

    @SerializedName("activity")
    private String activity;
    
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
