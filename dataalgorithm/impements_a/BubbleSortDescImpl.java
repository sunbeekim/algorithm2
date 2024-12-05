package basic.algorithm2.dataalgorithm.impements_a;

import basic.algorithm2.dataalgorithm.interface_a.Sort;

public class BubbleSortDescImpl <T extends Comparable<T>> implements Sort<T> {

	@Override
    public Integer[] sort(Integer[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) { // j가 i까지 가도록 수정
                if (array[j].compareTo(array[j + 1]) < 0) { // 내림차순으로 비교
                	Integer temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

}
