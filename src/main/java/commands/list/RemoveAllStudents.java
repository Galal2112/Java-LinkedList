package commands.list;

import cli.Console;
import data.Student;
import list.Listable;

public class RemoveAllStudents extends StudentCommand{
    private final static String sCommandName = "Removes all of the Students from this list.";

    public RemoveAllStudents(Console console, Listable<Student> list) {
        super(console, list, sCommandName);
    }

    @Override
    public void execute() {
        list.clear();
        System.out.println("List removed successfully");
    }
}
