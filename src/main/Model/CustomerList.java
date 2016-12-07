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

    public void remove(Customer customer) {
        customers.remove(customer);
    }

    public Customer findByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name))
                return customer;
        }
        return null;
    }

    public int getSize() {
        return customers.size();
    }

    public Customer getCustomer(int index) {
        return customers.get(index);
    }

    public CustomerList findAllByName(String name) {
        CustomerList result = new CustomerList();
        for (Customer customer : customers) {
            if (customer.getName().equals(name))
                result.add(customer);
        }
        return result;
    }

    public CustomerList findAllByAddress(String address) {
        CustomerList result = new CustomerList();
        for (Customer customer : customers) {
            if (customer.getAddress().equals(address))
                result.add(customer);
        }
        return result;
    }

    public Customer findByPhone(String phone) {
        for (Customer customer : customers) {
            if (customer.getPhone().equals(phone))
                return customer;
        }
        return null;
    } // TODO: 05-Dec-16 this has weird behavior

    public CustomerList findAllByPhone(String phone) {
        CustomerList result = new CustomerList();
        for (Customer customer : customers) {
            if (customer.getPhone().equals(phone))
                result.add(customer);
        }
        return result;
    }

    public CustomerList findAllByEmail(String email) {
        CustomerList result = new CustomerList();
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email))
                result.add(customer);
        }
        return result;
    }

    public CustomerList findAllByCompanyName(String companyName) {
        CustomerList result = new CustomerList();
        for (Customer customer : customers) {
            if (customer.getCompanyName().equals(companyName))
                result.add(customer);
        }
        return result;
    }

    public Customer findByCompany(String company) {
        for (Customer customer : customers) {
            if (customer.getCompanyName().equals(company))
                return customer;
        }
        return null;
    }

    public int getIndex(Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).equals(customer))
                return i;
        }
        return -1;
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