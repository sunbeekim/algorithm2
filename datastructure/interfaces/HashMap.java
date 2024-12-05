package basic.algorithm2.datastructure.interfaces;

public interface HashMap<K, V> extends Entry<K, V>, ArrayList<Object>{
	// 키-값 쌍 추가
    void put(K key, V value);
//    void put(K key, ArrayList<Integer> value);
    // 키를 기반으로 값 가져오기vV
    V get(K key);

    // 키로 키-값 쌍 삭제
    V remove(K key);
    // 키를 기반으로 값 가져오기
//    ArrayList<Integer> get(K key, Object listValue);

    // 특정 키가 존재하는지 확인
    boolean containsKey(K key);

    // 특정 값이 존재하는지 확인
    boolean containsValue(V value);
//
//	// 특정 값이 존재하는지 확인
//	boolean containsValue(V value, Object listValue);

    // 모든 키를 삭제
    void clear();

    // 맵의 크기 반환
    int size();

    // 맵이 비어있는지 확인
    boolean isEmpty();

	Integer[] keySet();

}
