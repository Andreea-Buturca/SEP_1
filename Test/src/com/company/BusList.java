package com.company;

import java.util.ArrayList;

/**
 * Created by Marek on 24-Nov-16.
 */
public class BusList {
    private ArrayList<Bus> list;

    public BusList() {
        this.list = new ArrayList<>();
    }

    public void addToList(Bus bus) {
        list.add(bus);
    }

    public ArrayList<Bus> getList() {
        return list;
    }

    public Bus findBusBySeats(int seats) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumberOfSeats()== seats) {
                return list.get(i);
            }
        }

        return null;
    }
    public Bus findBusByRegPlate(String regPlate) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRegPlate().equals(regPlate)) {
                return list.get(i);
            }
        }

        return null;
    }

    public ArrayList<Bus> getAllPossible(int seats){
        ArrayList<Bus> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumberOfSeats()>= seats) {
                result.add(list.get(i));
            }
        }

        return result;
    }

    public void remove(String regPlate){
        list.remove(this.findBusByRegPlate(regPlate));
    }


}
