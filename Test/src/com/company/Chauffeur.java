package com.company;

/**
 * Created by Marek on 24-Nov-16.
 */
public class Chauffeur extends Person {

    private String email;
    private int employeeID;
    private String preferences;

   // TODO: 24-Nov-16 Solve issue with vicar drivers.
    // TODO: 27-Nov-16 when is free?

    public Chauffeur(String name, String phoneNumber, String address, String email, int employeeID, String preferences) {
        super(name, phoneNumber, address);
        this.email = email;
        this.employeeID = employeeID;
        this.preferences = preferences;
    }

}
