package main.Model;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class MiniBus extends Bus {

    public MiniBus(String registrationPlate, int seatPlaces) {
        super(registrationPlate, seatPlaces);
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: Mini Bus";
    }
}
