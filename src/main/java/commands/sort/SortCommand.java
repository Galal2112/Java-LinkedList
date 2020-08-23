package commands.sort;

import cli.Console;
import commands.CommandFactory;
import commands.CommandInvoker;
import commands.ICommand;
import commands.list.StudentCommand;
import data.Student;
import list.Listable;

public class SortCommand extends StudentCommand {
    private static final String sCommand = "Sort list by different properties.";

    public SortCommand(Console console, Listable<Student> list) {
        super(console, list, sCommand);
    }

    @Override
    public void execute() {
        Listable<ICommand> commands  = CommandFactory.createSortCommendList(console, list);
        CommandInvoker commandInvoker = new CommandInvoker(commands, console,
                "Select a sorting method for sorting:", false);
        commandInvoker.run();
    }
}
