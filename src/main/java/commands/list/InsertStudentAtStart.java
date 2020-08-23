package commands.list;

import cli.Console;
import data.Student;
import list.Listable;

public class InsertStudentAtStart extends StudentCommand{
    private final static String sCommandName = "Inserts the Student at the beginning of this list.";

    public InsertStudentAtStart(Console console, Listable<Student> list) {
        super(console, list, sCommandName);
    }

    @Override
    public void execute() {
        Student s = readStudentFromStd();
        list.addFirst(s);
    }
}
