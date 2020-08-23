package commands.list;

import cli.Console;
import data.Student;
import list.Listable;

public abstract class StudentCommand extends ListCommand<Student> {

    public StudentCommand(Console console, Listable<Student> list, String commandName) {
        super(console, list, commandName);
    }

    public Student readStudentFromStd() {
        String prename = console.readStringFromStdin("Please enter prename:");
        String surname = console.readStringFromStdin("Please enter surname:");
        int courseNumber = console.readIntegerFromStdin("Please enter course number:");
        int marticulationNumber = console.readIntegerFromStdin("Please enter matriculation number:");
        return new Student(prename, surname, courseNumber, marticulationNumber);
    }

    public String getUpdateErrorMessage(String action, boolean isInsert) {
        if (list.isEmpty()) {
            if (isInsert) {
                return "List is Empty, please insert at beginning (0)";
            }
            return "List is Empty, cannot perform " + action + " action.";
        } else {
            int maxIndex = list.size();
            if (!isInsert) {
                maxIndex -= 1;
            }
            if (maxIndex == 0) {
                return "Max number allowed is " + maxIndex + ".";
            }
            return "Please insert a number between 0 and " + maxIndex + ".";
        }
    }
}
