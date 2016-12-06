package main.Model;

import java.io.Serializable;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class MiniBus extends Bus implements Serializable {

    public MiniBus(String registrationPlate, int seatPlaces) {
        super(registrationPlate, seatPlaces);
    }

    public String getBusType() {
        return "Mini Bus";
    }

    @Override
    public String toString() {
        return  " Bus type: Mini Bus, " + super.toString() ;
    }
}
