package main.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by andreea on 12/1/2016.
 */
public class PassengerList implements Serializable {
    private ArrayList<Passenger> passengers = new ArrayList<>();


    public PassengerList() {
    }

    public void add(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public Passenger findByName(String name) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(name))
                return passenger;
        }
        return null;
    }

    public Passenger findByPhone(String phone) {
        for (Passenger passenger : passengers) {
            if (passenger.getPhone().equals(phone))
                return passenger;
        }
        return null;
    }

    public Passenger findByEmail(String email) {
        for (Passenger passenger : passengers) {
            if (passenger.getEmail().equals(email))
                return passenger;
        }
        return null;
    }

    public ArrayList<Passenger> getArrayPassenger() {
        return passengers;
    }

    public void removePassenger(Passenger passenger) {
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).equals(passenger))
                passengers.remove(passenger);
        }
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < passengers.size(); i++) {
            s += passengers.get(i);
            if (i < passengers.size() - 1)
                s += "\n";
        }
        return s;
    }
}
