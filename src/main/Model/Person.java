package main.Model;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Person {

    private String Name;
    private String Adress;
    private String email;
    private String phone;
    private MyDate dateOfBirth;

    public Person(String name, String adress, String email, String phone) {
        Name = name;
        Adress = adress;
        this.email = email;
        this.phone = phone;
    }

    public Person(String name, String adress, String email, String phone, MyDate dateOfBirth) {
        Name = name;
        Adress = adress;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }
}
