package main.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by andreea on 12/1/2016.
 */
public class ReservationList implements Serializable {
    private ArrayList<Reservation> reservations;


    public ReservationList() {
        this.reservations = new ArrayList<>();
    }

    public void add(Reservation reservation) {
        reservations.add(reservation);
    }

    public ArrayList<Reservation> getArrayReservation() {
        return this.reservations;
    }


    public void remove(Reservation reservation) {
        reservations.remove(reservation);
    }

    public int getSize() {
        return reservations.size();
    }

    public Reservation getReservation(int index) {
        return reservations.get(index);
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
