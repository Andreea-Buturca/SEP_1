package main.Model;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by andreea on 11/28/2016.
 */
public class ChauffeurList {

    private ArrayList<Chauffeur> chauffeurList;

    public ChauffeurList()
    {
        chauffeurList = new ArrayList<Chauffeur>();
    }

    public int getSize()
    {
        return chauffeurList.size();
    }

    public void add(Chauffeur chauffeur)
    {
        chauffeurList.add(chauffeur);
    }

    public void removeChauffeur(int index)
    {
        chauffeurList.remove(index);
    }

    public void removeChauffeur(Chauffeur chauffeur) {
        for (int i = 0; i < chauffeurList.size(); i++) {
            if (chauffeurList.get(i).equals(chauffeur))
                chauffeurList.remove(chauffeur);
        }
    }

    public Chauffeur getChauffeurByIndex(int index)
    {
        return chauffeurList.get(index);
    }

    public ArrayList<Chauffeur> getChauffeurList() {
        return chauffeurList;
    }

    public Chauffeur getChauffeur(Chauffeur chauffeur){
        for (int i=0; i<chauffeurList.size();i++){
            if (chauffeurList.get(i).equals(chauffeur))
                return chauffeurList.get(i);
        }
        return null;
    }
    public Chauffeur getChauffeurByName(String name){
        for (int i=0; i<chauffeurList.size();i++){
            if (chauffeurList.get(i).getName().equals(name))
                return chauffeurList.get(i);
        }
        return null;
    }
    public Chauffeur getChauffeurByID(int ID){
        for (int i=0; i<chauffeurList.size();i++){
            if (chauffeurList.get(i).getEmployeeID()==ID)
                return chauffeurList.get(i);
        }
        return null;
    }
    public Chauffeur getChauffeurByPreferredDistance(int preferredDistance){
        for (int i=0; i<chauffeurList.size();i++){
            if (chauffeurList.get(i).getEmployeeID()== preferredDistance)
                return chauffeurList.get(i);
        }
        return null;
    }
    public Chauffeur getChauffeurByPreferredTourType(String preferredTourType){
        for (int i=0; i<chauffeurList.size();i++){
            if (chauffeurList.get(i).getPreferredTourType().equals(preferredTourType))
                return chauffeurList.get(i);
        }
        return null;
    }
    public Chauffeur getChauffeurByWorkedHours(int workedHours){
        for (int i=0; i<chauffeurList.size();i++){
            if (chauffeurList.get(i).getPreferredWorkedHours() == workedHours)
                return chauffeurList.get(i);
        }
        return null;
    }
    public Chauffeur getChauffeurIfIsVikar(boolean isVikar){
        for (int i=0; i<chauffeurList.size();i++){
            if (chauffeurList.get(i).isVikar() == isVikar) // TODO: 11/30/2016  leave it or delete it
                return chauffeurList.get(i);
        }
        return null;
    }
       public void sortByChauffeurName()
    {
        ArrayList<Chauffeur> sorted = new ArrayList<>();
        while (chauffeurList.size() > 0)
        {
            int minIndex = 0;
            for (int i = 0; i < chauffeurList.size(); i++)
            {
                if (chauffeurList.get(i).getName().compareTo(chauffeurList.get(minIndex).getName()) < 0)
                {
                    minIndex = i;
                }
            }
            sorted.add(chauffeurList.get(minIndex));
            chauffeurList.remove(minIndex);
        }
        chauffeurList = sorted;
    }
   public String toString()
    {
        String s = "";
        for (int i = 0; i < chauffeurList.size(); i++)
        {
            s += chauffeurList.get(i);
            if (i < chauffeurList.size() - 1)
                s += "\n";
        }
        return s;
    }

}
