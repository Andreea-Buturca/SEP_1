package main.Model;

import java.util.ArrayList;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Customer extends Person {

    private boolean isCompany;
    private String companyName;
    private ArrayList<Passenger> passengers = new ArrayList<>();
    private int numberOfTrips;

    private int points;


    public Customer(String name, String address, String email, String phone, boolean isCompany, String companyName) {
        super(name, address, email, phone);
        this.isCompany = isCompany;
        this.companyName = companyName;
    }

    public Customer(String name, String address, String email, String phone) {
        super(name, address, email, phone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        if (isCompany != customer.isCompany) return false;
        if (numberOfTrips != customer.numberOfTrips) return false;
        if (points != customer.points) return false;
        if (companyName != null ? !companyName.equals(customer.companyName) : customer.companyName != null)
            return false;
        return passengers.equals(customer.passengers);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void addPointToCustomer() {
        points = points++;
    }

    public boolean checkIfFrequentCustomer(Customer customer) {
        return true;
    }

    public String getCompanyName() {
        return companyName;
    }

    public boolean isFrequent() {
        return numberOfTrips > 5;
        // TODO: 28-Nov-16 how many trips is frequent?
    }

    public String toString() {
        String x = "";
        if (isCompany) {
            x += ", Company name: " + this.companyName;
        }
        return super.toString() + x;
    }
    // TODO: 03-Dec-16 probably add number of trips?
}