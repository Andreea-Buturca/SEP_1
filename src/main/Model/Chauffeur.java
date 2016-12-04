package main.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Chauffeur extends Person implements Serializable {

    private int employeeID;
    private ArrayList<Integer> preferredDistance;
    private int workedHours;
    private boolean isVikar;
    private Bus bus;
    private ArrayList<String> busType;


    public Chauffeur(String name, String address, String email, String phone, Date dateOfBirth, int employeeID, boolean isVikar) {
        super(name, address, email, phone, dateOfBirth);
        if (this.employeeID >= 10000 & this.employeeID <= 99999) {
            this.employeeID = employeeID;
        }
        this.employeeID = employeeID;
        this.bus = null;
        this.isVikar = isVikar;
        this.preferredDistance = new ArrayList<>();
        this.busType = new ArrayList<>();
        this.workedHours = 0;
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
        if (distance <= 400 && distance > 0)
            this.preferredDistance.add(distance);
    }

    public void setPreferredMediumDistance(int distance) {
        if (distance > 400 && distance < 2500)
            this.preferredDistance.add(distance);
    }

    public void setPreferredLongDistance(int distance) {
        if (distance >= 2500)
            this.preferredDistance.add(distance);
    }

    public ArrayList<Integer> getPreferredDistance() {
        return preferredDistance;
    }

    public String getPreferredBusType(String bus) {
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
        this.busType.add(bus);
    }

    public void setPreferredWeekHours(int hours) {
        if (hours > 17)
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
        String preferredDistance = "";
        for (int i = 0; i < this.preferredDistance.size(); i++) {
            preferredDistance += ", Preferred distance: " + this.preferredDistance.get(i) + " km";
            if (i < this.preferredDistance.size() - 1)
                preferredDistance += ", ";
        }
        String preferredHours = "";
        if (this.workedHours < 17 && this.workedHours > 0) {
            preferredHours += ", Preferred working hours: " + this.workedHours + "h, in weekends ";
        }
        if (this.workedHours > 17) {
            preferredHours += ", Preferred working hours: " + this.workedHours + "h, during the week ";
        }
        String preferredBusType = "";
        for (int i = 0; i < this.busType.size(); i++) {
            preferredBusType += ", Preferred bus Type: " + this.busType.get(i) + "";
            if (i < this.busType.size() - 1)
                preferredBusType += ", ";
        }
        String vikar = "";
        if (this.isVikar) {
            vikar = ", Vikar employee";
        }
        return super.toString() + ", chauffeur ID: " + this.employeeID + preferredDistance + preferredHours + preferredBusType + vikar;
    }
}
