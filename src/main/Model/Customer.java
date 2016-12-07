package main.Model;

import java.io.Serializable;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Customer extends Person implements Serializable {

    private boolean isCompany;
    private String companyName;
    private int points;


    public Customer(String name, String address, String email, String phone, boolean isCompany, String companyName) {
        super(name, address, email, phone);
        this.isCompany = isCompany;
        this.companyName = companyName;
    }

    public Customer(String name, String address, String email, String phone) {
        super(name, address, email, phone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        if (!super.equals(o)) return false;

        Customer customer = (Customer) o;

        if (isCompany != customer.isCompany) return false;
        if (points != customer.points) return false;
        return companyName.equals(customer.companyName);

    }

    public void addPointToCustomer() {
        points = points++;
    }


    public String getCompanyName() {
        return companyName;
    }

    private boolean isFrequent() {
        return points > 5;
    }

    public String toString() {
        String x = "";
        if (isCompany) {
            x += ", Company name: " + this.companyName;
        }
        String frequent = "";
        if (isFrequent()) {
            frequent += ", Frequent customer, nr of points: " + this.points;
        } else if (!isFrequent()) {
            frequent += ", nr of points: " + this.points;
        }
        return super.toString() + x + frequent;
    }

}