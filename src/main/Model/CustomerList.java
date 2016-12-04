package main.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class CustomerList implements Serializable {

    private ArrayList<Customer> customers = new ArrayList<>();


    public CustomerList() {
    }

    public void add(Customer customer) {
        customers.add(customer);
    }

    public Customer findByName(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name))
                return customers.get(i);
        }
        return null;
    }

    public int getSize() {
        return customers.size();
    }

    public Customer getCustomerByIndex(int index) {
        return customers.get(index);
    }
    public Customer getCustomer(Customer customer){
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).equals(customer))
                return customers.get(i);
        }
        return null;
    }

    public CustomerList findAllByName(String name) {
        CustomerList result = new CustomerList();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name))
                result.add(customers.get(i));
        }
        return result;
    }

    public CustomerList findAllByAddress(String address) {
        CustomerList result = new CustomerList();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getAddress().equals(address))
                result.add(customers.get(i));
        }
        return result;
    }

    public Customer findByPhone(String phone) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getPhone().equals(phone))
                return customers.get(i);
        }
        return null;
    }

    public CustomerList findAllByPhone(String phone) {
        CustomerList result = new CustomerList();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getPhone().equals(phone))
                result.add(customers.get(i));
        }
        return result;
    }

    public CustomerList findAllByEmail(String email) {
        CustomerList result = new CustomerList();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getEmail().equals(email))
                result.add(customers.get(i));
        }
        return result;
    }

    public CustomerList findAllByCompanyName(String companyName) {
        CustomerList result = new CustomerList();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCompanyName().equals(companyName))
                result.add(customers.get(i));
        }
        return result;
    }

    public Customer findByCompany(String company) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCompanyName().equals(company))
                return customers.get(i);
        }
        return null;
    }

    public ArrayList<Customer> getArrayCustomer() {
        return customers;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < customers.size(); i++) {
            s += customers.get(i);
            if (i < customers.size() - 1)
                s += "\n";
        }
        return s;
    }
}