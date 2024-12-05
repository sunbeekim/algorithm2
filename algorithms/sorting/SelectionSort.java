package basic.algorithm2.algorithms.sorting;

import basic.algorithm2.algorithms.AbstractAlgorithm;
import basic.algorithm2.dataalgorithm.interface_a.Sort;
import basic.algorithm2.datastructure.implementations.ArrayListImpl;
import basic.algorithm2.datastructure.implementations.HashMapImpl;

public class SelectionSort<T extends Comparable<T>> extends AbstractAlgorithm implements Sort<T> {

	@Override
	protected Object executeAlgorithm(HashMapImpl<Integer, ArrayListImpl<Integer>> map) {
		for (Integer key : map.keySet()) {
			ArrayListImpl<Integer> list = map.get(key);
			Integer[] selectSort = new Integer[list.size()];
			selectSort = sort(list.toIntegerArray());
			outputMessage("Sort Number : ");
			for (Integer num : selectSort) {
				outputMessage(" " + num);
			}
			outputMessageln("");
		}
		return "";// 반환 값을 Object type
	}

	@Override
	public Integer[] sort(Integer[] array) {
		int n = array.length;

		for (int i = 1; i < n; i++) {
			int key = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}

		return array;
	}

}
