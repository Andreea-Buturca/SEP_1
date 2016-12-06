package main.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Customer extends Person implements Serializable {

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
        if (!Objects.equals(super.getName(), customer.getName())) return false;
        if (!Objects.equals(super.getAddress(), customer.getAddress())) return false;
        if (super.getEmail() != customer.getEmail()) return false;
        return super.getPhone() == customer.getPhone();
    }


    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void addPointToCustomer() {
        points = points++;
    }


    public String getCompanyName() {
        return companyName;
    }

    public boolean isFrequent() {
        return points > 5;
    }

    public String toString() {
        String x = "";
        if (isCompany) {
            x += ", Company name: " + this.companyName;
        }
        String frequent="";
        if(isFrequent()){
            frequent += ", Frequent customer, nr of points: "+ this.points;
        }
        else if(!isFrequent()){
            frequent += ", nr of points: "+ this.points;
        }
        return super.toString() + x + frequent ;
    }

}