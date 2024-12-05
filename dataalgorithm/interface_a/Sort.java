package basic.algorithm2.dataalgorithm.interface_a;


public interface Sort<T extends Comparable<T>> {

    Integer[] sort(Integer[] array);          // 배열 정렬
}
