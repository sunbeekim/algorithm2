package basic.algorithm2.datastructure.interfaces;

public interface Tree<T> {

    void insert(T element);        // 트리에 요소를 삽입
    boolean contains(T element);    // 트리에 특정 요소가 존재하는지 확인
    void remove(T element);        // 트리에서 요소를 삭제
    T findMin();                   // 트리에서 가장 작은 요소 찾기
    T findMax();                   // 트리에서 가장 큰 요소 찾기
    int size();                    // 트리의 크기 반환
    boolean isEmpty();             // 트리가 비어있는지 확인
}
