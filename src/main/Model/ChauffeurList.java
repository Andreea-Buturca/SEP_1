package main.Model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by andreea on 11/28/2016.
 */
public class ChauffeurList {

    private ArrayList<Chauffeur> chauffeurs;

    public ChauffeurList() {
        chauffeurs = new ArrayList<Chauffeur>();
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
        for (int i = 0; i < chauffeurs.size(); i++) {
            if (chauffeurs.get(i).equals(chauffeur))
                return chauffeurs.get(i);
        }
        return null;
    }

    public Chauffeur getByName(String name) {
        for (int i = 0; i < chauffeurs.size(); i++) {
            if (chauffeurs.get(i).getName().equals(name))
                return chauffeurs.get(i);
        }
        return null;
    }

    public ChauffeurList getAllByName(String name) {
        ChauffeurList result = new ChauffeurList();
        for (int i = 0; i < chauffeurs.size(); i++) {
            if (chauffeurs.get(i).getName().equals(name))
                result.add(chauffeurs.get(i));
        }
        return result;
    }

    public ChauffeurList getAllByPrefferedDistance(int prefferedDistance) {
        ChauffeurList result = new ChauffeurList();
        for (int i = 0; i < chauffeurs.size(); i++) {
            if (chauffeurs.get(i).getPreferredDistance().contains(prefferedDistance))
                result.add(chauffeurs.get(i));
        }
        return result;
    }


    public Chauffeur getChauffeurByID(int ID) {
        for (int i = 0; i < chauffeurs.size(); i++) {
            if (chauffeurs.get(i).getEmployeeID() == ID)
                return chauffeurs.get(i);
        }
        return null;
    }

    public Chauffeur getChauffeurByPreferredDistance(int preferredDistance) {
        for (int i = 0; i < chauffeurs.size(); i++) {
            if (chauffeurs.get(i).getEmployeeID() == preferredDistance)
                return chauffeurs.get(i);
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
        ChauffeurList result = new ChauffeurList();
        ArrayList<Trip> trips = DataHandler.getTrips();
        for (int i = 0; i < trips.size(); i++) {
            for (int j = 0; j < chauffeurs.size(); j++) {
                if (chauffeurs.get(j).equals(trips.get(i).getBus())) {
                    if (((from.before(trips.get(i).getTimeStart())) && (to.before(trips.get(i).getTimeStart())))
                            || ((from.after(trips.get(i).getTimeEnd())) && (to.after(trips.get(i).getTimeEnd())))) {
                        result.add(chauffeurs.get(j));
                    }
                }
            }
        }
        return result;
    }

}
