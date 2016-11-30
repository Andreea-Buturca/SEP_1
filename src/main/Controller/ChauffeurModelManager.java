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
            list.sortByChauffeurName();
        }
        catch (ParseException | FileNotFoundException e)
        {
            list = new ChauffeurList();
        }
    }

    public int getSize()
    {
        return list.getSize();
    }

    public Chauffeur getChauffeur(int index)
    {
        return list.getChauffeurByIndex(index);
    }

    public Chauffeur removeChauffeur(int index)
    {
        Chauffeur c = getChauffeur(index);
        list.removeChauffeur(index);
        return c;
    }

    public void addChauffeur(Chauffeur chauffeur)
    {
        list.add(chauffeur);
        list.sortByChauffeurName();
    }

    public String toString()
    {
        return list.toString();
    }

}
