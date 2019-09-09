package CommandExecutorApp.Executor;

import CommandExecutorApp.commands.Command;

public class Executor implements CommandExecutor {

    @Override
    public Number executeCommand(Command command) {
        return command.execute();
    }
}
