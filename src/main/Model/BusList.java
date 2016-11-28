package main.Model;

import java.util.ArrayList;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class BusList {



    ArrayList<Bus> buses = new ArrayList<>();

    public BusList() {
    }

    public void addBus(Bus bus) {
        buses.add(bus);
    }

    public ArrayList<Bus> getBuses() {
        return buses;
    }

    public ArrayList<Bus> getAllAvailable(int seats){// TODO: 28-Nov-16 Finish
         return null;}

    public void removeBus(Bus bus){
        buses.remove(bus);
    }
}
