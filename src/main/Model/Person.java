package main.Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Person implements Serializable {

    private String name;
    private String address;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;

    public Person(String name, String address, String email, String phone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public Person(String name, String address, String email, String phone, LocalDate dateOfBirth) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(String name, String address, String email, LocalDate dateOfBirth) {
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String toString() {
        String email = "";
        if (!this.email.equals("")) {
            email += ", email: " + this.email;
        }
        String phone = "";
        if (this.phone != null) {
            phone += ", phone: " + this.phone;
        }
        String address = "";
        if(!this.address.equals("")){
            address +=  ", address: " + this.address;
        }
        if (this.dateOfBirth != null) {
            return this.name + address + email + phone + ", birthday: " + this.dateOfBirth;
        } else {
            return this.name + address + email + phone;
        }
    }
}
