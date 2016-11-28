package com.company;

/**
 * Created by Marek on 24-Nov-16.
 */
public class Passenger extends Person {

    private int seatNumber;

    public Passenger(String name, String phoneNumber, String address, int seatNumber) {
        super(name, phoneNumber, address);
        this.seatNumber = seatNumber;
    }
}
