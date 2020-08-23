package sort;

import list.Listable;

public class SelectionSort<T> extends Swapper<T> implements Sortable<T> {
    public SelectionSort() {
    }

    public void sort(Listable<T> list, Comparator<T> comparator) {
        int size = list.size();
        int minimun = 0;
        for (int i = 0; i < size; i++) {
            minimun = i;
            for (int e = i + 1; e < size; e++) {
                if (comparator.compare(list.get(e), list.get(minimun)) < 0) {
                    minimun = e;
                }
            }
            swap(list, i, minimun);
        }
    }

    @Override
    public String toString() {
        return "Selection Sort";
    }
}
