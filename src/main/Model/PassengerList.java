package main.Model;

import java.util.ArrayList;

/**
 * Created by andreea on 12/1/2016.
 */
public class PassengerList {
   private ArrayList<Passenger> passengers = new ArrayList<>();


    public PassengerList() {
    }

    public void add(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public Passenger findByName(String name){
        for (int i=0; i<passengers.size();i++){
            if (passengers.get(i).getName().equals(name))
                return passengers.get(i);
        }
        return null;
    }
    public Passenger findByPhone(String phone){
        for (int i=0; i<passengers.size();i++){
            if (passengers.get(i).getPhone().equals(phone))
                return passengers.get(i);
        }
        return null;
    }
    public Passenger findByEmail(String email){
        for (int i=0; i<passengers.size();i++){
            if (passengers.get(i).getEmail().equals(email))
                return passengers.get(i);
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

    public String toString()
    {
        String s = "";
        for (int i = 0; i < passengers.size(); i++)
        {
            s += passengers.get(i);
            if (i < passengers.size() - 1)
                s += "\n";
        }
        return s;
    }
}
