package main.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

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


    public Chauffeur(String name, String address, String email, String phone, LocalDate dateOfBirth, int employeeID, boolean isVikar) {
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


    public ArrayList<String> getArrayBusTypes() {
        return this.busType;
    }

    public void setPreferredBusType(String bus) {
        this.busType.add(bus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chauffeur)) return false;
        if (!super.equals(o)) return false;

        Chauffeur chauffeur = (Chauffeur) o;

        if (employeeID != chauffeur.employeeID) return false;
        if (workedHours != chauffeur.workedHours) return false;
        if (isVikar != chauffeur.isVikar) return false;
        if (!preferredDistance.equals(chauffeur.preferredDistance)) return false;
        return bus != null ? bus.equals(chauffeur.bus) : chauffeur.bus == null && busType.equals(chauffeur.busType);
    }

    @Override
    public int hashCode() {
        int result = employeeID;
        result = 31 * result + preferredDistance.hashCode();
        result = 31 * result + workedHours;
        result = 31 * result + (isVikar ? 1 : 0);
        result = 31 * result + (bus != null ? bus.hashCode() : 0);
        result = 31 * result + busType.hashCode();
        return result;
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
