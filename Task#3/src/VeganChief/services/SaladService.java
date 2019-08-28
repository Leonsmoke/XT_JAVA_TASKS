package VeganChief.services;

import VeganChief.VeganChiefApplication;
import VeganChief.models.*;

import java.util.Arrays;
import java.util.InputMismatchException;

import static VeganChief.constants.Labels.*;

/**
 * Service for interacting with objects of the Salad class.
 */
public class SaladService {
    static final double SCALE_FOR_ROUND = 1000.0;

    private static Vegetable[] allVeg = new Vegetable[]{
            new Potato(100),
            new Carrot(100),
            new Beet(100),
            new Celery(100),
            new Tomato(100)
    };

    public void changeName(Salad salad){
        System.out.println(RENAME_SALAD);
        VeganChiefApplication.scanner.nextLine();
        try {
            String newName = VeganChiefApplication.scanner.nextLine();
            salad.setName(newName);
        } catch (Exception e){
            System.err.println(e);
        }
        System.out.println("Done!");
    }

    public void showIngredientMenu(Salad salad){
        int choise=-1;
        do{
            System.out.println(ADDINGRIDIENT_MENU_LABEL);
            try{
                choise=VeganChiefApplication.scanner.nextInt();
            } catch (InputMismatchException e){
                System.err.println(ATTENTION_WRONG_NUMBER);
                VeganChiefApplication.scanner.next();
            }
            switch (choise){
                case 0:
                    break;
                case 1:
                    showAll(salad);
                    break;
                case 2:
                    sortBy(salad);
                    break;
            }
        } while(choise!=0);
    }

    public void removeByIndex(Salad salad){
        try{
            System.out.println(REMOVE_LABEL);
            int index=VeganChiefApplication.scanner.nextInt();
            salad.removeProduct(index);
        } catch (InputMismatchException e){
            System.err.println(ATTENTION_WRONG_NUMBER);
            VeganChiefApplication.scanner.next();
        }
    }

    public void printComposition(Salad salad){
        printArrayOfCompos(getComposArrayFromSalad(salad));
    }

    public void getWeight(Salad salad){
        salad.getWeight();
    }

    private void sortBy(Salad salad){
        do{
            try{
                System.out.println(SORTBY_MENU_LABEL);
                int filter=VeganChiefApplication.scanner.nextInt();
                if (filter==0) break;
                if(filter<0 || filter>4) throw new Exception();
                switch (filter){
                    case 1:
                        Arrays.sort(allVeg,Vegetable.fatsComporator);
                        break;
                    case 2:
                        Arrays.sort(allVeg,Vegetable.proteinComporator);
                        break;
                    case 3:
                        Arrays.sort(allVeg,Vegetable.carbsComporator);
                        break;
                    case 4:
                        Arrays.sort(allVeg,Vegetable.caloricComporator);
                        break;
                }
                showAll(salad);
                break;
            } catch (Exception e){
                System.err.println(ATTENTION_WRONG_NUMBER);
                VeganChiefApplication.scanner.next();
            }
        } while(true);
    }

    private void showAll(Salad salad){
        int choise=-1;
        do{
            printAllVeg();
            System.out.println("0. Back");
            try{
                choise=VeganChiefApplication.scanner.nextInt();
                if (choise==0) break;
                if(choise<1 || choise>allVeg.length) throw new Exception();
                allVeg[choise-1].addToSalad(salad,getWeight(),allVeg[choise-1].getClass().getName());
                System.out.println(ADDED_SUCCESSFULLY);
            } catch (Exception e){
                System.err.println(ATTENTION_WRONG_NUMBER);
                VeganChiefApplication.scanner.next();
            }

        } while(true);
    }

    private int getWeight(){
        int weight=0;
        do{
            try{
                System.out.println(ATTENTION_WEIGHT);
                weight=VeganChiefApplication.scanner.nextInt();
                if(weight<10 || weight>2000) throw new Exception();
                return weight;
            } catch (Exception e){
                System.err.println(ATTENTION_WRONG_NUMBER);
                VeganChiefApplication.scanner.next();
            }
        } while(true);
    }

    public void printEnergyValue(Salad salad){
        Vegetable[] composition = salad.getComposArray();
        double fats=0;
        double protein=0;
        double carbs=0;
        double caloric=0;
        if (composition!=null){
            for (Vegetable product:composition
            ) {
                double weight=product.getWeight()/100.0;
                fats+=weight*product.getFats();
                protein+=weight*product.getProtein();
                carbs+=weight*product.getCarbs();
                caloric+=weight*product.getCaloric();
            }
        }
        System.out.println("Total energy value of the salad:" +
                "\nFats: " + (Math.round(fats*SCALE_FOR_ROUND)/SCALE_FOR_ROUND) +
                "\nProtein: " + (Math.round(protein*SCALE_FOR_ROUND)/SCALE_FOR_ROUND) +
                "\nCarbs: " + (Math.round(carbs*SCALE_FOR_ROUND)/SCALE_FOR_ROUND) +
                "\nCaloric: " + (Math.round(caloric*SCALE_FOR_ROUND)/SCALE_FOR_ROUND));
    }

    private void printAllVeg(){
        for(int index=0;index<allVeg.length;index++){
            System.out.println((index+1)+". "+allVeg[index].toString());
        }
    }

    private void printArrayOfCompos(Vegetable[] composition){
        if (composition==null || composition.length==0) {
            System.out.println("Empty");

        } else {
            for (int index=0; index<composition.length;index++){
                System.out.println(index+":" +composition[index].getVegetableName() + " ("+composition[index].getWeight()+")");
            }
        }
    }

    public void searchByFilter(Salad salad){
        Vegetable[] composition;
        try{
            composition = getComposArrayFromSalad(salad);
            if (composition==null) throw new Exception(SALAD_IS_EMPTY);
        } catch (Exception e){
            System.err.println(e);
            return;
        }
        boolean flagToExit = false;
        System.out.println("Current compose:");
        do {
            printArrayOfCompos(composition);
            System.out.println(SEARCH_FILTER_MENU);
            try{
                int filter=VeganChiefApplication.scanner.nextInt();
                int filterFrom=Integer.MIN_VALUE;
                int filterTo=Integer.MAX_VALUE;
                if (filter!=9 || filter!=0){
                    System.out.print("Enter diapason\nFrom: ");
                    filterFrom = VeganChiefApplication.scanner.nextInt();
                    System.out.print("to ");
                    filterTo= VeganChiefApplication.scanner.nextInt();
                    if (filterFrom>filterTo) throw new Exception(ATTENTION_WRONG_NUMBER);
                }
                switch (filter){
                    case 0:
                        flagToExit=true;
                        break;
                    case 1:
                        composition=applyFilter(composition,"fats",filterFrom,filterTo);
                        break;
                    case 2:
                        composition=applyFilter(composition,"protein",filterFrom,filterTo);
                        break;
                    case 3:
                        composition=applyFilter(composition,"carbs",filterFrom,filterTo);
                        break;
                    case 4:
                        composition=applyFilter(composition,"caloric",filterFrom,filterTo);
                        break;
                    case 5:
                        composition=applyFilter(composition,"weight",filterFrom,filterTo);
                        break;
                    case 9:
                        composition=getComposArrayFromSalad(salad);
                        break;
                }
            } catch (Exception e){
                System.err.println(e+"\n"+ATTENTION_WRONG_NUMBER);
                VeganChiefApplication.scanner.next();
            }
        } while (!flagToExit);


    }

    private Vegetable[] applyFilter(Vegetable[] composition,String param, double from, double to){
        Vegetable[] tempComposition = null;
        switch (param){
            case "fats":
                for (Vegetable product:composition
                ) {
                    double fats = (product.getWeight()/100.0)*product.getFats();
                    if (fats>=from && fats<=to){
                        tempComposition=addToArray(tempComposition,product);
                    }
                }
                break;
            case "protein":
                for (Vegetable product:composition
                ) {
                    double protein = (product.getWeight()/100.0)*product.getProtein();
                    if (protein>=from && protein<=to){
                        tempComposition=addToArray(tempComposition,product);
                    }
                }
                break;
            case "carbs":
                for (Vegetable product:composition
                ) {
                    double carbs = (product.getWeight()/100.0)*product.getCarbs();
                    if (carbs>=from && carbs<=to){
                        tempComposition=addToArray(tempComposition,product);
                    }
                }
                break;
            case "caloric":
                for (Vegetable product:composition
                ) {
                    double caloric = (product.getWeight()/100.0)*product.getCaloric();
                    if (caloric>=from && caloric<=to){
                        tempComposition=addToArray(tempComposition,product);
                    }
                }
                break;
            case "weight":
                for (Vegetable product:composition
                ) {
                    double weight = product.getWeight();
                    if (weight>=from && weight<=to){
                        tempComposition=addToArray(tempComposition,product);
                    }
                }
                break;
        }
        return tempComposition;
    }

    private Vegetable[] addToArray(Vegetable[] array, Vegetable product){
            if (array==null){
                array = new Vegetable[1];
                array[0]=product;
                return array;
            }
            Vegetable[] temp = new Vegetable[array.length+1];
            temp[0]=product;
            System.arraycopy(array,0,temp,1,array.length);
            array=temp;
            return array;
    }

    private Vegetable[] getComposArrayFromSalad(Salad salad){
        return salad.getComposArray();
    }

}
