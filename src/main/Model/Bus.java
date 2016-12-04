package main.Model;

import java.io.Serializable;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public abstract class Bus implements Serializable{

    private String registrationPlate;
    private int seatPlaces;


    public Bus(String registrationPlate, int seatPlaces) {
        this.registrationPlate = registrationPlate;
        this.seatPlaces = seatPlaces;
    }


    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public int getSeatPlaces() {
        return seatPlaces;
    }

    public String toString() {
        return registrationPlate + ", " + seatPlaces + " seats";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bus)) return false;

        Bus bus = (Bus) o;

        if (seatPlaces != bus.seatPlaces) return false;
        return registrationPlate.equals(bus.registrationPlate);
    }

    public abstract String getBusType();
}
