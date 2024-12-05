package basic.algorithm2.algorithms.sorting;

import basic.algorithm2.algorithms.AbstractAlgorithm;
import basic.algorithm2.dataalgorithm.interface_a.Sort;
import basic.algorithm2.datastructure.implementations.ArrayListImpl;
import basic.algorithm2.datastructure.implementations.HashMapImpl;

public class SellSort <T extends Comparable<T>> extends AbstractAlgorithm implements Sort<T> {

	@Override
	public Integer[] sort(Integer[] array) {
		int n = array.length; //길이
		int gap = n/2; //초기간격 2
		
		while(gap > 0) {// gap 이 0미만이 되면 중지
			for (int i = gap; i < n; i++) {//현재 gap 기준 삽입정렬 ex) n = 10
				//반복 초기값 i = 5; 5 < 10; 5++ 5,6,7,8,9 5번 반복
				//반복 두번째 i = 2; 2 < 10; 2++ 2,3,4,5,6,7,8,9 8번 반복
				//반복 세번째 i = 1; 1 < 10; 1++ 1,2,3,4,5,6,7,8,9 9번 반복
				//최선 시간복잡도 5+8+9 = 22 연산
				//평균 시간복잡도 gap 5는 10연산 2는 15 1은 20 5+15+20 = 45연산
				//최악 시간복잡도 gap 5는 25연산 2는 30 1은 45 25+30+45 = 100연산				
		
				Integer temp = array[i];//현재 비교대상 값 템플에 저장
				int j = i; //배열이 10이면 반복 초기값은 2로나눈 값 j = 5, j = 2, j = 1
				
				while(j>=gap&&array[j-gap].compareTo(temp)>0) {//gap 간격 비교정렬
					array[j] = array[j-gap];//j-gap이 temp보다 크면 왼쪽으로 이동
					//간격 5 (gap/2)
					//(5>=5 && [5-5].compareTo(temp) = 오른쪽이 더 크면 -1 false 
					//(6>=5 && [6-5].compartTo(temp) = 왼쪽이 더 크면 1 ture
					//j = 6-5 ... j = 1
					//(1>=5 && [1-5].compareTo(temp) = false
					//...
					j -= gap;//j = j-gap true일때마다 반복문 내에서 누적계산
					
				}
				array[j] = temp;
				//[1] = [6]
				//...
				//(10log10
				}		
			gap /= 2;//누적 나누기 ex) gap = 5/2 = 2/2 = 1/2 = 0미만 총 3회 - 5, 2, 1
		}
		return array;
	}

	@Override
	protected Object executeAlgorithm(HashMapImpl<Integer, ArrayListImpl<Integer>> map) {
		for (Integer key : map.keySet()) {
			ArrayListImpl<Integer> list = map.get(key);
			Integer[] shellSort = new Integer[list.size()];
			shellSort = sort(list.toIntegerArray());
			outputMessage("Sort Number : ");
			for (Integer num : shellSort) {
				outputMessage(" " + num);
			}
			outputMessageln("");
		}
		return "";
	}

}
