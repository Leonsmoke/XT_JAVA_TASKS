package CommandExecutorApp.commands;

public class RandomIntCommand implements Command<Integer> {
    @Override
    public Integer execute() {
        return (int)(Math.random()*100);
    }
}
