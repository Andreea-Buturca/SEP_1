package main.Model;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class BusList implements Serializable {


    private ArrayList<Bus> buses = new ArrayList<>();

    public BusList() {
    }

    public void add(Bus bus) {
        buses.add(bus);
    }

    public ArrayList<Bus> getArrayBuses() {
        return buses;
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

    public BusList getAvailable(Date from, Date to) {
        BusList result = new BusList();
        ArrayList<Trip> trips = DataHandler.getTrips();
        for (int i = 0; i < trips.size(); i++) {
            for (int j = 0; j < buses.size(); j++) {
                if (buses.get(j).equals(trips.get(i).getBus())) {
                    if (((from.before(trips.get(i).getTimeStart())) && (to.before(trips.get(i).getTimeStart())))
                            || ((from.after(trips.get(i).getTimeEnd())) && (to.after(trips.get(i).getTimeEnd())))) {
                        result.add(buses.get(j));
                    }
                }
            }
        }
        return result;
    }

}
