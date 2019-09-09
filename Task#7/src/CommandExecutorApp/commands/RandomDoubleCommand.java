package CommandExecutorApp.commands;

public class RandomDoubleCommand implements Command<Double> {
    @Override
    public Double execute() {
        return Math.random()*100;
    }
}
