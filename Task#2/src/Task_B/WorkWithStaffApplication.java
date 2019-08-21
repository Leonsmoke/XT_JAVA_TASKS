package Task_B;

import Task_B.Models.Employee;
import Task_B.Services.EmployeeFactory;
import Task_B.Services.SeparationService;

/*
 * Melnikov Dmitrii
 * Practice 2 (Class and objects), Task_B
 */
public class WorkWithStaffApplication {

    public static final int RANDOM_GENERATION_ARRAY_SIZE = 10;             //Number of employees generated

    public static void main(String[] args) {
        WorkWithStaffApplication app = new WorkWithStaffApplication();

        Employee[] employees = app.generateArray();
        Employee[][] employeesByGroup= SeparationService.separateArray(employees);
        app.printAllElements(employeesByGroup);
    }

    private Employee[] generateArray(){
        Employee[] employeesArray = new Employee[RANDOM_GENERATION_ARRAY_SIZE];

        for (int index=0; index<RANDOM_GENERATION_ARRAY_SIZE;index++){
            /*
             * Used the factory to generate objects
             */
            employeesArray[index]= EmployeeFactory.createEmployee((int)(Math.random()*3));
        }
        return employeesArray;
    }

    private void printAllElements(Employee[][] arrayForPrint){
        /*
         * In the loop, print the elements of each array
         */
        for (Employee[] arrayOfPosition: arrayForPrint){
            for (Employee employee:arrayOfPosition){
                if(employee==null) break;
                System.out.println("Position: "+employee.getPosition()+" Name: "+employee.getName() + " Salary: "+employee.getSalary());
            }
            System.out.println("**************************************");
        }
    }
}
