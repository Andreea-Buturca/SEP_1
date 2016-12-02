package main.Model;

import java.util.Date;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Chauffeur extends Person {

    private int employeeID;
    private int preferredDistance;
    private int workedHours;
    private boolean isVikar;
    private Bus bus;
    private String busType;



    public Chauffeur(String name, String address, String email, String phone, Date dateOfBirth, int employeeID, boolean isVikar) {
        super(name, address, email, phone, dateOfBirth);
        if (this.employeeID >= 10000 & this.employeeID <= 99999) {
            this.employeeID = employeeID;
        }
        this.employeeID = employeeID;
        this.bus=null;
        this.isVikar = isVikar;
        this.preferredDistance=0;
        this.workedHours=0;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    public String getName() {
        return super.getName();
    }

    public String getAddress() {
        return super.getAddress();
    }

    public String getEmail() {
        return super.getEmail();
    }

    public String getPhone() {
        return super.getPhone();
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setPreferredShortDistance(int distance) {
        if (distance <= 400)
            this.preferredDistance = distance;
    }

    public void setPreferredMediumDistance(int distance) {
        if (distance > 400 && distance <= 3000)
            this.preferredDistance = 3000;
    }

    public void setPreferredLongDistance(int distance) {
        if (distance > 3000)
            this.preferredDistance = distance;
    }

    public int getPreferredDistance() {
        return preferredDistance;
    }

    public String getPreferredBusType(String bus){
    if (this.bus.getBusType().equals(bus))
        return "Classic Bus";
    else if (this.bus.getBusType().equals(bus))
        return "Mini Bus";
    else if (this.bus.getBusType().equals(bus))
        return "Party Bus";
    else if (this.bus.getBusType().equals(bus))
        return "Luxury Bus";
    else return null;
}
 public void setPreferredBusType(String bus) {
         this.busType = bus;
 }

    public void setPreferredWeekHours(int hours) {
        if(hours>17)
        this.workedHours = hours;
    }

    public void setPreferredWeekendHours(int hours) {
        if (hours < 17)
            this.workedHours = hours;
    }

    public int getPreferredWorkedHours() {
        return workedHours;
    }

    public boolean isVikar() {
        return isVikar;
    }

    public String toString() {
        String preferredDistance="";
        if(this.preferredDistance != 0)
        {
            preferredDistance += ", Preferred distance: " + this.preferredDistance +" km";
        }
        String preferredHours="";
        if(this.workedHours < 17 && this.workedHours > 0)
        {
            preferredHours = ", Preferred working hours: " + this.workedHours +"h, in weekends ";
        }
        if(this.workedHours > 17)
        {
            preferredHours = ", Preferred working hours: " + this.workedHours +"h, during the week ";
        }
        String preferredBusType="";
        if(this.busType != null)
        {
            preferredBusType=", Preferred bus Type: "+this.busType;
        }
        String vikar = "";
        if (this.isVikar) {
            vikar = ", Vikar employee";
        }
        return super.toString() + ", chauffeur ID: " + this.employeeID + preferredDistance + preferredHours + preferredBusType + vikar;
    }
}
