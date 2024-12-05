package basic.algorithm2.algorithms;

import basic.algorithm2.datastructure.implementations.ArrayListImpl;
import basic.algorithm2.datastructure.implementations.HashMapImpl;
import basic.algorithm2.manager.DataManager;

public class Fibonachi extends AbstractAlgorithm {
//	map의 구조
//	map(Integer,arraylist(list))
//	map.keyset() key가 가지는 set
//	keyset(0)은 arraylist(0,(list(0))
//	arraylist(0)은 list([0: value],[1: value],[2: value]...)
	@Override
	protected Object executeAlgorithm(HashMapImpl<Integer, ArrayListImpl<Integer>> map) {

		for (Integer key : map.keySet()) {
			ArrayListImpl<Integer> list = map.get(key);
			outputMessageln(key + 1 + "번 Map List Value : " + map.getValue());
			int i = 0;
			for (Integer value : list) {
				outputMessage("[" + value + "]번 까지의 수열 ");

				int n = list.get(i);
				int a = 0, b = 1;
				outputMessage("피보나치 수열 : ");
				for (int j = 0; j <= n; j++) {
					outputMessage(a + " ");
					int next = a + b;
					a = b;
					b = next;
				}
				outputMessageln("");
				i++;
			}
		}
		return "";
	}

	public int fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

}
