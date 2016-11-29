package main.Controller;

import main.Model.BusList;
import main.Model.Bus;
import main.Model.ChauffeurList;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by Marek on 29-Nov-16.
 */
public class BusFile {
    private File file;

    public BusFile(String filename)
    {
        setFile(filename);
    }

    public void setFile(String filename) {
        this.file = new File(filename);
    }

    public File getFile() {
        return file;
    }

    public BusList readFile() throws ParseException, FileNotFoundException {
        Scanner in = null;
        try
        {
            in = new Scanner(file);

            BusList busList = new BusList();
            int lineNumber = 0;
            while (in.hasNext())
            {
                String line = in.nextLine();
                String[] lineToken = line.split(", ");
                lineNumber++;
                if (lineToken.length < 2)
                {
                    throw new ParseException("Line from file in wrong format: "
                            + line, lineNumber);
                }
                String regPlate = lineToken[0].trim();
                int numberOfSeats = Integer.parseInt(lineToken[1].trim());

                Bus bus = new Bus(regPlate,numberOfSeats);
               busList.addBus(bus);
            }
            return busList;
        }
        finally
        {
            in.close();
        }
    }
    public void writeTextFile(BusList busList)
            throws FileNotFoundException
    {
        PrintWriter out = null;
        try
        {
            out = new PrintWriter(file);
            for (int i = 0; i < busList.getSize(); i++)
            {
                out.println(busList.getAtIndex(i).getRegistrationPlate() + ", "
                        + busList.getAtIndex(i).getSeatPlaces());
            }
            out.flush();
        }
        finally
        {
            out.close();
        }
    }
}


