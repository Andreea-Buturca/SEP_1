package com.company;

import java.util.ArrayList;

/**
 * Created by Marek on 24-Nov-16.
 */
public class CustomerList {
    private ArrayList<Customer> list;

    public CustomerList() {
        list = new ArrayList<>();
    }

    public ArrayList<Customer> getList() {
        return list;
    }

    public void addToList(Customer customer) {
        list.add(customer);
    }

    public Customer findCustomerByName(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                return list.get(i);
            }
        }

        return null;
    }
    public Customer findCustomerByAddress(String address) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAddress().equals(address)) {
                return list.get(i);
            }
        }

        return null;
    }
    public Customer findCustomerByPhone(String phone) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPhoneNumber().equals(phone)) {
                return list.get(i);
            }
        }

        return null;
    }
}
