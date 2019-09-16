package services;

import java.util.Collection;

public class PrintService {

    /*
     * use a lambda expression to display all the elements of the transferred collection
     */
    public static void printCollection(Collection<?> collection){
        collection.forEach(e -> System.out.println(e));
    }

}
