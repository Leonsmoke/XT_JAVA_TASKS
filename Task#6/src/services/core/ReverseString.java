package services.core;

import services.WriteService;
import services.interfaces.CollectionServiceInterface;
import services.interfaces.ReversStringInterface;

import java.io.*;
import java.util.*;

/**
 * Task#1
 */
public class ReverseString implements ReversStringInterface {

    Deque<String> strings = new ArrayDeque<>();

    public void start(){
        this.load();
    }

    public void load(){
        System.out.println("Enter path to the file:");
        String pathIn= WriteService.getLine();
        WriteService.write(strings, pathIn);
        fillStack(pathIn);
    }

    private void fillStack(String path){
        try(BufferedReader br = new BufferedReader( new FileReader( new File(path)))){
            br.lines().forEach(s -> strings.addFirst(s));
            System.out.println("File was read successful");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Deque<String> getCollection(){
        Deque<String> stringDeque = new ArrayDeque<>();
        stringDeque.addAll(strings);
        return stringDeque;
    }
}
