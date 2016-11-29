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

    public Bus getAtIndex(int index){
        return buses.get(index);
    }

    public void removeBus(Bus bus){
        buses.remove(bus);
    }

    public int getSize(){
        return buses.size();
    }
    public Bus findByRegplate(String regPlate){
        for (int i=0; i<buses.size();i++){
            if (buses.get(i).getRegistrationPlate().equals(regPlate))
                return buses.get(i);
        }
        return null;
    }

    public int getIndex(Bus bus){
        for (int i=0; i<buses.size();i++){
            if (buses.get(i).equals(bus))
                return i;
        }
        return -1;
    }

    public String toString(){
        String result = "";
        for (int i = 0; i<buses.size();i++){
            result+=buses.get(i).toString() + "\n";
        }
        return result;
    }

}
