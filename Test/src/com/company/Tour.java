package com.company;

/**
 * Created by Marek on 27-Nov-16.
 */
public class Tour {
    private String destination;
    private Date departure;
    private Date arrival;
    private Bus bus;
    private boolean isBusAndChauuffeur;

    public Tour(String destination, Date departure, Date arrival, Bus bus, boolean isBusAndChauuffeur) {
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
        this.bus = bus;
        this.isBusAndChauuffeur = isBusAndChauuffeur;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDeparture() {
        return departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public Bus getBus() {
        return bus;
    }
}
