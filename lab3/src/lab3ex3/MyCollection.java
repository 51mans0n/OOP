package lab3ex3;

public interface MyCollection<E> {
    int size();
    boolean add(E element);
    boolean remove(E element);
    void clear();
    boolean isEmpty();
    boolean lastIndexOf(E element);
}
