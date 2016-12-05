package main.Model;

import java.io.Serializable;
import java.util.ArrayList;
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

    public Trip findByDestination(String destination) {
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

    public Trip getTrip(Trip trip) {
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).equals(trip))
                return trips.get(i);
        }
        return null;
    }

    public int getTripListSize() {
        return this.trips.size();
    }

    public TripList findAllByDate(LocalDate date) {
        TripList result = new TripList();
        for (int i = 0; i < trips.size(); i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(trips.get(i).getDateObjStart());
            if ((cal.get(Calendar.YEAR) == date.getYear())
                    && (cal.get(Calendar.MONTH) == date.getMonthValue())
                    && (cal.get(Calendar.DAY_OF_MONTH) == date.getDayOfMonth())) {
                result.add(trips.get(i));
            }
        }
        return result;
    }

    public TripList findAllByDeparture(String departure) {
        TripList result = new TripList();
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getPickUpPoint().getPlace().equals(departure)) {
                result.add(trips.get(i));
            }
        }
        return result;
    }

    public TripList findAllByDestination(String destination) {
        TripList result = new TripList();
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getDestination().getPlace().equals(destination)) {
                result.add(trips.get(i));
            }
        }
        return result;
    }

    public TripList findAllByPassengers(String nrOfPassangers) {
        int passengers = Integer.parseInt(nrOfPassangers);
        TripList result = new TripList();
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getFreeSpaces()>passengers) {
                result.add(trips.get(i));
            }
        }
        return result;
    }

    public Trip findByToString(String tripToString) {
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).toString().equals(tripToString)) {
                return trips.get(i);
            }
        }
        return null;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < trips.size(); i++)
            result += trips.get(i).toString() + "\n";
        return result;
    }
}
