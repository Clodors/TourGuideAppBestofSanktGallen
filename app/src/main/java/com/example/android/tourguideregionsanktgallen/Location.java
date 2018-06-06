package com.example.android.tourguideregionsanktgallen;

public class Location {
    private String locationName;
    private String locationDesc;
    private String locationLoc;
    private int locationImage;

    public Location(String locationName, String locationDesc, String locationLoc) {
        this.locationName = locationName;
        this.locationDesc = locationDesc;
        this.locationLoc = locationLoc;
    }

    public Location(String locationName, String locationDesc, String locationLoc, int locationImage) {
        this.locationName = locationName;
        this.locationDesc = locationDesc;
        this.locationLoc = locationLoc;
        this.locationImage = locationImage;
    }



    public String getLocationName() {
        return locationName;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public int getLocationImage() {
        return locationImage;
    }

    public String getLocationLoc() {
        return locationLoc;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationName='" + locationName + '\'' +
                ", locationDesc='" + locationDesc + '\'' +
                ", locationImage=" + locationImage +
                '}';
    }
}
