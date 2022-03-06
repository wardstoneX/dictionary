package com.JsonParsing;

public class Entry {
    private String word;
    private String definition;
    private String example;

    public Entry() {

    }

    public Entry(String word, String definition, String example) {
        this.word = word;
        this.definition = definition;
        this.example = example;

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getDefinition() {
        return definition;
    }

    public String getExample() {
        return example;
    }

    public String toString() {
        return word + " :" + "\n" + definition + "\n" + example;
    }
}
