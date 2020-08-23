package commands.list;

import cli.Console;
import data.Student;
import list.Listable;

public class AppendStudentAtLast extends StudentCommand {
    private final static String sCommandName = "Appends the Student to the end of this list.";
    public AppendStudentAtLast(Console console, Listable<Student> list) {
        super(console, list, sCommandName);
    }

    @Override
    public void execute() {
        Student s = readStudentFromStd();
        list.addLast(s);

    }
}
