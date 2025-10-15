package com.example.Okados.model;

public class Geolocation {
    private Double latitude;
    private Double longitude;
    private Double accuracy;

    public Geolocation(){}
    public Double getLatitude(){return latitude;} public void setLatitude(Double l){this.latitude=l;}
    public Double getLongitude(){return longitude;} public void setLongitude(Double l){this.longitude=l;}
    public Double getAccuracy(){return accuracy;} public void setAccuracy(Double a){this.accuracy=a;}
}
