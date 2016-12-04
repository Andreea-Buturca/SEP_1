package main.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by andreea on 12/4/2016.
 */
public class TripList implements Serializable {
    private ArrayList<Trip> trips = new ArrayList<>();


    public TripList() {
    }

    public void add(Trip trip) {
        this.trips.add(trip);
    }

    public Trip findByDestination(Destination destination) {
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getDestination().equals(destination))
                return trips.get(i);
        }
        return null;
    }

    public Trip findByStartDate(LocalDate date) {
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getTimeStart().equals(date))
                return trips.get(i);
        }
        return null;
    }

    public Trip findByPrice(double price) {
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getPrice() == price)
                return trips.get(i);
        }
        return null;
    }

    public ArrayList<Trip> getArrayTrip() {
        return trips;
    }

public Trip getTrip(Trip trip){
        for(int i=0;i<trips.size();i++)
        {
            if(trips.get(i).equals(trip))
                return trips.get(i);
        }
        return null;
}
    public String toString() {
        String s = "";
        for (int i = 0; i < trips.size(); i++) {
            s += trips.get(i);
            if (i < trips.size() - 1)
                s += "\n";
        }
        return s;
    }
}
