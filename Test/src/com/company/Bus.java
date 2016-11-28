package com.company;

import java.util.ArrayList;

/**
 * Created by Marek on 24-Nov-16.
 */
public class Bus {
    private Chauffeur chauffeur;
    private int numberOfSeats;
    private String regPlate;
    private Passenger[] seats;
    // TODO: 27-Nov-16 new class for each type? (party, mini, ...


    public Bus(Chauffeur chauffeur, int numberOfSeats, String regPlate) {
        this.chauffeur = chauffeur;
        this.numberOfSeats = numberOfSeats;
        this.regPlate = regPlate;
        seats = new Passenger[numberOfSeats];
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getRegPlate() {
        return regPlate;
    }

    public Passenger[] getSeats() {
        return seats;
    }

    public void addPassenger(Passenger passenger) {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] != null) {
                seats[i] = passenger;
                break;
            }
        }
    }

    public int getNumberOfAailable() {
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == null)
                count++;
        }
        return count;
    }

    public boolean checkIfAvailable(int seat) {
        return seats[seat - 1] == null;
    }


    public int[] getAllAvailable() {
        int[] result = new int[this.getNumberOfAailable()];
        int j = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == null) {
                result[j] = i + 1;
                j++;
            }
        }
        return result;
    }
}
