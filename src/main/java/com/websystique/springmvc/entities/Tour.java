package com.websystique.springmvc.entities;

public class Tour {
    private String country;
    private String excursion;
    private int hotel;

    public Tour(String country, String excursion, int hotel) {
        this.country = country;
        this.excursion = excursion;
        this.hotel = hotel;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String isExcursion() {
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
}
