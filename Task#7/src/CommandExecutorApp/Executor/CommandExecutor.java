package CommandExecutorApp.Executor;

import CommandExecutorApp.commands.Command;

public interface CommandExecutor<T> {

    T executeCommand(Command<? extends Number> command);
}
