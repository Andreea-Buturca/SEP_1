package main.Model;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class ClassicBus extends Bus {

    public ClassicBus(String registrationPlate, int seatPlaces) {
        super(registrationPlate, seatPlaces);
    }

    public String toString() {
        return super.toString() + ", Type: Classic Bus";
    }
}
