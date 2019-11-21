package com;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Lookup {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<String, Surname> surname = null;
        boolean quit = false;

        try (ObjectInputStream surnameFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("surname.dat")))) {

                surname = (HashMap<String, Surname>) surnameFile.readObject();

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }

        while(!quit) {
            System.out.print("Enter a surname (or quit to end): ");
            String searchName = input.nextLine();

            if (searchName.equals("quit")){
                quit = true;
            } else if (surname.containsKey(searchName.toUpperCase())){
                System.out.println(surname.get(searchName.toUpperCase()));
            } else {
                System.out.println("Surname: " + searchName + " not found");
            }
        }
    }
}
