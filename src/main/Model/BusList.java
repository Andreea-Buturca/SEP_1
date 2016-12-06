package main.Model;

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

    public BusList(ArrayList<Bus> buses) {
        this.buses = buses;
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
        for (Bus buse : buses) {
            if (buse.getRegistrationPlate().equals(regPlate))
                return buse;
        }
        return null;
    }

    public BusList findAllByRegplate(String regPlate) {
        BusList result = new BusList();
        for (Bus buse : buses) {
            if (buse.getRegistrationPlate().equals(regPlate))
                result.add(buse);
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
        for (Bus bus : buses) {
            result += bus.toString() + "\n";
        }
        return result;
    }

    public BusList getAvailable(Date from, Date to) {
        BusList result = new BusList();
        TripList trips = DataHandler.getTrips();
        for (int i = 0; i < trips.getArrayTrip().size(); i++) {
            for (Bus buse : buses) {
                if (buse.equals(trips.getArrayTrip().get(i).getBus())) {
                    if (((from.before(trips.getArrayTrip().get(i).getDateObjStart())) && (to.before(trips.getArrayTrip().get(i).getDateObjStart())))
                            || ((from.after(trips.getArrayTrip().get(i).getDateObjEnd())) && (to.after(trips.getArrayTrip().get(i).getDateObjEnd())))) {
                        result.add(buse);
                    }
                }
            }
        }
        return result;
    }

}
