package main.Model;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Person {

    private String Name;
    private String Address;
    private String email;
    private String phone;
    private MyDate dateOfBirth;

    public Person(String name, String address, String email, String phone) {
        Name = name;
        Address = address;
        this.email = email;
        this.phone = phone;
    }

    public Person(String name, String address, String email, String phone, MyDate dateOfBirth) {
        Name = name;
        Address = address;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }
}
