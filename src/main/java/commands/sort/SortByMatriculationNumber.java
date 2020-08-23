package commands.sort;

import cli.Console;
import data.Student;
import list.Listable;
import sort.MatrNrComparator;
import sort.Sortable;

public class SortByMatriculationNumber extends SortAlgoCommand {
    private static final String sCommand = "Sort by matriculation number";

    public SortByMatriculationNumber(Console console, Listable<Student> list, Sortable<Student> sortAlgo) {
        super(console, list, sortAlgo, sCommand);
    }
    @Override
    public void execute() {
        sortAlgo.sort(list, new MatrNrComparator());
    }
}
