package commands.search;

import cli.Console;
import commands.list.StudentCommand;
import data.Student;
import list.Listable;

public abstract class SearchAlgoCommand extends StudentCommand {

    public SearchAlgoCommand(Console console, Listable<Student> list, String name) {
        super(console, list, name);
    }

   public void printSearchResult(Listable<Student> searchResult) {
        if(searchResult.isEmpty()){
            System.out.println("No Results Found");
        } else {
            searchResult.printAll();
        }
   }
}
