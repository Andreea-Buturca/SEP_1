package main.Model;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Person {

    private String name;
    private String address;
    private String email;
    private String phone;
    private MyDate dateOfBirth;

    public Person(String name, String address, String email, String phone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public Person(String name, String address, String email, String phone, MyDate dateOfBirth) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }
    public String getName()
    {
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

    public MyDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String toString() {
        return this.name + ", address: " + this.address + ", email: " + this.email + ", phone: " + this.phone + ", birthday: " + this.dateOfBirth;
    }
}
