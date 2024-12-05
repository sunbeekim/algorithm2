package basic.algorithm2.algorithms.sorting;

import basic.algorithm2.algorithms.AbstractAlgorithm;
import basic.algorithm2.dataalgorithm.interface_a.Sort;
import basic.algorithm2.datastructure.implementations.ArrayListImpl;
import basic.algorithm2.datastructure.implementations.HashMapImpl;

public class DescSort<T extends Comparable<T>> extends AbstractAlgorithm implements Sort<T> {

	@Override
	protected Object executeAlgorithm(HashMapImpl<Integer, ArrayListImpl<Integer>> map) {
		for (Integer key : map.keySet()) {
			ArrayListImpl<Integer> list = map.get(key);
			Integer[] descSort = new Integer[list.size()];
			descSort = sort(list.toIntegerArray());
			outputMessage("Sort Number : ");
			for (Integer num : descSort) {
				outputMessage(" " + num);
			}
			outputMessageln("");
		}
		return "";//반환 값을 Object type
	}

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
