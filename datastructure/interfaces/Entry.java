package basic.algorithm2.datastructure.interfaces;

public interface Entry<K, V> {
    // 키 반환
    K getKey();
    
    // 값 반환
    V getValue();
    
    // 값 설정
    void setValue(V value);
}