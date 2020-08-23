package commands.list;

import cli.Console;
import data.Student;
import list.Listable;

public class InsertStudentAtPos extends StudentCommand {
    private final static String sCommandName = "Inserts the Student at the specified position in this list.";

    public InsertStudentAtPos(Console console, Listable<Student> list) {
        super(console, list, sCommandName);
    }

    @Override
    public void execute() {
        Student s = readStudentFromStd();
        do {
            int pos = console.readIntegerFromStdin("Please enter the position:");
            try {
                list.add(pos, s);
                return;
            } catch(IndexOutOfBoundsException e) {
                System.out.println(getUpdateErrorMessage("insert", true));
            }
        } while (true);


    }
}
