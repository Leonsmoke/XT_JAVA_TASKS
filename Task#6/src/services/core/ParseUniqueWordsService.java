package services.core;

import services.PrintService;
import services.WriteService;
import services.interfaces.CollectionServiceInterface;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseUniqueWordsService implements CollectionServiceInterface {
    private Set<String> wordSet = new HashSet<>();

    @Override
    public void start() {
        String textFromFile = load();
        parseWord(textFromFile);
        PrintService.printCollection(wordSet);
    }

    @Override
    public Collection getCollection() {
        return wordSet;
    }

    private String load(){
        System.out.println("Enter path to the file with words");
        String pathIn= WriteService.getLine();
        try(FileInputStream inFile = new FileInputStream(pathIn);){
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            System.out.println("File was read successful");
            return new String(str);
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    private void parseWord(String text){

        /*
         * To search for unique words, we will use regex.
         * The "\\w" pattern means that we will look for all numbers, letters or the underscore, excluding spaces and tabs.
         * We will also use special flags to be able to read Unicode characters, and remove case sensitivity.
         * Then we translate each unique word into lower case and add it to the HashSet
         */
        Pattern pattern = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS
                | Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            wordSet.add(matcher.group().toLowerCase());
        }
    }
}
