package commands.search;

import cli.Console;
import data.Student;
import list.Listable;
import search.LinearSearch;
import search.SearchComparator;

public class SearchByMatriculationNumber extends SearchAlgoCommand {
    private static final String sCommand = "Search by matriculation number";
    public SearchByMatriculationNumber(Console console, Listable<Student> list) {
        super(console, list, sCommand);
    }
    @Override
    public void execute() {

        int matriculation = console.readIntegerFromStdin("Please enter matriculation for the search::");
        Listable<Student> result = new LinearSearch<Student>().search(list,
                String.valueOf(matriculation),
                new SearchComparator<Student>() {
                    @Override
                    public boolean compareSearch(String userInput, Student object) {

                        return object.getMatriculationNumber() == Integer.parseInt(userInput);
                    }

                });
        printSearchResult(result);


    }
}
