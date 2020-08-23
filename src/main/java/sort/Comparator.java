package sort;

public interface Comparator<T> {
    int compare(T var1, T var2);

    String getName();
}
