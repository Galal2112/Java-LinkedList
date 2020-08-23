package commands.sort;

import cli.Console;
import data.Student;
import list.Listable;
import sort.CourseNrCompatator;
import sort.Sortable;

public class SortByCourse extends SortAlgoCommand {
    private static final String sCommand = "Sort by course";
    public SortByCourse(Console console, Listable<Student> list, Sortable<Student> sortAlgo) {
        super(console, list, sortAlgo, sCommand);
    }
    @Override
    public void execute() {
        sortAlgo.sort(list, new CourseNrCompatator());
    }
}
