package main.Model;


/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Passenger extends Person {

    private boolean subscribed;
    private int seatNumber;

    public Passenger(String name, String address, String email, String phone, MyDate dateOfBirth, boolean subscribed, int seatNumber) {
        super(name, address, email, phone, dateOfBirth);
        this.subscribed = subscribed;
        this.seatNumber = seatNumber;
    }
    public Passenger(String name, String address, String email, String phone, MyDate dateOfBirth) {
        super(name, address, email, phone, dateOfBirth);
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    public String toString()
    {
        String x="";
        if(subscribed)
        {x+=" subscribed ";}
        return super.toString()+x+", seat number: "+ this.seatNumber;
    }
}
