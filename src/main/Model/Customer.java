package main.Model;

import java.util.ArrayList;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Customer extends Person {

    private boolean isCompany;
    private String responsiblePerson;
    private ArrayList<Passenger> passengers = new ArrayList<>();
    private int numberOgTrips;

    private int points;


    public Customer(String name, String address, String email, String phone, boolean isCompany, String responsiblePerson) {
        super(name, address, email, phone);
        this.isCompany = isCompany;
        this.responsiblePerson = responsiblePerson;
    }

    public Customer(String name, String address, String email, String phone, boolean isCompany) {
        super(name, address, email, phone);
        this.isCompany = isCompany;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void addPointToCustomer() { points = points++; }

    public boolean checkIfFrequentCustomer(Customer customer){
        return true;
    }

    public boolean isFrequent(){
        return numberOgTrips>5;
        // TODO: 28-Nov-16 how many trips is frequent?
    }


}