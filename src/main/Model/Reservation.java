package main.Model;

import java.io.Serializable;

/**
 * Created by andreea on 12/1/2016.
 */
public class Reservation implements Serializable {

    private Trip trip;
    private Customer customer;
    private PassengerList passengerList;
    private double defaultPricePerson;
    private double finalPrice;
    private double priceExtraServices;
    private double discount;


    public Reservation(Trip trip, Customer customer, PassengerList passengerList, double price) {
        this.trip = trip;
        this.customer = customer;
        this.passengerList = passengerList;
        this.trip.freeSpaces -= this.passengerList.getArrayPassenger().size();
        this.defaultPricePerson = price;
        this.priceExtraServices = 0;
        this.discount = 0;
        this.finalPrice = 0;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Destination getReservationDestination() {
        return this.trip.getDestination();
    }

    public PassengerList getReservationPassengers() {
        return this.passengerList;
    }

    public double getDefaultPricePerson() {
        return defaultPricePerson;
    }

    public double getPriceExtraServices() {
        return priceExtraServices;
    }

    public void setPriceExtraServices(double priceExtraServices) {
        this.priceExtraServices = priceExtraServices;
    }

    public void setDiscount(double discount) {
        this.discount = (discount);
    }

    public Trip getTrip() {
        return trip;
    }

    public double getDiscount() {
        return discount;
    }

    public void setFinalPrice() {
        this.finalPrice = ((getDefaultPricePerson() + getPriceExtraServices()) - getDiscount()) * this.passengerList.getArrayPassenger().size();
    }

    public String toString() {
        String passsengers = "";
        for (int i = 0; i < passengerList.getArrayPassenger().size(); i++) {
            passsengers += " , Passenger nr. " + (i + 1) + ": " + this.passengerList.getArrayPassenger().get(i).toString();
        }
        return "Reservation for Customer: " + this.customer + passsengers + " , Total price: " + this.finalPrice + " , " + this.trip;
    }
}
