package services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

public class WriteService {

    public static Scanner scanner = new Scanner(System.in);

    public static String getLine(){
        String temp = "";
        try {
            scanner.nextLine();
            temp= scanner.nextLine();
        } catch (Exception e){
            e.printStackTrace();
        }
        return temp;
    }

    public static int getInt(){
        int integer = 0;
        try {
            integer= scanner.nextInt();
        } catch (Exception e){
            e.printStackTrace();
        }
        return integer;
    }

    public static void write(Collection<String> collection, String path){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("out.txt")))){
            for (String line: collection
            ) {
                bufferedWriter.write(line+"\n");
            }
            System.out.println("Strings were written to a file out.txt");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
