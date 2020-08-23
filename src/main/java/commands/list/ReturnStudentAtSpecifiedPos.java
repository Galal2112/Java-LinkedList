package commands.list;

import cli.Console;
import data.Student;
import list.Listable;

public class ReturnStudentAtSpecifiedPos extends StudentCommand{
    private final static String sCommandName = "Returns the Student at the specified position in this list.";

    public ReturnStudentAtSpecifiedPos(Console console, Listable<Student> list) {

        super(console, list, sCommandName);
    }

    @Override
    public void execute() {
        do {
            int pos = console.readIntegerFromStdin("Please enter the position:");
            try {
                Student s = list.get(pos);
                System.out.println(s);
                return;
            } catch(IndexOutOfBoundsException e) {
                System.out.println(getUpdateErrorMessage("get", false));
                if (list.isEmpty()) {
                    return;
                }
            }
        } while (true);

    }
}
