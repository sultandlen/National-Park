import java.util.ArrayList;

public class NP {
    private String parkName;
    private int area;
    private String listingDate;
    private ArrayList<String> locations;

    public NP(String parkName, int area, String listingDate, ArrayList<String> locations) {
        this.parkName = parkName;
        this.area = area;
        this.listingDate = listingDate;
        this.locations = locations;
    }


    // getters and setters
    public String getParkName() {
        return parkName;
    }

    public int getArea() {
        return area;
    }

    public String getListingDate() {
        return listingDate;
    }

    public ArrayList<String> getLocations() {
        return locations;
    }

    public String toString() { //to string
        return  "Park Name: " + parkName + '\n' +
                "Area: " + area + "\n" +
                "Listing Date: " + listingDate + '\n' +
                "Locations: " + locations + "\n";
    }
}