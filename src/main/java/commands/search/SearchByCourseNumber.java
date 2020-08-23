package commands.search;

import cli.Console;
import data.Student;
import list.Listable;
import search.LinearSearch;
import search.SearchComparator;

public class SearchByCourseNumber extends SearchAlgoCommand {
    private static final String sCommand = "Search by course number";
    public SearchByCourseNumber(Console console, Listable<Student> list) {
        super(console, list, sCommand);
    }
    @Override
    public void execute() {
        int course = console.readIntegerFromStdin("Please enter course number for the search:");
        Listable<Student> result = new LinearSearch<Student>().search(list, String.valueOf(course), new SearchComparator<Student>() {
            @Override
            public boolean compareSearch(String userInput, Student object) {

                return object.getCourse() == Integer.parseInt(userInput);
            }


        });
        printSearchResult(result);


    }
}
