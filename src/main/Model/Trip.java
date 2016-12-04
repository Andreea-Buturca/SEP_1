package main.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Trip {



    private Bus bus;
    private Chauffeur chauffeur;
    private Destination pickUpPoint;
    private Destination destination;
    private DestinationList stops;
    private Date timeStart;
    private Date timeEnd;
    private ArrayList<String> notes; // TODO: 29-Nov-16 so do we need it?
    private Customer customer;
    private boolean isPrivate;
    private int distance;
    private int price;

    public Trip(Bus bus, Chauffeur chauffeur, Destination pickUpPoint, Destination destination, int distance,
                LocalDate dateStart, String timeStart, LocalDate dateEnd, String timeEnd, String price) {
       this.bus = bus;
       this.chauffeur = chauffeur;
       this.pickUpPoint = pickUpPoint;
       this.destination = destination;
       this.distance = distance;
       String[] lineToken = timeStart.split(":");
       int hours = Integer.parseInt(lineToken[0]);
       int minutes = Integer.parseInt(lineToken[1]);
       this.timeStart = new Date(dateStart.getYear()-1900, dateStart.getMonthValue(), dateStart.getDayOfMonth(), hours, minutes);
       lineToken = timeEnd.split(":");
       hours = Integer.parseInt(lineToken[0]);
       minutes = Integer.parseInt(lineToken[1]);
       this.timeEnd = new Date(dateEnd.getYear()-1900, dateEnd.getMonthValue(), dateEnd.getDayOfMonth(), hours, minutes);
       this.price = Integer.parseInt(price);


    }


    public void setStops(DestinationList stops) {
        this.stops = stops;
    }

    public void setCustomer(Customer customer) {
        this.isPrivate = true;
        this.customer = customer;
    }

    public Bus getBus() {
        return bus;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void addNote(String note) {
        notes.add(note);
    }


}
