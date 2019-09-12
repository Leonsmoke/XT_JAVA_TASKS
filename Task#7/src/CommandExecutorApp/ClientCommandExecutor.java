package CommandExecutorApp;

import CommandExecutorApp.Executor.Executor;
import CommandExecutorApp.commands.*;

public class ClientCommandExecutor {

    public static void main(String[] args) {
        ClientCommandExecutor app = new ClientCommandExecutor();
        app.runFirstTest();
    }

    /**
     * Method that executes test commands with specified test data
     */
    public void runFirstTest(){
        /*
         * Create an executor to execute commands
         */
        Executor executor = new Executor();

        /*
         * Create command objects to get random numbers
         */
        Command intRandom = new RandomIntCommand();
        Command doubleRandom = new RandomDoubleCommand();

        /*
         * Create an array of different numbers and with the help of commands
         * fill them with different random numbers
         */
        Number[] numbers = new Number[]{executor.executeCommand(intRandom),executor.executeCommand(intRandom),executor.executeCommand(intRandom),
                executor.executeCommand(doubleRandom),executor.executeCommand(intRandom)};
        Command printer = new PrintNumberCommand(numbers);
        executor.executeCommand(printer);
        numbers[3]= executor.executeCommand(new TripleNumberCommand(numbers[3]));
        printer = new PrintNumberCommand(numbers);
        executor.executeCommand(printer);
    }

}
