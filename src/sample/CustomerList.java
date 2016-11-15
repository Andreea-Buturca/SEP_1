package sample;

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
}
