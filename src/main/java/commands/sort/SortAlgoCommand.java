package commands.sort;

import cli.Console;
import commands.CommandFactory;
import commands.CommandInvoker;
import commands.ICommand;
import commands.list.StudentCommand;
import data.Student;
import list.Listable;
import sort.Sortable;

public class SortAlgoCommand extends StudentCommand {
    protected Sortable<Student> sortAlgo;

    public SortAlgoCommand(Console console, Listable<Student> list, Sortable<Student> sortAlgo) {
        super(console, list, sortAlgo.toString());
        this.sortAlgo = sortAlgo;
    }
    public SortAlgoCommand(Console console, Listable<Student> list, Sortable<Student> sortAlgo, String name) {
        super(console, list, name);
        this.sortAlgo = sortAlgo;
    }

    @Override
    public void execute() {
        Listable<ICommand> commands  = CommandFactory.chooseSortParamCommendList(console, list, sortAlgo);
        String headline = "Please select a property for sorting with the '" + sortAlgo.toString() + "' algorithm:";
        CommandInvoker commandInvoker = new CommandInvoker(commands, console, headline, false);
        commandInvoker.run();
    }
}
