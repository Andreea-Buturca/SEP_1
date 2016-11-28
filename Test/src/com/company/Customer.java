package com.company;

/**
 * Created by Marek on 24-Nov-16.
 */
public class Customer extends Person {

    private int numberOfTrips;

    public Customer(String name, String phoneNumber, String address) {
        super(name, phoneNumber, address);
        numberOfTrips = 0;
    }

    public int getNumberOfTrips() {
        return numberOfTrips;
    }

    public String getName() {
        return super.getName();
    }

    public String getAddress() {
        return super.getAddress();
    }

    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    public boolean isFrequent() {
        return numberOfTrips > 20;
        // TODO: 27-Nov-16 when is frequent?
    }

    public void addTrip() {
        numberOfTrips++;
    }
}
