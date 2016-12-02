package main.Model;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Chauffeur extends Person {

    private int employeeID;
    private int preferredDistance;
    private int workedHours;
    private boolean isVikar;
    private Bus bus;



    public Chauffeur(String name, String address, String email, String phone, MyDate dateOfBirth, int employeeID, boolean isVikar) {
        super(name, address, email, phone, dateOfBirth);
        if (this.employeeID >= 10000 & this.employeeID <= 99999) {
            this.employeeID = employeeID;
        }
        this.employeeID = employeeID;
        this.isVikar = isVikar;
    }

    public void setPreferredDistance(int preferredDistance) {
        this.preferredDistance = preferredDistance;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
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
        return "Clasic Bus";
    else if (this.bus.getBusType().equals(bus))
        return "Mini Bus";
    else if (this.bus.getBusType().equals(bus))
        return "Party Bus";
    else if (this.bus.getBusType().equals(bus))
        return "Luxury Bus";
    else return null;
}
 public void setPreferredClassicBus() {
    if (this.bus instanceof ClassicBus) {
        ClassicBus classicBus = (ClassicBus) this.bus;
        if (classicBus.getBusType().equals("Clasic Bus"))
            this.bus = classicBus;
    }
}

    public void setPreferredWeekHours(int hours) {
        this.workedHours = hours;
    }

    public void setPreferredWeekendHours(int hours) {
        if (hours < 19)
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
            preferredDistance = ", Preferred distance: " + this.preferredDistance;
        }
        String preferredHours="";
        if(this.workedHours != 0)
        {
            preferredHours = ", Preferred worked hours: " + this.workedHours;
        }

        String vikar = "";
        if (this.isVikar) {
            vikar = ", Vikar employee";
        }
        return super.toString() + ", chauffeur ID: " + this.employeeID + preferredDistance + preferredHours + vikar;
    }
}
