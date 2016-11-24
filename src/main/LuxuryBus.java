package main;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class LuxuryBus extends Bus{

    private boolean snack;
    private boolean waiter;

    public LuxuryBus(String registrationPlate, int seatPlaces, boolean snack, boolean waiter) {
        super(registrationPlate, seatPlaces);
        this.snack = snack;
        this.waiter = waiter;
    }
}
