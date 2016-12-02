package main.Model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Trip {

    private ArrayList<Customer> customers = new ArrayList<>();

    private Bus bus;
    private Destination pickUpPoint;
    private ArrayList<Destination> stops;
    private Date timeStart;
    private Date timeEnd;
    private ArrayList<String> notes;  // TODO: 29-Nov-16 so do we need it?

    public Trip(Bus bus, Destination pickUpPoint, ArrayList<Destination> stops, Date timeStart, Date timeEnd) {
        this.bus = bus;
        this.pickUpPoint = pickUpPoint;
        this.stops = stops;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this. notes = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public Trip(Bus bus, Destination pickUpPoint, Date timeStart, Date timeEnd) {
        this.bus = bus;
        this.pickUpPoint = pickUpPoint;
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
