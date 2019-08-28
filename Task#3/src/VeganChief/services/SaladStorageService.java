package VeganChief.services;

import VeganChief.models.Salad;

/**
 * A service that allows you to conveniently store data about created salads.
 * Add new and modify existing ones.
 */
public class SaladStorageService {

    private Salad[] salads;

    public int create(){
        if (salads==null){
            salads=new Salad[1];
            salads[0]= new Salad();
            return 0;
        }
        Salad[] tempSalads = new Salad[salads.length+1];
        System.arraycopy(salads,0,tempSalads,0,salads.length);
        tempSalads[salads.length]= new Salad();
        salads=tempSalads;
        return salads.length-1;
    }

    public Salad get(int index){
        return salads[index];
    }

    public int getAllSalads(){
        try{
            if (salads==null) throw new Exception("You dont have a salad");
            for(int index=0;index<salads.length;index++){
                System.out.println((index+1) + ". " + salads[index].getName());
            }
        } catch(Exception e){
            System.err.println(e);
            return 0;
        }
        return salads.length;
    }
}
