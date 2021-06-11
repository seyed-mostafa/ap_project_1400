package Objects;

public class Location extends java.lang.Object{
    private String address;
    private double longitude,latitude;

    public Location(String address, double latitude,double longitude){
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
