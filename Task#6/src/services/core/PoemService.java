package services.core;

import services.PrintService;
import services.WriteService;
import services.interfaces.CollectionServiceInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class PoemService implements CollectionServiceInterface {
    List<String> stringList = new LinkedList<>();

    @Override
    public void start() {
        this.load();
        stringList.sort(COMPARE_BY_LENGTH);
        PrintService.printCollection(stringList);
    }

    private void load(){
        System.out.println("Enter path to the file with poem:");
        String pathIn= WriteService.getLine();
        try(BufferedReader bufferedReader = new BufferedReader( new FileReader( new File(pathIn)))){
            bufferedReader.lines().forEach(s -> stringList.add(s));
            System.out.println("File was read successful");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public Collection getCollection() {
        return stringList;
    }

    public static final Comparator<String> COMPARE_BY_LENGTH = Comparator.comparingInt(String::length);
}
