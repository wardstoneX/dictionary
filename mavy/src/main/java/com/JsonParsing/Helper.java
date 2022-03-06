package com.JsonParsing;

import java.io.*;

public class Helper {

    public static void terminateAndSave(Dictionary dictionary) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("dictator.json"));
            System.out.println(Json.prettyPrint(Json.toJson(dictionary)));
            writer.write(Json.prettyPrint(Json.toJson(dictionary)));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readAllLines(BufferedReader reader) throws IOException {
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }

        return content.toString();
    }
}
