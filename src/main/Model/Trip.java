package main.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Trip implements Serializable {



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
    private String duration;;

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
       this.duration = this.getDuration(this.timeStart, this.timeEnd);
       this.price = Integer.parseInt(price);
    }

    public String getDuration(Date start, Date end) {
        String result = "";
        long diff = end.getTime()-start.getTime();
        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
        if(diffDays>0){
            result+=diffDays+" day ";
        }
        diff -= diffDays * (24 * 60 * 60 * 1000);

        int diffhours = (int) (diff / (60 * 60 * 1000));
        if(diffhours>0){
            result+=diffhours+" hour ";
        }
        diff -= diffhours * (60 * 60 * 1000);

        int diffmin = (int) (diff / (60 * 1000));
        if(diffmin>0){
            result+=diffmin+" min ";
        }
        return result;
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

    public Destination getPickUpPoint() {
        return pickUpPoint;
    }

    public Destination getDestination() {
        return destination;
    }
}
