package main.Controller;
import main.Model.Chauffeur;
import main.Model.ChauffeurList;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * Created by andreea on 11/29/2016.
 */
public class ChauffeurModelManager {
    private ChauffeurList list;
    private ChauffeurFile file;
    private static final String FILENAME = "ChauffeurList.txt";

    public ChauffeurModelManager()
    {
        try
        {
            file = new ChauffeurFile(FILENAME);

            list = file.readTextFile();
            list.sortByName();
        }
        catch (ParseException | FileNotFoundException e)
        {
            list = new ChauffeurList();
        }
    }

    public int getSize()
    {
        return list.size();
    }

    public Chauffeur getChauffeur(int index)
    {
        return list.get(index);
    }

    public Chauffeur removeChauffeur(int index)
    {
        Chauffeur c = getChauffeur(index);
        list.remove(index);
        return c;
    }

    public void addChauffeur(Chauffeur chauffeur)
    {
        list.add(chauffeur);
        list.sortByName();
    }

    public String toString()
    {
        return list.toString();
    }

}
