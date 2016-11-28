package main.Model;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Chauffeur extends Person {

    private int EmployeeID;
    private int preferredDistance;
    private String preferredTripType;
    private int workedHours;
    private boolean isVikar;

    public Chauffeur(String name, String address, String email, String phone, int employeeID, int preferredDistance, String preferredTripType, int workedHours, boolean isVikar) {
        super(name, address, email, phone);
        // TODO: 28-Nov-16 check if employeeid is 5-digit number.
        EmployeeID = employeeID;
        this.preferredDistance = preferredDistance;
        this.preferredTripType = preferredTripType;
        this.workedHours = workedHours;
        this.isVikar = isVikar;
    }

    public Chauffeur(String name, String address, String email, String phone, MyDate dateOfBirth, int employeeID, int preferredDistance, String preferredTripType, int workedHours, boolean isVikar) {
        super(name, address, email, phone, dateOfBirth);
        EmployeeID = employeeID;
        this.preferredDistance = preferredDistance;
        this.preferredTripType = preferredTripType;
        this.workedHours = workedHours;
        this.isVikar = isVikar;
    }

    public Chauffeur(String name, String address, String email, String phone, int workedHours, boolean isVikar) {
        super(name, address, email, phone);
        this.workedHours = workedHours;
        this.isVikar = isVikar;
    }

}
