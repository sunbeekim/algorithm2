package basic.algorithm2.algorithms.sorting;

import basic.algorithm2.algorithms.AbstractAlgorithm;
import basic.algorithm2.dataalgorithm.interface_a.Sort;
import basic.algorithm2.datastructure.implementations.ArrayListImpl;
import basic.algorithm2.datastructure.implementations.HashMapImpl;

public class AscSort<T extends Comparable<T>> extends AbstractAlgorithm implements Sort<T> {

	@Override
	protected Object executeAlgorithm(HashMapImpl<Integer, ArrayListImpl<Integer>> map) {
		for (Integer key : map.keySet()) {
			ArrayListImpl<Integer> list = map.get(key);
			Integer[] ascSort = new Integer[list.size()];
			ascSort = sort(list.toIntegerArray());
			outputMessage("Sort Number : ");
			for (Integer num : ascSort) {
				outputMessage(" " + num);
			}
			outputMessageln("");
		}
		return "";// 반환 값을 Object type

	}

	public Integer[] sort(Integer[] array) {
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
