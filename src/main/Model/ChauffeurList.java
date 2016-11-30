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

    public Chauffeur getChauffeurByIndex(int index)
    {
        return chauffeurList.get(index);
    }

    public Chauffeur getChauffeur(Chauffeur chauffeur){
        for (int i=0; i<chauffeurList.size();i++){
            if (chauffeurList.get(i).equals(chauffeur))
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
