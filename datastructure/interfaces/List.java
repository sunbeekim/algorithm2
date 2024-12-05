package basic.algorithm2.datastructure.interfaces;

public interface List<T> extends Collection<T>{
	void add(T element);
    T get(int index);
    void clear();
    T search(int data);
    boolean modify(int index, int newdata);
}