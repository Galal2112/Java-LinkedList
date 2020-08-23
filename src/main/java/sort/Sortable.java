package sort;

import list.Listable;

public interface Sortable<T> {
    void sort(Listable<T> var1, Comparator<T> var2);
}
