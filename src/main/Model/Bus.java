package main.Model;

import java.io.Serializable;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public abstract class Bus implements Serializable {

    private final String registrationPlate;
    private final int seatPlaces;


    Bus(String registrationPlate, int seatPlaces) {
        this.registrationPlate = registrationPlate;
        this.seatPlaces = seatPlaces;
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

        return seatPlaces == bus.seatPlaces && registrationPlate.equals(bus.registrationPlate);
    }

    public abstract String getBusType();
}
