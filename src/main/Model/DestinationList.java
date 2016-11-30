package main.Model;

import java.util.ArrayList;

/**
 * Created by MartinNtb on 30-Nov-16.
 */
public class DestinationList {
    private ArrayList<Destination> list;

    public DestinationList(ArrayList<Destination> list) {
        this.list = list;
    }


    public ArrayList<Destination> getDestinationList() {
        return list;
    }

    public Destination getDestination() {
        return list.get(0);
        // TODO: 30-Nov-16 just for test
    }




}
