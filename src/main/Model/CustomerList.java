package main.Model;

import java.util.ArrayList;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class CustomerList {

    ArrayList<Customer> customers = new ArrayList<>();


    public CustomerList() {
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer findByName(String name){
        for (int i=0; i<customers.size();i++){
            if (customers.get(i).getName().equals(name))
                return customers.get(i);
        }
        return null;
    }
    public Customer findByPhone(String phone){
        for (int i=0; i<customers.size();i++){
            if (customers.get(i).getPhone().equals(phone))
                return customers.get(i);
        }
        return null;
    }
    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public String toString()
    {
        String s = "";
        for (int i = 0; i < customers.size(); i++)
        {
            s += customers.get(i);
            if (i < customers.size() - 1)
                s += "\n";
        }
        return s;
    }
}
