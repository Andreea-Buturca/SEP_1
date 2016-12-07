package main.Model;

import java.io.*;
import java.time.LocalDate;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class DataHandler implements Serializable {


    private static TripList trips;
    private static BusList busList;
    private static ChauffeurList chauffeurList;
    private static CustomerList customerList;
    private static ReservationList reservationList;
    private static DestinationList destinationList;

    public static TripList getTrips() {
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

    public static ReservationList getReservationList() {
        return reservationList;
    }

    public static DestinationList getDestinationList() {
        return destinationList;
    }

    public static void testCreate() {
        trips = new TripList();
        busList = new BusList();
        chauffeurList = new ChauffeurList();
        customerList = new CustomerList();
        reservationList = new ReservationList();
        destinationList = new DestinationList();
    }

    public static void save() {

        String filename = "mainData.bin";
        saveFile(filename);

    }

    public static void backUp() {

        String filename = "mainDataBackUp.bin";
        saveFile(filename);

    }

    public static void load() {
        String filename = "mainData.bin";
        ObjectInputStream in = null;
        try {
            File file = new File(filename);
            FileInputStream fis = new FileInputStream(file);
            in = new ObjectInputStream(fis);
            trips = (TripList) in.readObject();
            busList = (BusList) in.readObject();
            chauffeurList = (ChauffeurList) in.readObject();
            customerList = (CustomerList) in.readObject();
            reservationList = (ReservationList) in.readObject();
            destinationList = (DestinationList) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void saveFile(String filename) {
        ObjectOutputStream out = null;
        try {
            File file = new File(filename);
            FileOutputStream fos = new FileOutputStream(file);
            out = new ObjectOutputStream(fos);
            out.writeObject(trips);
            out.writeObject(busList);
            out.writeObject(chauffeurList);
            out.writeObject(customerList);
            out.writeObject(reservationList);
            out.writeObject(destinationList);
        } catch (IOException e) {
            System.out.println("Exception: " + filename);
        } finally {
            try {
                assert out != null;
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

