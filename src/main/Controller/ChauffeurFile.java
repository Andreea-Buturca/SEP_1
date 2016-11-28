package main.Controller;
import main.Model.Chauffeur;
import main.Model.ChauffeurList;
import main.Model.MyDate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Scanner;
/**
 * Created by andreea on 11/28/2016.
 */
public class ChauffeurFile {
        private File file;

        public ChauffeurFile(String filename)
        {
            setFile(filename);
        }

        public void setFile(String filename)
        {
            file = new File(filename);
        }

        public File getFile()
        {
            return file;
        }

        public ChauffeurList readTextFile() throws FileNotFoundException, ParseException
        {
            Scanner in = null;
            try
            {
                in = new Scanner(file);

                ChauffeurList chauffeurList = new ChauffeurList();
                int lineNumber = 0;
                while (in.hasNext())
                {
                    String line = in.nextLine();
                    String[] lineToken = line.split(", ");
                    lineNumber++;
                    if (lineToken.length < 9)
                    {
                        throw new ParseException("Line from file in wrong format: "
                                + line, lineNumber);
                    }
                    String name = lineToken[0].trim();
                    String address = lineToken[1].trim();
                    String email = lineToken[2].trim();
                    String phone = lineToken[3].trim();
                    int employeeID = Integer.parseInt(lineToken[4].trim());
                    int preferredDistance = Integer.parseInt(lineToken[5].trim());
                    String preferredTripType = lineToken[6].trim();
                    int workedHours = Integer.parseInt(lineToken[7].trim());
                    boolean isVikar = Boolean.parseBoolean(lineToken[8].trim());

                   Chauffeur chauffeur = new Chauffeur(name, address, email, phone, employeeID, preferredDistance, preferredTripType, workedHours, isVikar);

                    chauffeurList.add(chauffeur);
                }
                return chauffeurList;
            }
            finally
            {
                in.close();
            }
        }

        public void writeTextFile(ChauffeurList chauffeurs)
                throws FileNotFoundException
        {
            PrintWriter out = null;
            try
            {
                out = new PrintWriter(file);
                for (int i = 0; i < chauffeurs.size(); i++)
                {
                    out.println(chauffeurs.get(i).getName() + ", "
                            + chauffeurs.get(i).getAddress() + ", "
                            + chauffeurs.get(i).getEmail() + ", "
                            + chauffeurs.get(i).getPhone()+ ", "
                            + chauffeurs.get(i).getEmployeeID()+ ", "
                            + chauffeurs.get(i).getPreferredDistance()+ ", "
                            + chauffeurs.get(i).getPreferredTripType()+ ", "
                            + chauffeurs.get(i).getWorkedHours());
                }
                out.flush();
            }
            finally
            {
                out.close();
            }
        }
        public void writeTextFile(ChauffeurList chauffeurs, String filename)
                throws FileNotFoundException
        {
            setFile(filename);
            writeTextFile(chauffeurs);
        }
        public void writeBinaryFile(ChauffeurFile list) throws IOException
        {
            ObjectOutputStream out = null;
            try
            {
                FileOutputStream fos = new FileOutputStream(file);
                out = new ObjectOutputStream(fos);
                out.writeObject(list);
            }
            finally
            {
                out.close();
            }
        }

        public void writeBinaryFile(ChauffeurFile list, String filename)
                throws IOException
        {
            setFile(filename);
            writeBinaryFile(list);
        }

        public ChauffeurFile readBinaryFile() throws IOException, ClassNotFoundException
        {
            ObjectInputStream in = null;
            try
            {
                FileInputStream fileInStream = new FileInputStream(file);
                in = new ObjectInputStream(fileInStream);

                ChauffeurFile list = (ChauffeurFile) in.readObject();
                return list;
            }
            finally
            {
                in.close();
            }
        }

        public ChauffeurFile readBinaryFile(String filename) throws IOException,
                ClassNotFoundException
        {
            setFile(filename);
            return readBinaryFile();
        }
    }
