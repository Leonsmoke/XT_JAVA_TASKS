package Task_B.Services;

import Task_B.Models.Employee;
import Task_B.Models.Engineer;
import Task_B.Models.Janitor;
import Task_B.Models.Manager;

public class EmployeeFactory {

    static final int JANITOR_MAX_SALARY = 15000;
    static final int ENGINEER_MAX_SALARY = 25000;
    static final int MANAGER_MAX_SALARY = 35000;

    public static Employee createEmployee(int index){
        /*
         * A new employee object is randomly created
         */
        switch (index){
            case 0:
                return new Janitor((Math.random()*JANITOR_MAX_SALARY), randomFirstName()+" "+randomLastName());
            case 1:
                return new Engineer((Math.random()*ENGINEER_MAX_SALARY),randomFirstName()+" "+randomLastName());
            case 2:
                return new Manager((Math.random()*MANAGER_MAX_SALARY),randomFirstName()+" "+randomLastName());
                default:
                    return new Janitor((Math.random()*JANITOR_MAX_SALARY),"Jan Itor");
        }
    }

    private static String randomFirstName(){
        /*
         * Get a random first name
         */
        switch ((int)(Math.random()*6)){
            case 0:
                return "John";
            case 1:
                return "Bradly";
            case 2:
                return "Mike";
            case 3:
                return "Maria";
            case 4:
                return "Nick";
            case 5:
                return "Max";
                default:
                    return "Jan";
        }
    }

    private static String randomLastName(){
        /*
         * Get a random last name
         */
        switch ((int)(Math.random()*6)){
            case 0:
                return "Copper";
            case 1:
                return "Zacklawski";
            case 2:
                return "Bondar";
            case 3:
                return "Zeus";
            case 4:
                return "Kabina";
            case 5:
                return "Hill";
            default:
                return "Itor";
        }
    }

}
