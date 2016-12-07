package main.Model;

import java.io.Serializable;
import java.time.LocalDate;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!name.equals(person.name)) return false;
        if (!address.equals(person.address)) return false;
        if (!email.equals(person.email)) return false;
        if (!phone.equals(person.phone)) return false;
        return dateOfBirth.equals(person.dateOfBirth);
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
        if (!this.address.equals("")) {
            address += ", address: " + this.address;
        }
        if (this.dateOfBirth != null) {
            return this.name + address + email + phone + ", birthday: " + this.dateOfBirth;
        } else {
            return this.name + address + email + phone;
        }
    }
}
