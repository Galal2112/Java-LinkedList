package commands.list;

import cli.Console;
import data.Student;
import list.Listable;

public class RemoveStudentFromSpecifiedPos extends StudentCommand {
    private final static String sCommandName = "Removes the Student at the specified position in this list.";

    public RemoveStudentFromSpecifiedPos(Console console, Listable<Student> list) {
        super(console, list, sCommandName);
    }

    @Override
    public void execute() {
        do {
            int pos = console.readIntegerFromStdin("Please enter the position:");
            try {
                list.remove(pos);
                System.out.println("Student removed successfully");
                return;
            } catch(IndexOutOfBoundsException e) {
                System.out.println(getUpdateErrorMessage("remove", false));
                if (list.isEmpty()) {
                    return;
                }
            }
        } while (true);

    }
}
