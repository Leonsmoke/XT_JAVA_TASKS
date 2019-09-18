package services.core;

import services.PrintService;
import services.WriteService;
import services.interfaces.CollectionServiceInterface;
import services.interfaces.PoemServiceInterface;

import java.io.*;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Task#3
 */
public class PoemService implements PoemServiceInterface {
    List<String> stringList = new LinkedList<>();

    public void start() {
        this.load();
        stringList.sort(COMPARE_BY_LENGTH);
        PrintService.printCollection(stringList);
    }

    public void load(){
        System.out.println("Enter path to the file with poem:");
        String pathIn= WriteService.getLine();
        fillList(pathIn);
    }

    private void fillList(String path){
        try(BufferedReader bufferedReader = new BufferedReader( new FileReader( new File(path)))){
            bufferedReader.lines().forEach(s -> stringList.add(s));
            System.out.println("File was read successful");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public Collection getCollection() {
        return stringList;
    }

    public static final Comparator<String> COMPARE_BY_LENGTH = Comparator.comparingInt(String::length);
}
