package Objects;

public class Location extends java.lang.Object{
    private String address;
    private double longitude,latitude;

    Location(String address,double longitude,double latitude){
        this.address=address;
        this.longitude=longitude;
        this.latitude=latitude;
    }

    public String getAddress() {
        return address;
    }

    public Location getLocation(){
        return this;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
