package main.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by andreea on 11/28/2016.
 */
public class ChauffeurList implements Serializable {

    private ArrayList<Chauffeur> chauffeurs;

    public ChauffeurList() {
        chauffeurs = new ArrayList<>();
    }

    public int getSize() {
        return chauffeurs.size();
    }

    public void add(Chauffeur chauffeur) {
        chauffeurs.add(chauffeur);
    }

    public void removeChauffeur(int index) {
        chauffeurs.remove(index);
    }

    public void removeChauffeur(Chauffeur chauffeur) {
        for (int i = 0; i < chauffeurs.size(); i++) {
            if (chauffeurs.get(i).equals(chauffeur))
                chauffeurs.remove(chauffeur);
        }
    }

    public Chauffeur getChauffeurByIndex(int index) {
        return chauffeurs.get(index);
    }

    public ArrayList<Chauffeur> getArrayChauffeur() {
        return chauffeurs;
    }

    public Chauffeur getChauffeur(Chauffeur chauffeur) {
        for (Chauffeur chauffeur1 : chauffeurs) {
            if (chauffeur1.equals(chauffeur))
                return chauffeur1;
        }
        return null;
    }

    public Chauffeur getByName(String name) {
        for (Chauffeur chauffeur : chauffeurs) {
            if (chauffeur.getName().equals(name))
                return chauffeur;
        }
        return null;
    }

    public ChauffeurList getAllByName(String name) {
        ChauffeurList result = new ChauffeurList();
        for (Chauffeur chauffeur : chauffeurs) {
            if (chauffeur.getName().equals(name))
                result.add(chauffeur);
        }
        return result;
    }

    public ChauffeurList getAllByPrefferedDistance(int prefferedDistance) {
        ChauffeurList result = new ChauffeurList();
        for (int i = 0; i < chauffeurs.size(); i++) {
            if ((chauffeurs.get(i).getPreferredDistance() != null)&&!(chauffeurs.get(i).getPreferredDistance().isEmpty()))
                if (chauffeurs.get(i).getPreferredDistance().get(0) > prefferedDistance)
                    result.add(chauffeurs.get(i));
        }
        return result;
    }

    public boolean checkIfContains(Chauffeur chauffeur){
        return chauffeurs.contains(chauffeur);
    }

    public ChauffeurList getAllByPrefferedBus(String busType) {
        ChauffeurList result = new ChauffeurList();
        for (int i = 0; i < chauffeurs.size(); i++) {
            ArrayList<String> prefferedBuses = chauffeurs.get(i).getArrayBusTypes();
            for (int j=0;j<prefferedBuses.size();j++){
                if (busType.equals(prefferedBuses.get(j))){
                    if (!result.checkIfContains(chauffeurs.get(i)))
                        result.add(chauffeurs.get(i));
                }
            }
        }

        return result;
    }

    public ChauffeurList getAllVicars(){
        ChauffeurList result = new ChauffeurList();
        for (int i = 0; i < chauffeurs.size(); i++) {
            if (chauffeurs.get(i).isVikar()) {
                result.add(chauffeurs.get(i));
            }
        }
        return result;
    }

    public void removeAllVicars(){
        for (int i = 0; i < chauffeurs.size(); i++) {
            if (chauffeurs.get(i).isVikar()) {
                chauffeurs.remove(chauffeurs.get(i));
            }
        }
    }


    public Chauffeur getChauffeurByID(int ID) {
        for (Chauffeur chauffeur : chauffeurs) {
            if (chauffeur.getEmployeeID() == ID)
                return chauffeur;
        }
        return null;
    }

    public Chauffeur getChauffeurByPreferredDistance(int preferredDistance) {
        for (Chauffeur chauffeur : chauffeurs) {
            if (chauffeur.getEmployeeID() == preferredDistance)
                return chauffeur;
        }
        return null;
    }


    public void sortByChauffeurName() {
        ArrayList<Chauffeur> sorted = new ArrayList<>();
        while (chauffeurs.size() > 0) {
            int minIndex = 0;
            for (int i = 0; i < chauffeurs.size(); i++) {
                if (chauffeurs.get(i).getName().compareTo(chauffeurs.get(minIndex).getName()) < 0) {
                    minIndex = i;
                }
            }
            sorted.add(chauffeurs.get(minIndex));
            chauffeurs.remove(minIndex);
        }
        chauffeurs = sorted;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < chauffeurs.size(); i++) {
            s += chauffeurs.get(i);
            if (i < chauffeurs.size() - 1)
                s += "\n";
        }
        return s;
    }

    public ChauffeurList getAvailable(Date from, Date to) {
        ArrayList<Chauffeur> inTrips = new ArrayList<>();
        ChauffeurList result = new ChauffeurList();
        TripList trips = DataHandler.getTrips();
        for (int i = 0; i < trips.getArrayTrip().size(); i++) {
            for (Chauffeur chauffeur : chauffeurs) {
                if (chauffeur.equals(trips.getArrayTrip().get(i).getChauffeur())) {
                    if (!inTrips.contains(chauffeur))
                        inTrips.add(chauffeur);
                    if (((from.before(trips.getArrayTrip().get(i).getDateObjStart())) && (to.before(trips.getArrayTrip().get(i).getDateObjStart())))
                            || ((from.after(trips.getArrayTrip().get(i).getDateObjEnd())) && (to.after(trips.getArrayTrip().get(i).getDateObjEnd())))) {
                        result.add(chauffeur);
                    }
                }
            }
        }
        for (int i=0;i<chauffeurs.size();i++){
            if (!inTrips.contains(chauffeurs.get(i)))
                result.add(chauffeurs.get(i));
        }
        return result;
    }

    public ChauffeurList copy () {
        ChauffeurList chauffeurList = new ChauffeurList();
        for (Chauffeur chauffeur: chauffeurs) {
            chauffeurList.add(chauffeur);
        }
        return chauffeurList;
    }

}
