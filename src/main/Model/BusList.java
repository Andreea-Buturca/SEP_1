package main.Model;

import java.util.ArrayList;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class BusList {


    ArrayList<Bus> buses = new ArrayList<>();

    public BusList() {
    }

    public void add(Bus bus) {
        buses.add(bus);
    }

    public ArrayList<Bus> getArrayBuses() {
        return buses;
    }

    public ArrayList<Bus> getAllAvailable(int seats) {// TODO: 28-Nov-16 Finish

        // TODO: 02-Dec-16 make it pass arguments start date with time, end date with time just these two
        return null;
    }

    public Bus getAtIndex(int index) {
        return buses.get(index);
    }


    public void removeBus(Bus bus) {
        buses.remove(bus);
    }

    public int getSize() {
        return buses.size();
    }

    public Bus findByRegplate(String regPlate) {
        for (int i = 0; i < buses.size(); i++) {
            if (buses.get(i).getRegistrationPlate().equals(regPlate))
                return buses.get(i);
        }
        return null;
    }

    public BusList findAllByRegplate(String regPlate) {
        BusList result = new BusList();
        for (int i = 0; i < buses.size(); i++) {
            if (buses.get(i).getRegistrationPlate().equals(regPlate))
                result.add(buses.get(i));
        }
        return result;
    }


    public ArrayList<Bus> searchByType(String name) {
        ArrayList<Bus> busTemp = new ArrayList<>();

        for (Bus bus : buses) {
            if (bus.getClass().getName().equals(name)) busTemp.add(bus);
        }

        return busTemp;
    }

    public int getIndex(Bus bus) {
        for (int i = 0; i < buses.size(); i++) {
            if (buses.get(i).equals(bus))
                return i;
        }
        return -1;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < buses.size(); i++) {
            result += buses.get(i).toString() + "\n";
        }
        return result;
    }

}
