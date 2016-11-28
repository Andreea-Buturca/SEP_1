package main.Model;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Bus {

    // TODO: 28-Nov-16 No choice from buslist in GUI
    // TODO: 28-Nov-16 how do you know if there's enough free seats
    // TODO: 28-Nov-16 Does bustype in make tour create new bus?
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

    // TODO: 28-Nov-16  Solve when is available and when not!

}
