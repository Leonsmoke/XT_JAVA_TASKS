package CommandExecutorApp.commands;

public class PrintNumberCommand implements Command{

    private Number[] numbers;

    public PrintNumberCommand(Number... numbers) {
        this.numbers = numbers;
    }

    @Override
    public Number execute() {
        for (Number num: numbers
             ) {
            System.out.println(num.toString());
        }
        return null;
    }
}
