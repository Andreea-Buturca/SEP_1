package main.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by andreea on 12/1/2016.
 */
public class Reservation implements Serializable {

    private Trip trip;
    private Customer customer;
    private ArrayList<Passenger> passengers;
    private double defaultPricePerson;
    private double finalPrice;
    private double priceExtraServices;
    private double discount;

    public Reservation(Trip trip, Customer customer, ArrayList<Passenger> passengers, double price) {
        this.trip = trip;
        this.customer = customer;
        this.passengers = passengers;
        this.trip.freeSpaces -=this.passengers.size();
        this.defaultPricePerson = price;
        this.priceExtraServices = 0;
        this.discount = 0;
        this.finalPrice = 0;
    }

    public Customer getCustomer() {
        return this.customer;
    }
    public String getReservationByCompany() {
                return this.customer.getCompanyName();
    }
    public String getReservationByCustomerAddress() {
        return this.customer.getAddress();
    }
    public String getReservationByCustomerEmail(){ return this.customer.getEmail(); }
    public String getReservationByCustomerPhone(){ return this.customer.getEmail(); }
 //   public String getReservationByPassenger() { return this.passengers.g }

    public Destination getReservationDestination() {
        return this.trip.getDestination();
    }
    public Destination getReservationPickUpPoint() {
        return this.trip.getPickUpPoint();
    }
    public Date getReservationTimeStart() {
        return this.trip.getDateObjStart();
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
        String passsengers = "";
        for (int i = 0; i < passengers.size(); i++) {
            passsengers += " , for passenger nr: " + (i + 1) + this.passengers.get(i).toString();
        }
        return "Tour to: " + this.trip + " , price: " + this.finalPrice + " , reserved by customer: " + this.customer + passsengers;
    }
}
