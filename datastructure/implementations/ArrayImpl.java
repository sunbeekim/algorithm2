package basic.algorithm2.datastructure.implementations;

import java.util.Iterator;

import basic.algorithm2.datastructure.interfaces.Array;

public class ArrayImpl<T> implements Array<T>{
	ArrayUtilsImpl arrayUtills = new ArrayUtilsImpl();
	private T[] elements;
    private int size = 0; 
    
    @SuppressWarnings("unchecked")
    public ArrayImpl(int startCapacity) {
    	if(startCapacity < 0) throw new IllegalArgumentException("배열크기가 음수입니다.");
    	elements = (T[]) new Object[startCapacity];
    }
    
    @Override
    public T get(int index) {
        checkIndex(index);
        return elements[index];
    }

    @Override
    public void set(int index, T element) {
        checkIndex(index);
        elements[index] = element;
    }

    @Override
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T removed = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null; // Avoid memory leaks
        return removed;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
    	ArrayUtilsImpl.fill(elements, 0, size, null);
        size = 0;
    }

	 @Override
	    public void resize(int newCapacity) {		 
	        if (newCapacity < size)
	            throw new IllegalArgumentException("New capacity must be at least the current size");
	        elements = arrayUtills.copyOf(elements, newCapacity);
	    }

	    private void ensureCapacity() {
	        if (size == elements.length) {
	            resize(elements.length == 0 ? 1 : elements.length * 2);
	        }
	    }

	    private void checkIndex(int index) {
	        if (index < 0 || index >= size) {
	            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	        }
	    }

		@Override
		public Iterator<T> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

}
