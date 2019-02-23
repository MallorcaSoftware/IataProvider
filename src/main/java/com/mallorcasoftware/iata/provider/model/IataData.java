package com.mallorcasoftware.iata.provider.model;

public class IataData {
    private String name;
    private String city;
    private String country;
    private String iata;
    private String icao;
    private float latitude;
    private float longitude;

    public IataData() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIata() {
        return this.iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getIcao() {
        return this.icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public float getLatitude() {
        return this.latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return this.longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String toString() {
        return "IataData{name='" + this.name + '\'' + ", city='" + this.city + '\'' + ", country='" + this.country + '\'' + ", iata='" + this.iata + '\'' + ", icao='" + this.icao + '\'' + ", latitude=" + this.latitude + ", longitude=" + this.longitude + '}';
    }
}
