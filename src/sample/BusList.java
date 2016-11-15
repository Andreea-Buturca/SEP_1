package sample;

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
}
