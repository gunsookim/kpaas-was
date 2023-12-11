package site.kormunity.kpaaswas.model;

import lombok.Getter;

@Getter
public class Location {

    private String name; // 장소명
    private double latitude; // 위도
    private double longitude; // 경도

    public Location() {
    }

    public Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
