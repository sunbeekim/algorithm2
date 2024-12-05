package basic.algorithm2.datastructure.interfaces;

public interface Heap<T extends Comparable<T>> {

    void insert(T element);        // 힙에 요소 삽입
    T extractMin();                // 최소 힙에서 최소값을 추출
    T extractMax();                // 최대 힙에서 최대값을 추출
    void heapify();                // 힙 속성 유지
    boolean isEmpty();             // 힙이 비어있는지 확인
    int size();                    // 힙의 크기 반환
}
