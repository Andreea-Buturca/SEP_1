package main.Model;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by andreea on 11/28/2016.
 */
public class ChauffeurList {
    private ArrayList<Chauffeur> list;

    public ChauffeurList()
    {
        list = new ArrayList<Chauffeur>();
    }

    public int size()
    {
        return list.size();
    }

    public void add(Chauffeur chauffeur)
    {
        list.add(chauffeur);
    }

    public void remove(int index)
    {
        list.remove(index);
    }

    public Chauffeur get(int index)
    {
        return list.get(index);
    }

       public void sortByName()
    {
        ArrayList<Chauffeur> sorted = new ArrayList<>();
        while (list.size() > 0)
        {
            int minIndex = 0;
            for (int i = 0; i < list.size(); i++)
            {
                if (list.get(i).getName().compareTo(list.get(minIndex).getName()) < 0)
                {
                    minIndex = i;
                }
            }
            sorted.add(list.get(minIndex));
            list.remove(minIndex);
        }
        list = sorted;
    }
   public String toString()
    {
        String s = "";
        for (int i = 0; i < list.size(); i++)
        {
            s += list.get(i);
            if (i < list.size() - 1)
                s += "\n";
        }
        return s;
    }

}
