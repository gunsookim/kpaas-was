package site.kormunity.kpaaswas.model;

import lombok.Getter;

import java.util.List;

@Getter
public class ApiResponse {
    private List<LocationData> data;

    public void setData(List<LocationData> data) {
        this.data = data;
    }

    @Getter
    public static class LocationData {
        private String name;
        private double latitude;
        private double longitude;

        public LocationData() {
        }

        public LocationData(String name, double latitude, double longitude) {
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
}
