package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
//
//            System.out.println(processed[0]);
//            System.out.println(processed[1]);
//            System.out.println(processed[2]);
//            System.out.println(processed[3]);


            while((line = inputReader.readLine()) != null) {
                String processed[] = line.split(delims);
                surnames.put(processed[0].toUpperCase(), new Surname(processed[0], processed[1], processed[3]));
            }

            for(String key: surnames.keySet()) {
                System.out.println(key + " -> " + surnames.get(key));
            }

            inputReader.close();

        } catch(MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
