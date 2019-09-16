package services.core;

import services.PrintService;
import services.WriteService;
import services.interfaces.CollectionServiceInterface;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CheckDirectoryService implements CollectionServiceInterface {
    private List<File> files = new ArrayList<>();

    @Override
    public void start() {
        System.out.println("Enter the path to directory");
        File file = new File(WriteService.getLine());
        readFiles(file);
        PrintService.printCollection(getCollection());
    }

    @Override
    public Collection getCollection() {
        return files;
    }

    public void readFiles(File directory){
        if (directory.isDirectory()){
            for (File currentFile : directory.listFiles()) {
                if(!currentFile.isFile()){
                    readFiles(currentFile);
                }
                files.add(currentFile);
            }
        }
    }
}
