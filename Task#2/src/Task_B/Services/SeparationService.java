package Task_B.Services;

import Task_B.Models.Employee;

import static Task_B.WorkWithStaffApplication.RANDOM_GENERATION_ARRAY_SIZE;
/*
 * Melnikov Dmitrii
 * Practice 2 (Class and objects), Task B
 */
public class SeparationService {
    static final String JANITOR_CLASSNAME = "Task_B.Models.Janitor";
    static final String ENGINEER_CLASSNAME = "Task_B.Models.Engineer";
    static final String MANAGER_CLASSNAME = "Task_B.Models.Manager";
    static final int NUMBER_OF_CLASS = 3;

    public static Employee[][] separateArray(Employee[] originalArray){
        /*
         * Number of employees in each position
         */
        int janitorNum = 0;
        int engineerNum = 0;
        int managerNum = 0;
        Employee[][] tempArray = new Employee[NUMBER_OF_CLASS][RANDOM_GENERATION_ARRAY_SIZE];

        /*
         * In the loop, each element of the array is checked for compliance with the classname,
         * then put the element in the desired array
         */
        for(int index=0; index<originalArray.length;index++){
            switch (originalArray[index].getClass().getName()){
                case JANITOR_CLASSNAME:
                    tempArray[0][janitorNum]=originalArray[index];
                    janitorNum++;
                    break;
                case ENGINEER_CLASSNAME:
                    tempArray[1][engineerNum]=originalArray[index];
                    engineerNum++;
                    break;
                case MANAGER_CLASSNAME:
                    tempArray[2][managerNum]=originalArray[index];
                    managerNum++;
                    break;
                default: System.out.println("Something went wrong");
            }
        }
        return tempArray;
    }

}
