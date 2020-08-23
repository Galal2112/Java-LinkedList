package commands.search;

import cli.Console;
import data.Student;
import list.Listable;
import search.LinearSearch;
import search.SearchComparator;

public class SearchBySurname extends SearchAlgoCommand{
    private static final String sCommand = "Search by surname";
    public SearchBySurname(Console console, Listable<Student> list) {
        super(console, list, sCommand);
    }
    @Override
    public void execute() {
        String surname = console.readStringFromStdin("Please enter surname for the search:");
        Listable<Student> result = new LinearSearch<Student>().search(list, surname, new SearchComparator<Student>() {
            @Override
            public boolean compareSearch(String userInput, Student object) {

                return object.getSurname().toLowerCase().contains(userInput);
            }

        });

        printSearchResult(result);


    }
}
