package main.Model;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Chauffeur extends Person {

    private int EmployeeID;
    private int prefferedDistance;
    private String prefferedTripType;
    private int workedHours;
    private boolean isVikar;

    public Chauffeur(String name, String adress, String email, String phone, int employeeID, int prefferedDistance, String prefferedTripType, int workedHours, boolean isVikar) {
        super(name, adress, email, phone);
        // TODO: 28-Nov-16 check if employeeid is 5-digit number.
        EmployeeID = employeeID;
        this.prefferedDistance = prefferedDistance;
        this.prefferedTripType = prefferedTripType;
        this.workedHours = workedHours;
        this.isVikar = isVikar;
    }

    public Chauffeur(String name, String adress, String email, String phone, MyDate dateOfBirth, int employeeID, int prefferedDistance, String prefferedTripType, int workedHours, boolean isVikar) {
        super(name, adress, email, phone, dateOfBirth);
        EmployeeID = employeeID;
        this.prefferedDistance = prefferedDistance;
        this.prefferedTripType = prefferedTripType;
        this.workedHours = workedHours;
        this.isVikar = isVikar;
    }

    public Chauffeur(String name, String adress, String email, String phone, int workedHours, boolean isVikar) {
        super(name, adress, email, phone);
        this.workedHours = workedHours;
        this.isVikar = isVikar;
    }

}
