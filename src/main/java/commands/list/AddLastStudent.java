package commands.list;

import cli.Console;
import data.Student;
import list.Listable;

public class AddLastStudent extends StudentCommand {

    private final static String sCommandName = "Add Student to the end of this list.";

    public AddLastStudent(Console console, Listable<Student> list) {
        super(console, list, sCommandName);
    }

    @Override
    public void execute() {
        Student s = readStudentFromStd();
        list.addLast(s);
    }
}
