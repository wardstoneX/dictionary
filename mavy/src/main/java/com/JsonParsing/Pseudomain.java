package com.JsonParsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Paths;

public class Pseudomain {
    public static void main(String[] args) throws JsonProcessingException {
        Dictionary dictionary = new Dictionary();
        dictionary.addEntry(new Entry("fuck","suck","heck"));
        dictionary.addEntry(new Entry("yolk","egg","cheese"));
        dictionary.addEntry(new Entry("price","cringe","estranged"));
        ObjectMapper om = new ObjectMapper();

        String str1 = Json.prettyPrint(Json.toJson(dictionary));
       // System.out.println(str1);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("dictator.json"));
            writer.write(Json.prettyPrint(Json.toJson(dictionary)));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
