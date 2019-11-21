package com;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<String, Surname> surnames = new HashMap<String, Surname>();

        try {
            URL url = new URL("https://www2.census.gov/topics/genealogy/1990surnames/dist.all.last");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;
            String delims = "[ ]+";

            while((line = inputReader.readLine()) != null) {
                String processed[] = line.split(delims);
                surnames.put(processed[0].toUpperCase(), new Surname(processed[0], processed[1], processed[3]));
            }


            try (ObjectOutputStream surnameFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("surname.dat")))) {
                    surnameFile.writeObject(surnames);
            }

            inputReader.close();

        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
