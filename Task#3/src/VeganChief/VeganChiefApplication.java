package VeganChief;

import VeganChief.models.Salad;
import VeganChief.services.SaladService;
import VeganChief.services.SaladStorageService;

import java.util.InputMismatchException;
import java.util.Scanner;
import static VeganChief.constants.Labels.*;

/*
 * Melnikov Dmitrii
 * 3rd Practise Task 3
 */
public class VeganChiefApplication {
    private SaladStorageService storage = new SaladStorageService();   // Service for storage all salads
    private SaladService saladService = new SaladService();            // Salads interaction service
    public static Scanner scanner = new Scanner(System.in);            // Just scanner

    public static void main(String[] args) {
        VeganChiefApplication vca = new VeganChiefApplication();
        vca.run();
    }

    public void run(){
        System.out.println(GREETINGS);
        do{
            int choise=-1;
            System.out.println(MAINMENU_LABEL);
            try{
                choise=scanner.nextInt();
            } catch (InputMismatchException e){
                System.err.println(ATTENTION_WRONG_NUMBER);
                scanner.next();
            }
            switch (choise){
                case 0:
                    System.exit(1);
                case 1:
                    createSaladMenu();
                    break;
                case 2:
                    selectSalad();
                    break;
            }
        } while(true);
    }

    private void createSaladMenu(){
        System.out.println(CREATEMENU_LABEL);
        changeSaladMenu(storage.create());
    }

    private void selectSalad(){
        do{
            int choise=-1;
            int max=storage.getAllSalads();
            System.out.println("0. Back");
            try{
                choise=scanner.nextInt();
            } catch (InputMismatchException e){
                System.err.println(ATTENTION_WRONG_NUMBER);
                scanner.next();
            }
            if (choise>=0&&choise<=max){
                if (choise==0) break;
                changeSaladMenu(choise-1);
            }
        } while(true);
    }

    private void changeSaladMenu(int indexSalad){
        Salad currentSalad = storage.get(indexSalad);
        int choise=-1;
        do{
            System.out.println(CHANGEMENU_LABEL);
            try{
                choise=scanner.nextInt();
            } catch (InputMismatchException e){
                System.err.println(ATTENTION_WRONG_NUMBER);
                scanner.next();
            }
            switch (choise){
                case 0:
                    break;
                case 1:
                    saladService.changeName(currentSalad);
                    break;
                case 2:
                    saladService.showIngredientMenu(currentSalad);
                    break;
                case 3:
                    saladService.removeByIndex(currentSalad);
                    break;
                case 4:
                    saladService.printComposition(currentSalad);
                    break;
                case 5:
                    saladService.printEnergyValue(currentSalad);
                    break;
                case 6:
                    saladService.getWeight(currentSalad);
                    break;
                case 7:
                    saladService.searchByFilter(currentSalad);
                    break;

            }
        } while(choise!=0);
    }
}
