package main.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Person {

    private String name;
    private String address;
    private String email;
    private String phone;
    private Date dateOfBirth;

    public Person(String name, String address, String email, String phone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public Person(String name, String address, String email, String phone, Date dateOfBirth) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(String name, String address, String email, Date dateOfBirth) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String toString() {
        String email = "";
        if (this.email != null) {
            email += ", email: " + this.email;
        }
        String phone = "";
        if (this.phone != null) {
            phone += ", phone: " + this.phone;
        }
        if (this.dateOfBirth != null) {
            SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
            return this.name + ", address: " + this.address + email + phone + ", birthday: " + ft.format(this.dateOfBirth);
        } else {
            return this.name + ", address: " + this.address + email + phone;
        }
    }
}
