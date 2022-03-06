package com.JsonParsing;

import java.io.*;
import java.util.Scanner;

public class main2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader("dictator.json"));
        Dictionary dictionary = Json.fromJson(Json.parse(Helper.readAllLines(reader)),Dictionary.class);

        while(true) {

            System.out.println("Pleae write:" +"\n"+"add for adding a new entry to the dictionary" +"\n"+"search for searching a word in the dictionary"+"\n"+"exit to close the program");
            String scanned = scanner.nextLine();
            if(scanned.equals("exit")) {

                /*
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("dictator.json"));
                    writer.write(Json.prettyPrint(Json.toJson(dictionary)));
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                 */
                Helper.terminateAndSave(dictionary);
                System.exit(0);

            } else if(scanned.equals("search")) {
                System.out.println("what do you want to know?");
                String word = scanner.nextLine();
                Entry entry = dictionary.findEntry(word);
                if(entry == null) {
                    System.out.println("The dictionary doesnt contain that word");
                } else{
                    System.out.println(entry.toString());
                }


            } else if(scanned.equals("add")) {
                System.out.println("what word do you want to add?");
                String word = scanner.nextLine();
                if(dictionary.contains(word)) {
                    System.out.println("the dictionary already contains the word. Try again! Loser");
                } else {
                    System.out.println("Whats the definition boi++");
                    String definition = scanner.nextLine();
                    System.out.println("Give me an example boii");
                    String example = scanner.nextLine();
                    dictionary.addEntry(new Entry(word,definition,example));
                }
                System.out.println("Do you want to exit the programm? yes/no");
                String ex = scanner.nextLine();
                if(ex.equals("yes")) {

                    /*
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("dictator.json"));
                        writer.write(Json.prettyPrint(Json.toJson(dictionary)));
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                     */
                    Helper.terminateAndSave(dictionary);
                    System.exit(0);
                }
            }
            System.out.println(scanned);
        }
    }
}
