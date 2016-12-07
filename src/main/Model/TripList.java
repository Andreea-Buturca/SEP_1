package main.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Marek on 04-Dec-16.
 */

public class TripList implements Serializable {

    private ArrayList<Trip> trips;

    public TripList() {
        this.trips = new ArrayList<>();
    }

    public void add(Trip trip) {
        this.trips.add(trip);
    }

    public int getSize() {
        return trips.size();
    }

    public void remove(Trip trip) {
        trips.remove(trip);
    }

    public Trip get(int index) {
        return trips.get(index);
    }

    public ArrayList<Trip> getArrayTrip() {
        return trips;
    }

    public TripList findAllByDate(LocalDate date) {
        TripList result = new TripList();
        for (Trip trip : trips) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(trip.getDateObjStart());
            if ((cal.get(Calendar.YEAR) == date.getYear())
                    && (cal.get(Calendar.MONTH) == date.getMonthValue())
                    && (cal.get(Calendar.DAY_OF_MONTH) == date.getDayOfMonth())) {
                result.add(trip);
            }
        }
        return result;
    }

    public TripList findAllByDeparture(String departure) {
        TripList result = new TripList();
        for (Trip trip : trips) {
            if (trip.getPickUpPoint().getPlace().equals(departure)) {
                result.add(trip);
            }
        }
        return result;
    }

    public TripList findAllByDestination(String destination) {
        TripList result = new TripList();
        for (Trip trip : trips) {
            if (trip.getDestination().getPlace().equals(destination)) {
                result.add(trip);
            }
        }
        return result;
    }

    public TripList findAllByPassengers(String nrOfPassangers) {
        int passengers = Integer.parseInt(nrOfPassangers);
        TripList result = new TripList();
        for (Trip trip : trips) {
            if (trip.getFreeSpaces() > passengers) {
                result.add(trip);
            }
        }
        return result;
    }

    public String toString() {
        String result = "";
        for (Trip trip : trips) result += trip.toString() + "\n";
        return result;
    }
}
