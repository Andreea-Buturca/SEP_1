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

    public Chauffeur getByName(String name) {
        for (Chauffeur chauffeur : chauffeurs) {
            if (chauffeur.getName().equals(name))
                return chauffeur;
        }
        return null;
    }

    private boolean contains(Chauffeur chauffeur) {
        return chauffeurs.contains(chauffeur);
    }

    public ChauffeurList getAllByPrefferedDistance(int prefferedDistance) {
        ChauffeurList result = new ChauffeurList();
        for (Chauffeur chauffeur : chauffeurs) {
            if (!chauffeur.isVikar()) {
                if ((chauffeur.getPreferredDistance() != null) && !(chauffeur.getPreferredDistance().isEmpty())) {
                    for (int j = 0; j < chauffeur.getPreferredDistance().size(); j++) {
                        if (chauffeur.getPreferredDistance().get(j) > prefferedDistance) {
                            if (!result.contains(chauffeur))
                                result.add(chauffeur);
                        }
                    }
                } else if (chauffeur.getPreferredDistance().isEmpty()) {
                    result.add(chauffeur);
                }
            }
        }
        return result;
    }

    private boolean checkIfContains(Chauffeur chauffeur) {
        return chauffeurs.contains(chauffeur);
    }

    public ChauffeurList getAllByPrefferedBus(String busType) {
        ChauffeurList result = new ChauffeurList();
        for (Chauffeur chauffeur : chauffeurs) {
            ArrayList<String> prefferedBuses = chauffeur.getArrayBusTypes();
            if (!chauffeur.isVikar()) {
                if (!prefferedBuses.isEmpty()) {
                    for (String prefferedBuse : prefferedBuses) {
                        if (busType.equals(prefferedBuse)) {
                            if (!result.checkIfContains(chauffeur))
                                result.add(chauffeur);
                        }
                    }
                } else
                    result.add(chauffeur);
            }
        }

        return result;
    }

    public ChauffeurList getAllVicars() {
        ChauffeurList result = new ChauffeurList();
        for (Chauffeur chauffeur : chauffeurs) {
            if (chauffeur.isVikar()) {
                result.add(chauffeur);
            }
        }
        return result;
    }

    public void removeAllVicars() {
        for (int i = 0; i < chauffeurs.size(); i++) {
            if (chauffeurs.get(i).isVikar()) {
                chauffeurs.remove(chauffeurs.get(i));
            }
        }
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
        for (Chauffeur chauffeur : chauffeurs) {
            if (!inTrips.contains(chauffeur))
                result.add(chauffeur);
        }
        return result;
    }

    public ChauffeurList copy() {
        ChauffeurList chauffeurList = new ChauffeurList();
        for (Chauffeur chauffeur : chauffeurs) {
            chauffeurList.add(chauffeur);
        }
        return chauffeurList;
    }

}
