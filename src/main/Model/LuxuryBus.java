package main.Model;

import java.io.Serializable;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class LuxuryBus extends Bus implements Serializable {

    public LuxuryBus(String registrationPlate, int seatPlaces) {
        super(registrationPlate, seatPlaces);
    }

    public String getBusType() {
        return "Luxury Bus";
    }

    public String toString() {
        return " Bus type: Luxury Bus, " + super.toString();
    }
}
