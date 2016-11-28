package com.company;

import java.util.ArrayList;

/**
 * Created by Marek on 24-Nov-16.
 */
public class ChauffeurList {

    private ArrayList<Chauffeur> list;

    public ChauffeurList() {
        this.list = new ArrayList<Chauffeur>();
    }

    public void addToList(Chauffeur chauffeur){
        list.add(chauffeur);
    }

    public ArrayList<Chauffeur> getList() {
        return list;
    }
}
