package basic.algorithm2.datastructure.interfaces;

public interface Queue<T> {

    void enqueue(T element);       // 큐에 요소를 추가
    T dequeue();                   // 큐에서 요소를 제거하고 반환
    T front();                     // 큐의 front 요소를 반환 (제거하지 않음)
    boolean isEmpty();             // 큐가 비어있는지 확인
    int size();                    // 큐의 크기 반환
}
