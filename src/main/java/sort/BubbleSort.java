package sort;

import list.Listable;

public class BubbleSort<T> extends Swapper<T> implements Sortable<T> {
    public BubbleSort() {
    }

    public void sort(Listable<T> list, Comparator<T> comparator) {
        int size = list.size();
        for(int i = 1; i < size; ++i) {
            for(int e = 0; e < size - i; ++e) {
                if (comparator.compare(list.get(e), list.get(e + 1)) > 0) {
                    this.swap(list, e, e + 1);
                }
            }
        }

    }

    @Override
    public String toString() {
        return "Bubble Sort";

    }
}