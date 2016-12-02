package main.Model;

import java.util.ArrayList;

/**
 * Created by MartinNtb on 30-Nov-16.
 */
public class DestinationList {

    private ArrayList<Destination> destinations = new ArrayList<>();

    public DestinationList() {
    }

    public void add(Destination destination) {
        destinations.add(destination);
    }

    public ArrayList<Destination> getArrayDestination() {
        return destinations;
    }

    public Destination getAtIndex(int index) {
        return destinations.get(index);
    }

    public void removeDestination(Destination destination) {
        destinations.remove(destination);
    }

    public Destination findByName(String name) {
        for (Destination destination : destinations) {
            if (destination.getPlace().equals(name)) return destination;
        }
        return null;
    }


}
