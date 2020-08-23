package commands.list;

import cli.Console;
import commands.ICommand;
import list.Listable;

public abstract class ListCommand<T> implements ICommand {
    protected final transient Console console;
    protected final transient Listable<T> list;
    private final transient String commandName;


    public ListCommand(Console console, Listable<T> list, String commandName) {
        this.console = console;
        this.list = list;
        this.commandName = commandName;
    }

    @Override
    public String toString() {
        return commandName;
    }
}
