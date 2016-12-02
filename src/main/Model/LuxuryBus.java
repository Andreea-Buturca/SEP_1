package main.Model;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class LuxuryBus extends Bus {

    private boolean snack;
    private boolean waiter;

    public LuxuryBus(String registrationPlate, int seatPlaces, boolean snack, boolean waiter) {
        super(registrationPlate, seatPlaces);
        this.snack = snack; // TODO: 29-Nov-16 do we really need that?
        this.waiter = waiter;
    }

    public LuxuryBus(String registrationPlate, int seatPlaces) {
        super(registrationPlate, seatPlaces);
    }

    public String getBusType(){ return "Luxury Bus";}

    public String toString() {
        return super.toString() + ", Type: Luxury Bus";
    }

    // TODO: 29-Nov-16 when adding a bus in gui there is no place to tick if it has snacs and waiter.
}
