package search;

import list.DoublyLinkedList;
import list.Listable;

public class LinearSearch<T> implements Searchable<T> {

    @Override
    public Listable<T> search(Listable<T> list, String userInput, SearchComparator<T> comparator) {
        Listable<T> result = new DoublyLinkedList<>();
        for(int i = 0 ; i < list.size(); i++){
            T cur = list.get(i);
            if(comparator.compareSearch(userInput, cur)){
                result.add(cur);
            }
        }
        return result;

    }


}
