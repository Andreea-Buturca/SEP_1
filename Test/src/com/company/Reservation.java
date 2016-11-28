package com.company;

/**
 * Created by Marek on 24-Nov-16.
 */
public class Reservation {
    private Customer customer;
    private double price;
    private Tour tour;
    private String note;

    // TODO: 27-Nov-16 play with constructors
    // TODO: 27-Nov-16 possibly note class?

    public Reservation(Tour tour, Customer customer, String note, double price) {
        this.customer = customer;
        this.price = price;
        this.tour = tour;
        this.note=note;
    }

    public Reservation(Customer customer, Tour tour) {
        this.customer = customer;
        this.tour = tour;
    }

    public Reservation(Tour tour, String name, String address, String phone ){
        this.tour = tour;
        this.customer = new Customer(name, phone, address);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
