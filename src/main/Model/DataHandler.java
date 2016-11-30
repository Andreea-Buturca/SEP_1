package main.Model;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class DataHandler {


    private static ArrayList<Trip> trips;
    private static BusList busList;
    private static ChauffeurList chauffeurList;
    private static CustomerList customerList;
    private static DestinationList destinationList;
   // public static


    //todo bin handling saving loading, .....

    public static void print() {
        System.out.println("test");
    }


    public static ArrayList<Trip> getTrips() {
        return trips;
    }

    public static BusList getBusList() {
        return busList;
    }

    public static ChauffeurList getChauffeurList() {
        return chauffeurList;
    }

    public static CustomerList getCustomerList() {
        return customerList;
    }

    public static DestinationList getDestinationList() {
        return destinationList;
    }

    public static void testCreate() {
        trips = new ArrayList<>();
        busList = new BusList();
        chauffeurList = new ChauffeurList();
        customerList = new CustomerList();
        destinationList = new DestinationList();
    }

    public static void testData() {

        //todo create test date here
        //new trip in to array, new bus in to bus list, and so....
        //than data are accessible from everywhere
        //just call example DataHandler.getChauffeurList().methods in list....
    }

    public static void save() {

        String filename = "mainData.bin";

        // TODO: 30-Nov-16 first time needed to construct all data 

        ObjectOutputStream out = null;
        try
        {
            File file = new File(filename);
            FileOutputStream fos = new FileOutputStream(file);
            out = new ObjectOutputStream(fos);
            out.writeObject(trips);
            out.writeObject(busList);
            out.writeObject(chauffeurList);
            out.writeObject(customerList);
            out.writeObject(destinationList);
        }
        catch (IOException e)
        {
            System.out.println("Exception: " + filename);
        }
        finally
        {
            try
            {
                out.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }


    public static void load() {
        String filename = "test.bin";
        ObjectInputStream in = null;
        try
        {
            File file = new File(filename);
            FileInputStream fis = new FileInputStream(file);
            in = new ObjectInputStream(fis);
            trips = (ArrayList<Trip>) in.readObject();
            busList = (BusList) in.readObject();
            chauffeurList = (ChauffeurList) in.readObject();
            customerList = (CustomerList) in.readObject();
            destinationList = (DestinationList) in.readObject();
        }

        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (in != null) {
                    in.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

}

