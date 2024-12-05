package basic.algorithm2.datastructure.implementations;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import basic.algorithm2.datastructure.interfaces.ArrayList;
import basic.algorithm2.datastructure.interfaces.HashMap;



public class HashMapImpl<K, V> implements HashMap<K, V> {

	private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int INITIAL_CAPACITY = 16; // 초기 크기
	private static final double LOAD_FACTOR = 0.75;// 리사이징
	private int threshold; // 리사이징을 트리거할 임계값 
	//map은 메모리 공간의 점유율에 따라 리사이징을 해야 효율이 좋음
	//0.7~0.8이 가장 효율 좋은 임계값
	//16*0.75 = 12 즉, 메모리 점유가 12초과 13이상이 되면 16*2 = 32의 사이즈로 메모리를 할당
	//32*0.75 = 24 메모리 점유가 25이상이면 64로 사이즈 확장
    private Entry<K, V>[] table;  //entry
    private int size; // map의 사이즈

    public HashMapImpl() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
        threshold = (int) (INITIAL_CAPACITY * LOAD_FACTOR); // 초기 임계값 설정
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    @Override
    public void put(K key, V value) {
    	if (size >= threshold) { // size가 threshold를 초과하면 리사이징
            resize();
        }
    	
        int index = hash(key);
        Entry<K, V> newEntry = new Entry<>(key, value);

        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> current = table[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value; 
                    return;
                }
                current = current.next;
            }
            newEntry.next = table[index];
            table[index] = newEntry;
        }
        size++;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        Entry<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; 
    }

    @Override
    public K getKey() {
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                return entry.key;
            }
        }
        return null;  
    }

    @Override
    public V getValue() {
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                return entry.value;
            }
        }
        return null; 
    }
    

    @Override
    public void setValue(V value) {
     
    }

    @Override
    public V remove(K key) {
        int index = hash(key);
        Entry<K, V> current = table[index];
        Entry<K, V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[index] = current.next; 
                } else {
                    previous.next = current.next;  
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        return null;  
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(V value) {
        for (Entry<K, V> entry : table) {
            Entry<K, V> current = entry;
            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    private void resize() {
        // 현재 테이블의 크기를 두 배로 늘린다.
        int newCapacity = table.length * 2;
        // 새로운 테이블을 생성
        Entry<K, V>[] newTable = new Entry[newCapacity];

        // 기존의 테이블에서 모든 항목을 새 테이블로 재배치
        for (Entry<K, V> entry : table) {
            while (entry != null) {
                // 새로운 테이블의 인덱스를 계산 (hash 값 기반)
                int index = Math.abs(entry.key.hashCode()) % newCapacity;
                Entry<K, V> next = entry.next;

                // 새 테이블에 항목을 배치
                entry.next = newTable[index];
                newTable[index] = entry;

                entry = next;
            }
        }

        // 새 테이블을 현재 테이블로 교체
        table = newTable;
        // 리사이징 후 임계값을 새 테이블 크기 기준으로 설정
        threshold = (int) (newCapacity * LOAD_FACTOR);  // 업데이트된 임계값
    }

	@Override
	public Integer[] keySet() {
		
		Set<K> keys = new HashSet<>();	   
		for (Entry<K, V> node : table) { // Node는 내부 데이터 구조의 요소
	        if (node != null) {
	            keys.add(node.key);
	        }
	    }
	    return keys.stream().toArray(Integer[]::new);
	    //set<k>에 맵이가진 노드가 null이 아니라면 맵의 key를 저장
	    //set<k>.스트림(순회).배열을 출력(인티저배열 타입을 새로 생성)
	    //key값이 3이라면 new Integer[3]으로 반환 
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    for (Entry<K, V> entry : table) {
	        if (entry != null) {
	            sb.append("키: ").append(entry.key)
	              .append(", 값: ").append(entry.value).append("\n");
	        }
	    }
	    return sb.toString();
	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object search(int data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(int index, int newdata) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
