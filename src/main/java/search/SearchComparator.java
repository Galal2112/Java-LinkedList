package search;

public interface SearchComparator<T> {

    boolean compareSearch(String userInput, T object);

}

