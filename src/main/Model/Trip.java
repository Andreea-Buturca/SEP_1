package main.Model;

import java.util.ArrayList;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Trip {

    private ArrayList<Customer> customers = new ArrayList<>();

    private Bus bus;
    private Destination pickUpPoint;
    private ArrayList<Destination> stops;
    private MyDate timeStart;
    private MyDate timeEnd;
    private ArrayList<String> notes;  // TODO: 29-Nov-16 so do we need it?

    public Trip(Bus bus, Destination pickUpPoint, ArrayList<Destination> stops, MyDate timeStart, MyDate timeEnd) {
        this.bus = bus;
        this.pickUpPoint = pickUpPoint;
        this.stops = stops;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this. notes = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addNote(String note){
        notes.add(note);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }
}
