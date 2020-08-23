package commands.list;

import cli.Console;
import data.Student;
import list.Listable;

public class ReturnNumberOfStudents extends StudentCommand{
    private final static String sCommandName = "Returns the number of Students in this list.";

    public ReturnNumberOfStudents(Console console, Listable<Student> list) {
        super(console, list, sCommandName);
    }

    @Override
    public void execute() {
        int size = list.size();
        System.out.println("Number of students: " + size);
    }
}
