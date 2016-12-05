package main.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Trip implements Serializable {


    private Bus bus;
    private Chauffeur chauffeur;
    private Destination pickUpPoint;
    private Destination destination;
    private DestinationList stops;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String timeStart;
    private String timeEnd;
    //private ArrayList<String> notes; // TODO: 29-Nov-16 so do we need it?
    private Customer customer;
    private boolean isPrivate;
    private int distance;
    private int price;
    private String duration;

    private Date dateObjStart;
    private Date dateObjEnd;

    public Trip(Bus bus, Chauffeur chauffeur, Destination pickUpPoint, Destination destination, int distance, LocalDate dateStart, String timeStart, LocalDate dateEnd,  String timeEnd, int price) {
        this.bus = bus;
        this.chauffeur = chauffeur;
        this.pickUpPoint = pickUpPoint;
        this.destination = destination;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.distance = distance;
        this.price = price;

        String[] lineToken = timeStart.split(":");
        int hours = Integer.parseInt(lineToken[0]);
        int minutes = Integer.parseInt(lineToken[1]);
        this.dateObjStart = new Date(dateStart.getYear()-1900, dateStart.getMonthValue(), dateStart.getDayOfMonth(), hours, minutes);
        lineToken = timeEnd.split(":");
        hours = Integer.parseInt(lineToken[0]);
        minutes = Integer.parseInt(lineToken[1]);
        this.dateObjEnd = new Date(dateEnd.getYear()-1900, dateEnd.getMonthValue(), dateEnd.getDayOfMonth(), hours, minutes);
        this.duration = this.getDuration(this.dateObjStart, this.dateObjEnd);


    }


    /*
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
    private String duration;

    public Trip(Bus bus, Chauffeur chauffeur, Destination pickUpPoint, Destination destination, int distance,
                LocalDate dateStart, String timeStart, LocalDate dateEnd, String timeEnd, int price) {
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
       //this.duration = this.getDuration(this.timeStart, this.timeEnd);
       this.price = price;
    }*/


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


    public Destination getPickUpPoint() {
        return pickUpPoint;
    }

    public Destination getDestination() {
        return destination;
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public DestinationList getStops() {
        return stops;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public int getDistance() {
        return distance;
    }

    public int getPrice() {
        return price;
    }

    public String getDuration() {
        return duration;
    }

    public Date getDateObjStart() {
        return dateObjStart;
    }

    public Date getDateObjEnd() {
        return dateObjEnd;
    }

    public String toString(){
        String result = "";
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDateObjStart());
        int year =(cal.get(Calendar.YEAR));
        int month =(cal.get(Calendar.MONTH));
        int day =(cal.get(Calendar.DAY_OF_MONTH));
        result+= day+"/"+month+"/"+year + " from " + pickUpPoint + " to " + destination;
        return result;
    }
}
