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

    public boolean fit(int hotel, String excursion, String country){
        System.out.println(country);
        return(hotel == this.hotel && (this.excursion == null || this.excursion.equals(excursion) || excursion==null) && (this.country.equals(country) || country == null));
    }

    public String getCountry() {
        if(country.equals("en")){
            return "England";
        } else if(country.equals("by")){
            return "Belarus";
        } else if(country.equals("us")){
            return "USA";
        } else{
            return "France";
        }
    }

    @Override
    public String toString() {
        return "Tour{" +
                "country='" + country + '\'' +
                ", excursion='" + excursion + '\'' +
                ", hotel=" + hotel +
                ", cost=" + cost +
                '}';
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
