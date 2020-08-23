package commands.list;

import cli.Console;
import data.Student;
import list.Listable;

public class PrintAllStudents extends StudentCommand {
    private final static String sCommandName = "Print all students to console from list.";

    public PrintAllStudents(Console console, Listable<Student> list) {
        super(console, list, sCommandName);
    }

    @Override
    public void execute() {
        list.printAll();
    }
}
