package main.Model;

import java.util.ArrayList;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Trip {

    private ArrayList<Bus> buses = new ArrayList<>();

    private Customer customer;
    private Destination pickUpPoint;
    private ArrayList<Destination> stops;
    private MyDate timeStart;
    private MyDate timeEnd;
    private ArrayList<String> note;

    public void addNote(String note){

    }
}
