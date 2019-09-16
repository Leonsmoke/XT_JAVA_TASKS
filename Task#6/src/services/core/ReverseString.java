package services.core;

import services.WriteService;
import services.interfaces.CollectionServiceInterface;

import java.io.*;
import java.util.*;

public class ReverseString implements CollectionServiceInterface {

    Deque<String> stringList = new ArrayDeque<>();

    public void start(){
        this.load();
    }

    private void load(){
        System.out.println("Enter path to the file:");
        String pathIn= WriteService.getLine();
        try(BufferedReader br = new BufferedReader( new FileReader( new File(pathIn)))){
            br.lines().forEach(s -> stringList.addFirst(s));
            System.out.println("File was read successful");
        } catch (IOException e){
            e.printStackTrace();
        }
        WriteService.write(stringList, pathIn);
    }

    public Deque<String> getCollection(){
        Deque<String> stringDeque = new ArrayDeque<>();
        stringDeque.addAll(stringList);
        return stringDeque;
    }
}
