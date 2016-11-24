package main;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class PartyBus extends Bus{
    private boolean bar;
    private boolean dj;


    public PartyBus(String registrationPlate, int seatPlaces, boolean bar, boolean dj) {
        super(registrationPlate, seatPlaces);
        this.bar = bar;
        this.dj = dj;
    }
}
