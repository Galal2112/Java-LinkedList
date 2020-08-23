package commands;

import cli.Console;
import commands.list.*;
import commands.search.*;
import commands.sort.SortAlgoCommand;
import commands.sort.SortByCourse;
import commands.sort.SortByMatriculationNumber;
import commands.sort.SortCommand;
import data.Student;
import list.DoublyLinkedList;
import list.Listable;
import sort.BubbleSort;
import sort.SelectionSort;
import sort.Sortable;

public class CommandFactory {

    public static Listable<ICommand> createStudentCommendList(Console console, Listable<Student> studentList) {
        DoublyLinkedList<ICommand> list = new DoublyLinkedList<>();
        list.add(new AddLastStudent(console, studentList));
        list.add(new InsertStudentAtPos(console, studentList));
        list.add(new InsertStudentAtStart(console, studentList));
        list.add(new AppendStudentAtLast(console, studentList));
        list.add(new ReturnStudentAtSpecifiedPos(console, studentList));
        list.add(new PrintAllStudents(console, studentList));
        list.add(new ReturnNumberOfStudents(console, studentList));
        list.add(new RemoveStudentFromSpecifiedPos(console, studentList));
        list.add(new RemoveAllStudents(console, studentList));
        list.add(new SearchCommand(console, studentList));
        list.add(new SortCommand(console, studentList));
        return list;
    }

    public static Listable<ICommand> createSortCommendList(Console console, Listable<Student> studentList) {
        DoublyLinkedList<ICommand> list = new DoublyLinkedList<>();
        list.add(new SortAlgoCommand(console, studentList, new BubbleSort<>()));
        list.add(new SortAlgoCommand(console, studentList, new SelectionSort<>()));
        return list;
    }
    public static Listable<ICommand> chooseSortParamCommendList(Console console, Listable<Student> studentList, Sortable<Student> sortable) {
        DoublyLinkedList<ICommand> list = new DoublyLinkedList<>();
        list.add(new SortByCourse(console, studentList, sortable));
        list.add(new SortByMatriculationNumber(console, studentList, sortable));
        return list;
    }

    public static Listable<ICommand> chooseSearchParamCommendList(Console console, Listable<Student> studentList) {
        DoublyLinkedList<ICommand> list = new DoublyLinkedList<>();
        list.add(new SearchByPrename(console, studentList));
        list.add(new SearchBySurname(console, studentList));
        list.add(new SearchByCourseNumber(console, studentList));
        list.add(new SearchByMatriculationNumber(console, studentList));
        return list;
    }


}
