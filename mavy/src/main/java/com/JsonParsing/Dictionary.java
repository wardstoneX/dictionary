package com.JsonParsing;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    List<Entry> words;

    public Dictionary() {
        words = new ArrayList<>();
    }

    public void addEntry(Entry entry) {
        words.add(entry);
    }

    public Entry findEntry(String word) {
        for(Entry entry : words) {
            if(entry.getWord().equals(word)) {
                return entry;
            }
        }
        return null;
    }
    public boolean contains(String word) {
        boolean found = false;
        for(Entry entry : words) {
            if(entry.getWord().equals(word)) {
                found = true;
            }
        }
        return found;

    }

    public String toString(){
        String str = "";
        for(int i = 0; i<words.size()-1;i++) {
            str += words.get(i)+", ";
        }
        return str + words.get(words.size()-1);
    }

    public void setWords(List<Entry> words) {
        this.words = words;
    }

    public List<Entry> getWords() {
        return words;
    }
}
