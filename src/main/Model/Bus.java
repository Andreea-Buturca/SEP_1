package main.Model;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Bus {

    // TODO: 28-Nov-16 how do you know if there's enough free seats Solved

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

    // TODO: 28-Nov-16  Solve when is available and when not! Solved

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

}
