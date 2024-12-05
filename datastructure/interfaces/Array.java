package basic.algorithm2.datastructure.interfaces;

public interface Array<T> extends Collection<T> {
	T get(int index);
    void set(int index, T element);
    void add(T element);
    void clear();
    void resize(int newCapacity);
}