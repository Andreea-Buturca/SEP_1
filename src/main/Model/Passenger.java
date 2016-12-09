package main.Model;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 * Class that represents a passenger in trip.
 * Class extends Person class
 *
 * @author IT-1Y-A16 Group 1
 */

public class Passenger extends Person implements Serializable {

    /**
     * Constructs a Passenger object.
     *
     * @param name        name of passenger
     * @param address     address of passenger
     * @param email       email of passenger
     * @param dateOfBirth passenger's date of birth
     */

    public Passenger(String name, String address, String email, LocalDate dateOfBirth) {
        super(name, address, email, dateOfBirth);
    }

    /**
     * Method that checks if passenger is more than 18 years old.
     *
     * @return true if adult
     */

    public boolean isAdult() {
        LocalDate bday = super.getDateOfBirth();
        LocalDate today = LocalDate.now();
        if (Period.between(bday, today).getYears() > 18)
            return true;
        else
            return false;
    }

    /**
     * Method that converts Passenger object to String
     *
     * @return passenger converted to String
     */

    public String toString() {
        return super.toString();
    }
}
