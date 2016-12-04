package main.Model;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Passenger extends Person implements Serializable {

    public Passenger(String name, String address, String email, Date dateOfBirth) {
        super(name, address, email, dateOfBirth);
    }

    public String toString() {
        return super.toString();
    }
}
