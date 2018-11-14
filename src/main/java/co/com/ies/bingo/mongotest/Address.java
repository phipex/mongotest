package co.com.ies.bingo.mongotest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {

    private String way;
    private String city;
    private String country;
    private String address;

    public Address() {
    }

    @JsonCreator
    public Address(@JsonProperty("way") String way, @JsonProperty("city") String city, @JsonProperty("country") String country) {
        this.way = way;
        this.city = city;
        this.country = country;
    }

    public String getWay() {
        return way;
    }

    public Address setWay(String way) {
        this.way = way;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Address setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "Address{" +
                "way='" + way + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }



}
