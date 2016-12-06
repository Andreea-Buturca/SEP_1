package main.Model;

import java.io.Serializable;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class ClassicBus extends Bus implements Serializable {

    public ClassicBus(String registrationPlate, int seatPlaces) {
        super(registrationPlate, seatPlaces);
    }

    public String getBusType() {
        return "Clasic Bus";
    }

    public String toString() {
        return " Bus type: Classic Bus, " + super.toString();
    }
}
