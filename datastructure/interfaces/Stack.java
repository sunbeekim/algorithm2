package basic.algorithm2.datastructure.interfaces;

public interface Stack<T> {

    void push(T element);          // 요소를 스택에 추가
    T pop();                       // 스택에서 요소를 제거하고 반환
    T peek();                      // 스택의 top 요소를 반환 (제거하지 않음)
    boolean isEmpty();             // 스택이 비어있는지 확인
    int size();                    // 스택의 크기 반환
}