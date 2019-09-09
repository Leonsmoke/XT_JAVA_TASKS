package CommandExecutorApp.commands;

public interface Command<T extends Number> {
    T execute();
}
