package basic.algorithm2.dataalgorithm.impements_a;

import basic.algorithm2.dataalgorithm.interface_a.Sort;

public class BubbleSortImpl<T extends Comparable<T>> implements Sort<T> {

	@Override
	public Integer[] sort(Integer[] array) {// 제너릭 사용
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					Integer temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}
	
}
