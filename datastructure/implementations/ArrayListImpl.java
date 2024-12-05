package basic.algorithm2.datastructure.implementations;

import basic.algorithm2.datastructure.interfaces.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ArrayListImpl<T> implements ArrayList<T> {

    private static final int INITIAL_CAPACITY = 10; // 초기 용량
    private T[] elements; // 요소를 저장할 배열
    private int size; // 현재 요소 개수

    // 생성자
    @SuppressWarnings("unchecked")
    public ArrayListImpl() {
        elements = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public void add(T element) {
        ensureCapacity(); // 용량 체크 및 확장
        elements[size++] = element;
    }

    @Override
    public T get(int index) {
        validateIndex(index); // 유효한 인덱스인지 확인
        return elements[index];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null; // 요소 해제
        }
        size = 0;
    }

    @Override
    public T search(int data) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(data)) {
                return elements[i];
            }
        }
        return null; // 데이터가 없을 경우
    }
    
    // 데이터의 인덱스를 반환
    public int searchIndex(int data) {    	
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(data)) {
                return i;  // 데이터의 인덱스를 반환
            }
        }
        return -1;  // 데이터가 없으면 -1을 반환
    }

    
    @Override
    public boolean modify(int index, int newData) {
        validateIndex(index); // 유효성 검사
        try {
            elements[index] = (T) Integer.valueOf(newData); // 수정
            return true;
        } catch (ClassCastException e) {
            return false; // 데이터 타입 불일치
        }
    }

    @Override
    public T remove(int index) {
        validateIndex(index);
        T removedElement = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1]; // 요소 이동
        }
        elements[--size] = null; // 마지막 요소 제거
        return removedElement;
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
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elements[currentIndex++];
            }
        };
    }

    // 내부 메서드: 배열 용량 증가
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size == elements.length) {
            T[] newElements = (T[]) new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
    }

    // 내부 메서드: 인덱스 유효성 검사
    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
    public Integer[] toIntegerArray() {
        Integer[] array = new Integer[size]; // size만큼 배열을 생성
        for (int i = 0; i < size; i++) {
            array[i] = (Integer) elements[i]; // elements 배열의 요소를 Integer 배열로 변환
        }
        return array;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append("ArrayListImpl{elements=[");
        
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        
        //sb.append("]}");
        return sb.toString();
    }
    
    public int findValueIndexInList(Integer key, Integer value) {
        // key로 리스트를 가져옵니다.
        ArrayListImpl<Integer> list = (ArrayListImpl<Integer>) get(key);
        
        if (list == null) {
            // key에 해당하는 list가 없다면, -1을 반환
            return -1;
        }
        
        // list에서 value의 index를 반환
        return list.search(value);
    }
    public int FindValueByIndex(Integer key, Integer index) {
        // key로 리스트를 가져옵니다.
        ArrayListImpl<Integer> list = (ArrayListImpl<Integer>) get(key);
        
        if (list == null) {
            // key에 해당하는 list가 없다면, -1을 반환
            return -1;
        }
        
        // list에서 value의 index를 반환
        return list.get(index);
    }
    

	private int indexOf(Integer value) {
		// TODO Auto-generated method stub
		
		return (int) search(value);
	}
}
