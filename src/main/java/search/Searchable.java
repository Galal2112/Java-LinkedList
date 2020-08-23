package search;

import list.Listable;

public interface Searchable<T> {

    Listable<T> search(Listable<T> list, String userInput, SearchComparator<T> comparator);

}
