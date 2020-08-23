package commands.search;

import cli.Console;
import data.Student;
import list.Listable;
import search.LinearSearch;
import search.SearchComparator;

public class SearchByPrename extends SearchAlgoCommand {
    private static final String sCommand = "Search by prename";
    public SearchByPrename(Console console, Listable<Student> list) {
        super(console, list, sCommand);
    }
    @Override
    public void execute() {
        String prename = console.readStringFromStdin("Please enter prename for the search:");
        Listable<Student> result = new LinearSearch<Student>().search(list, prename, new SearchComparator<Student>() {
            @Override
            public boolean compareSearch(String userInput, Student object) {

                return object.getPrename().toLowerCase().contains(userInput);
            }

        });
        printSearchResult(result);

    }
}

