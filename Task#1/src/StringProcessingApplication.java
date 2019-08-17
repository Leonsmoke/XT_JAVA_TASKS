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
        while (true){
            switch (getTaskNumber()){
                case 0:
                    System.exit(0);
                case 1:                                           // 1 подпункт 2 задания
                    setLines(numberOfStrings);
                    printShortestLine();
                    printLongestLine();
                    break;
                case 2:                                           // 2 подпункт 2 задания
                    setLines(numberOfStrings);
                    printLinesLongerThan(getAverageLength());
                    break;
                case 3:                                           // 3 подпункт 2 задания
                    setLines(numberOfStrings);
                    printLinesShorterThan(getAverageLength());
                    break;
                case 4:                                           // 4 подпункт 2 задания
                    setLines(numberOfStrings);
                    printWordWithMinUniqChar();
                    break;
                case 5:                                           // 5 подпункт 2 задания
                    setLines(numberOfStrings);
                    printWordWithOnlyUniqChar();
                    break;
                case 6:
                    break;
            }
        }
    }

    private void getAllLines(){
        for (String line: stringArray
             ) {
            System.out.println(line);
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
                numberOfStrings=-1;
            }
        } while (numberOfStrings < MIN_NUMBER_OF_STRINGS && numberOfStrings > MAX_NUMBER_OF_STRINGS);
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

    private void setWords(int numberOfStrings){

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

    private void printWordWithMinUniqChar(){
        int minNumUniqChar = Integer.MAX_VALUE;
        String minUniqString = "";

        for (String line: stringArray
        ) {
            char[] word = line.toCharArray();
            int uniqChar = 1;

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
        System.out.println(minUniqString);
    }

    private void printWordWithOnlyUniqChar(){
        String uniqCharString = null;

        for (String line: stringArray
        ) {
            char[] word = line.toCharArray();
            boolean flag = false;

            if (uniqCharString!=null) break;
            for (int index=1; index < word.length;index++){
                for (int index_sec=0; index_sec<index;index_sec++){
                    if (word[index_sec]!=word[index]){
                        flag=true;
                        break;
                    }
                }

            }
            if (flag) continue;
            uniqCharString = line;
        }
        System.out.println(uniqCharString);
    }


}
