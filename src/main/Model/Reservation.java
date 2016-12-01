package main.Model;

import java.util.ArrayList;

/**
 * Created by andreea on 12/1/2016.
 */
public class Reservation {
    private Trip trip;
    private Customer customer;
    private ArrayList<Passenger> passengers;

    private double defaultPricePerson;
    private double finalPrice;
    private double priceExtraServices;
    private double discount;

    public Reservation(Trip trip, Customer customer, ArrayList<Passenger> passengers, int price) {
        this.trip = trip;
        this.customer = customer;
        this.passengers = passengers;
        this.defaultPricePerson = price;
        this.priceExtraServices = 0;
        this.discount = 0;
        this.finalPrice = 0;
    }

    public Customer getReservationByCustomer() {
        return this.customer;
    }

    public Trip getReservationByTrip() {
        return this.trip;
    }

    public ArrayList<Passenger> getReservationPassengers() {
        return this.passengers;
    }

    public double getDefaultPricePerson() {
        return defaultPricePerson;
    }

    public void setDefaultPricePerson(int price) {
        this.defaultPricePerson = price;
    }

    public double getPriceExtraServices() {
        return priceExtraServices;
    }

    public void setPriceExtraServices(int priceExtraServices) {
        this.priceExtraServices = priceExtraServices;
    }

    public void setDiscount(double discount) {
        this.discount = (getDefaultPricePerson() + getPriceExtraServices()) * discount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice() {
        this.finalPrice = ((getDefaultPricePerson() + getPriceExtraServices()) - getDiscount()) * this.passengers.size();
    }

    public String toString() {
        return "Tour to: " + this.trip + " , Reserved by customer: " + this.customer + " , Passenger: " + this.passengers.toString() + " , price: " + this.finalPrice;
    }
}
