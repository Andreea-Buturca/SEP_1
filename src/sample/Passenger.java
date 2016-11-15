package sample;

import java.util.Date;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Passenger extends Person {

    private boolean subscribed;
    private int seatNumber;

    public Passenger(String name, String adress, String email, String phone, MyDate dateOfBirth, boolean subscribed, int seatNumber) {
        super(name, adress, email, phone, dateOfBirth);
        this.subscribed = subscribed;
        this.seatNumber = seatNumber;
    }
}
