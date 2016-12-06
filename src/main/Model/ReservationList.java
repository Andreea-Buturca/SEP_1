package main.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

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

    public Reservation getReservationByCustomer(Customer customer) {
        for (Reservation reservation : reservations) {
            if (reservation.getCustomer().equals(customer))
                return reservation;
        }
        return null;
    }

    public Reservation getReservationByCompany(String companyName) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationByCompany().equals(companyName))
                return reservation;
        }
        return null;
    }

    public Reservation getReservationByDestination(Trip trip) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationByTrip().equals(trip))
                return reservation;
        }
        return null;
    }

    public ArrayList<Reservation> getArrayReservation() {
        return this.reservations;
    }

    public int getReservationNumbers() {
        return this.reservations.size();
    }

    public ReservationList findAllReservationByDate(LocalDate date) {
        ReservationList result = new ReservationList();
        for (Reservation reservation : reservations) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(reservation.getReservationTimeStart());
            if ((cal.get(Calendar.YEAR) == date.getYear())
                    && (cal.get(Calendar.MONTH) == date.getMonthValue())
                    && (cal.get(Calendar.DAY_OF_MONTH) == date.getDayOfMonth())) {
                result.add(reservation);
            }
        }
        return result;
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

    public ReservationList findAllReservationByDeparture(String departure) {
        ReservationList other = new ReservationList();
        for (Reservation reservation : reservations) {
            if (reservation.getReservationPickUpPoint().equals(departure)) {
                other.add(reservation);
            }
        }
        return other;
    }

    public ReservationList findAllReservationByDestination(String destination) {
        ReservationList result = new ReservationList();
        for (Reservation reservation : reservations) {
            if (reservation.getReservationDestination().equals(destination)) {
                result.add(reservation);
            }
        }
        return result;
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
