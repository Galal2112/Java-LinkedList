package commands.search;

import cli.Console;
import commands.CommandFactory;
import commands.CommandInvoker;
import commands.ICommand;
import commands.list.StudentCommand;
import data.Student;
import list.Listable;

public class SearchCommand extends StudentCommand {
    private final static String sCommandName = "Search for student(s) by different characteristics.";


    public SearchCommand(Console console, Listable<Student> list) {

        super(console, list, sCommandName);
    }

    @Override
    public void execute() {
        Listable<ICommand> commands  = CommandFactory.chooseSearchParamCommendList(console, list);
        String headline = "Select a property to search for the student:";
        CommandInvoker commandInvoker = new CommandInvoker(commands, console, headline, false);
        commandInvoker.run();
    }
}

