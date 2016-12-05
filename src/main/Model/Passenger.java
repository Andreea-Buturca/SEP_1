package main.Model;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Passenger extends Person implements Serializable {

    public Passenger(String name, String address, String email, LocalDate dateOfBirth) {
        super(name, address, email, dateOfBirth);
    }
public String getPassengerName(){ return super.getName(); }
    public String toString() {
        return super.toString();
    }
}
