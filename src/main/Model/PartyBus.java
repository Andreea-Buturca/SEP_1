package main.Model;

import java.io.Serializable;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class PartyBus extends Bus implements Serializable {
    public PartyBus(String registrationPlate, int seatPlaces) {
        super(registrationPlate, seatPlaces);
    }

    public String getBusType() {
        return "Party Bus";
    }

    @Override
    public String toString() {
        return "Party Bus, " + super.toString();
    }
}
