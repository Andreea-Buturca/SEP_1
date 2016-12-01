package main.Model;

import java.util.ArrayList;

/**
 * Created by andreea on 12/1/2016.
 */
public class ReservationList {
    private ArrayList<Reservation> reservations;


    public ReservationList() {
        this.reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public Reservation getReservationByCustomer(Customer customer) {
        for (int i = 0; i < reservations.size(); i++) {
            if (this.reservations.get(i).getReservationByCustomer().equals(customer))
                return this.reservations.get(i);
        }
        return null;
    }
    public Reservation getReservationByDestination(Trip trip) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getReservationByTrip().equals(trip))
                return this.reservations.get(i);
        }
        return null;
    }

    public ArrayList<Reservation> getReservations() {
        return this.reservations;
    }

    public int getReservationNumbers() {
        return this.reservations.size();
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < reservations.size(); i++) {
            s += reservations.get(i);
            if (i < reservations.size() - 1)
                s += "\n";
        }
        return s;
    }
}
