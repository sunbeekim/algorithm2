package basic.algorithm2.datastructure.implementations;

import basic.algorithm2.datastructure.interfaces.Entry;

public class EntryImpl<K, V> implements Entry<K, V> {
	private K key;
    private V value;

    public EntryImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
	@Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }

}
