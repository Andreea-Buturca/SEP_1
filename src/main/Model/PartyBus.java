package main.Model;

import java.io.Serializable;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class PartyBus extends Bus implements Serializable {
    private boolean bar;
    private boolean dj;


    public PartyBus(String registrationPlate, int seatPlaces, boolean bar, boolean dj) {
        super(registrationPlate, seatPlaces);
        this.bar = bar;  // TODO: 29-Nov-16 Same as with luxury bus?
        this.dj = dj;
    }

    public PartyBus(String registrationPlate, int seatPlaces) {
        super(registrationPlate, seatPlaces);
    }

    public String getBusType() {
        return "Party Bus";
    }

    @Override
    public String toString() {
        return " Bus type: Party Bus, " + super.toString();
    }
}
