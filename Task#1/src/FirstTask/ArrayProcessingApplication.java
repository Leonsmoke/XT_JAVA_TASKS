package FirstTask;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Melnikov Dmitrii
 * Practice#1
 * Task#1
 */
public class ArrayProcessingApplication {

    private static final int ARRAY_SIZE = 20;         // Размер массива
    private static final int MAX_RANDOM_INT = 10;     // Верхняя граница случайного числа
    private static final int MIN_RANDOM_INT = -10;    // Нижняя граница случайного числа

    private int[] integerArray = new int[ARRAY_SIZE];

    public static void main(String[] args) {
        ArrayProcessingApplication application = new ArrayProcessingApplication();
        application.run();
    }

    public void run(){
        fillArrayWithRandomIntegers();
        printAllItemFromArray();
        while (true){
            switch (getTaskNumber()){
                case 0:
                    System.exit(0);
                case 1:                                                    // 1 Подпункт 1 задания
                    swapMaxNegativeNumWithMinPositiveNum();
                    printAllItemFromArray();
                    break;
                case 2:                                                    // 2 Подпункт 1 задания
                    printSumOfEvenItems();
                    break;
                case 3:                                                    // 3 Подпункт 1 задания
                    replaceNegativeNumWithZero();
                    printAllItemFromArray();
                    break;
                case 4:                                                    // 4 Подпункт 1 задания
                    tripleAllPositiveNumsBeforeNegative();
                    printAllItemFromArray();
                    break;
                case 5:                                                    // 5 Подпункт 1 задания
                    printDifferenceBetweenAverageAndMinNum();
                    break;
                case 6:                                                    // 6 Подпункт 1 задания
                    printRepeatedOddNum();
                    break;
            }
        }
    }

    private int getTaskNumber(){
        Scanner scanner = new Scanner(System.in);    // Создаем сканнер, для ввода номера задания
        int task = 0;

        do {
            System.out.println("\nSelect task number (1-6) '0' to exit: ");
            try{
                task=scanner.nextInt();
            }catch (InputMismatchException e){
                System.err.println("Please enter a number.");
                task=-1;
            }
        } while (task < 0 && task > 6);
        return task;
    }

    private void fillArrayWithRandomIntegers(){
        int randomRange = MAX_RANDOM_INT + Math.abs(MIN_RANDOM_INT) + 1;     // Интервал случайного числа

        for (int index = 0; index < ARRAY_SIZE;index++){
            integerArray[index] = (int)(Math.random()*randomRange) - MAX_RANDOM_INT;
        }
        System.out.println("Array has been filed!");
    }

    private void printAllItemFromArray(){

        // Выводим в консоль каждый элемент массива
        for (int singleInt: integerArray
        ) {
            System.out.print(singleInt+" ");
        }
        System.out.print("\n");
    }

    private void swapMaxNegativeNumWithMinPositiveNum (){
        int maxNegativeNumberPosition = -1;                 // Максимальное отрицательное число
        int minPositiveNumberPosition = -1;                 // Минимальное положительное число

        for (int index = 0; index < ARRAY_SIZE; index++){
            if (integerArray[index]<0){
                if (maxNegativeNumberPosition==-1){
                    maxNegativeNumberPosition=index;
                } else{
                    if (integerArray[index]>integerArray[maxNegativeNumberPosition]){
                        maxNegativeNumberPosition=index;
                    }
                }
            }
            if (integerArray[index]>0){
                if (minPositiveNumberPosition==-1){
                    minPositiveNumberPosition=index;
                } else{
                    if (integerArray[index]<integerArray[minPositiveNumberPosition]){
                        minPositiveNumberPosition=index;
                    }
                }
            }
        }

        swapNumbers(maxNegativeNumberPosition,minPositiveNumberPosition);
    }       // 1 Подпункт 1 задания

    private void printSumOfEvenItems(){
        int sum=0;

        /* т.к. нам нужны четные позиции,
         * значит нужно брать каждую вторую позицию,
         * начиная со второго элемента массива, т.е. index = 1
         */
        for(int index = 1;index < ARRAY_SIZE; index+=2){
            sum+=integerArray[index];
        }
        System.out.println(sum);
    }                         // 2 Подпункт 1 задания

    private void replaceNegativeNumWithZero(){
        for (int index=0; index < ARRAY_SIZE; index++){
            integerArray[index] = integerArray[index] < 0 ? 0:integerArray[index];
        }
    }                  // 3 Подпункт 1 задания

    private void tripleAllPositiveNumsBeforeNegative(){
        for (int index=0;index<ARRAY_SIZE-1;index++){
            if (integerArray[index] > 0 && integerArray[index+1] < 0){
                integerArray[index]*=3;
            }
        }
    }         // 4 Подпункт 1 задания

    private void printDifferenceBetweenAverageAndMinNum(){
        int sum = 0;                       // Сумма чисел
        int minNumber = MAX_RANDOM_INT;    // Минимальное число в массиве

        for (int singleInt:integerArray
             ) {
            sum+=singleInt;
            minNumber = singleInt<minNumber ? singleInt : minNumber;
        }
        System.out.println(((float)sum/ARRAY_SIZE)-minNumber);
    }      // 5 Подпункт 1 задания

    private void printRepeatedOddNum(){

        /*
         * Для поиска одинаковых элементов с нечетными индексами используем вложенный цикл
         * Начнем с нечетного индекса, т.е. со второй позиции массива first_index=1
         */
        for (int first_index=1; first_index<ARRAY_SIZE-1;first_index+=2){
            for (int second_index=0; second_index<ARRAY_SIZE;second_index++){

                /*
                 * В цикле перебираются числа с нечетными индексами и сравниваются со всеми остальными
                 * Если числа не совпадают, то начинается следующая итерация цикла
                 */
                if (integerArray[first_index]!=integerArray[second_index] || first_index==second_index){
                    continue;
                }

                /*
                 * Если перебираемые числа совпадают, то в консоли печтается это число.
                 * А управление передается во внешний цикл.
                 */
                System.out.print(integerArray[first_index]+" ");
                break;
            }
        }
    }                         // 6 Подпункт 1 задания

    private void swapNumbers(int firstNumberPosition, int secondNumberPosition){
        try{

            //Проверяем, нашлись ли положительные и отрицательные числа в массиве
            if (firstNumberPosition<0) throw new Exception("There is no negative number in the array");
            if (secondNumberPosition<0) throw new Exception("There is no positive number in the array");

            //Меняем местами два числа.
            integerArray[firstNumberPosition]+= integerArray[secondNumberPosition];
            integerArray[secondNumberPosition] = integerArray[firstNumberPosition]-integerArray[secondNumberPosition];
            integerArray[firstNumberPosition] = integerArray[firstNumberPosition]-integerArray[secondNumberPosition];
            /*
             *int temp = integerArray[firstNumberPosition];
             *integerArray[secondNumberPosition] = integerArray[firstNumberPosition];
             *integerArray[firstNumberPosition] = temp;
             */

        } catch (Exception e){
            System.err.print(e);
        }
    }

}
