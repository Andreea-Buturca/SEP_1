package com.company;

import java.util.ArrayList;

/**
 * Created by Marek on 24-Nov-16.
 */
public class ReservationList {
    private ArrayList<Reservation> list;

    public ReservationList() {
        this.list = new ArrayList<>();
    }

    public void addToList(Reservation reservation){
        list.add(reservation);
    }

    public ArrayList<Reservation> getList() {
        return list;
    }
}
