package com.websystique.springmvc.entities;

public class Tour {
    private String country;
    private String excursion;
    private int hotel;
    private int cost;

    public Tour(String country, String excursion, int hotel, int cost) {
        this.country = country;
        this.excursion = excursion;
        this.hotel = hotel;
        this.cost = cost;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getExcursion() {
        return excursion;
    }

    public void setExcursion(String excursion) {
        this.excursion = excursion;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
