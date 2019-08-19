package SecondTask;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Melnikov Dmitrii
 * Practice#1
 * Task#2
 */
public class StringProcessingApplication {

    private static final int MAX_NUMBER_OF_STRINGS  = 20;     // Максимальное количество строк для обработки
    private static final int MIN_NUMBER_OF_STRINGS = 1;       // Минимальное количество строк для обработки

    String[] stringArray;

    public static void main(String[] args) {
        StringProcessingApplication application = new StringProcessingApplication();
        application.run();
    }

    public void run(){
        int numberOfStrings = getNumberOfString();
        stringArray = new String[numberOfStrings];

        setLines(numberOfStrings);
        while (true){
            switch (getTaskNumber()){
                case 0:
                    System.exit(0);
                case 1:                                           // 1 подпункт 2 задания
                    printShortestLine();
                    printLongestLine();
                    break;
                case 2:                                           // 2 подпункт 2 задания
                    printLinesLongerThan(getAverageLength());
                    break;
                case 3:                                           // 3 подпункт 2 задания
                    printLinesShorterThan(getAverageLength());
                    break;
                case 4:                                           // 4 подпункт 2 задания
                    System.out.println(getWordWithMinUniqChar());
                    break;
                case 5:                                           // 5 подпункт 2 задания
                    System.out.println(getWordWithOnlyUniqChar());
                    break;
                case 6:                                           // 6 подпункт 2 задания
                    System.out.println(getWordWithOnlyDigits());
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

    private int getNumberOfString(){
        Scanner scanner = new Scanner(System.in);    // Создаем сканнер, для ввода номера задания
        int numberOfStrings = 0;

        do {
            System.out.println("\nEnter the number of string to process ("+
                    MIN_NUMBER_OF_STRINGS+"-"+MAX_NUMBER_OF_STRINGS+") ");
            try{
                numberOfStrings=scanner.nextInt();
            }catch (InputMismatchException e){
                System.err.println("Please enter a number.");
                scanner.next();
                numberOfStrings=-1;
            }
        } while (numberOfStrings < MIN_NUMBER_OF_STRINGS || numberOfStrings > MAX_NUMBER_OF_STRINGS);
        return numberOfStrings;
    }

    private void setLines(int numberOfStrings){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter "+numberOfStrings+" lines.");
        for (int index=0;index < numberOfStrings;index++){
            try{
                stringArray[index]=scanner.nextLine();
            } catch (Exception e){
                System.err.println(e);
            }

        }
    }

    private void printShortestLine(){
        int minLength = Integer.MAX_VALUE;
        String shortestLine = "";
        for (String line: stringArray
             ) {
            if (line.length()<minLength){
                shortestLine=line;
                minLength = line.length();
            }
        }
        System.out.println("Shortest line: "+ shortestLine + "\n" +
                "Length = "+minLength);
    }

    private void printLongestLine(){
        int maxLength = Integer.MIN_VALUE;
        String longestLine = "";
        for (String line: stringArray
        ) {
            if (line.length()>maxLength){
                longestLine=line;
                maxLength = line.length();
            }
        }
        System.out.println("Longest line: "+ longestLine + "\n" +
                "Length = "+maxLength);
    }

    private float getAverageLength(){
        float sum = 0;

        for (String line: stringArray
             ) {
            sum+=line.length();
        }
        return (sum/stringArray.length);
    }

    private void printLinesLongerThan(float minLength){
        for (String line: stringArray
             ) {
            if (line.length()>minLength){
                System.out.println(line + "\n" +
                        "Length = " + line.length());
            }
        }
    }

    private void printLinesShorterThan(float maxLength){
        for (String line: stringArray
        ) {
            if (line.length()<maxLength){
                System.out.println(line + "\n" +
                        "Length = " + line.length());
            }
        }
    }

    private String getWordWithMinUniqChar(){
        int minNumUniqChar = Integer.MAX_VALUE;                         // Минимальное количество различных символов
        String minUniqString = "";                                      // Строка с минимальным вхождением различных символов

        for (String line: stringArray
        ) {
            char[] word = line.toCharArray();                           // Массив символов слова
            int uniqChar = 1;                                           // Количество уникальных символов

            for (int index=1; index < word.length;index++){
                for (int index_sec=0; index_sec<index;index_sec++){
                    if (word[index_sec]==word[index]){
                        uniqChar--;
                        break;
                    }
                }
                uniqChar++;
            }
            if (uniqChar<minNumUniqChar){
                minNumUniqChar=uniqChar;
                minUniqString=line;
            }
        }
        return minUniqString;
    }

    private String getWordWithOnlyUniqChar(){
        String uniqCharString = null;

        for (String line: stringArray
        ) {
            char[] word = line.toCharArray();
            boolean hasSameLetter = false;                            // Флаг, для обозначения, имеются ли одинаковые символы

            if (uniqCharString!=null) break;
            for (int index=1; index < word.length;index++){
                for (int index_sec=0; index_sec<index;index_sec++){
                    if (word[index_sec]!=word[index]){
                        hasSameLetter=true;
                        break;
                    }
                }

            }
            if (hasSameLetter) continue;
            uniqCharString = line;
        }
        return uniqCharString;
    }

    private String getWordWithOnlyDigits(){
        int numberOnlyDigitsWord = 0;
        String onlyDigitsWord = "Nothing";

        /*
         * Чтобы найти строки, в которых были использованы лишь цифры
         * будем проверять промежуток между значениями ASCII кодов цифр от 0 (48) до 9 (57)
         */
        for (String line: stringArray
        ) {
            boolean hasLetter = false;                 // флаг, для обозначения, есть ли буква в слове
            char[] word = line.toCharArray();

            for (int index=0; index < word.length;index++){
                if (word[index]<48 || word[index]>57){
                    hasLetter=true;
                    break;
                }
            }
            if (!hasLetter && numberOnlyDigitsWord<2){
                numberOnlyDigitsWord++;
                onlyDigitsWord=line;
            }
        }
        return onlyDigitsWord;
    }

}
