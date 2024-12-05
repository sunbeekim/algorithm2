package basic.algorithm2.dataalgorithm.interface_a;

public interface Search<T> {
    int linearSearch(T[] array, T key);     // 선형 탐색
    int binarySearch(T[] sortedArray, T key); // 이진 탐색 (정렬된 배열)
}
