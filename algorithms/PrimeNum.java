package basic.algorithm2.algorithms;

import basic.algorithm2.datastructure.implementations.ArrayListImpl;
import basic.algorithm2.datastructure.implementations.HashMapImpl;
import basic.algorithm2.manager.DataManager;

public class PrimeNum extends AbstractAlgorithm {

	public PrimeNum() {
		super(); // 상위 클래스 생성자 호출
	}
//
//	@Override
//	protected Object executeAlgorithm(DataManager dm, ArrayListImpl<Integer> inputList) {
//		Integer[] input = inputList.toIntegerArray();
//		
//		
//	    for (Integer integer : input) {
//	    	boolean isPrime = true;
//	    	
//	    	if (integer <= 1) {
//	            isPrime = false;
//	        } else {
//	            // 소수 판별
//	            for (int i = 2; i <= Math.sqrt(integer); i++) {
//	                if (integer % i == 0) {
//	                    isPrime = false;
//	                    break;
//	                }
//	            }
//	        }
//	        // 결과 출력
//	        if (isPrime) {
//	            //dm.getOutputHandler().append(integer + " = true입니다. (소수)\n");
//	            outputMessageln(integer + " = true입니다. (소수)\n");
//	        } else {
//	            //dm.getOutputHandler().append(integer + " = false입니다. (소수가 아님)\n");
//	            outputMessageln(integer + " = false입니다. (소수가 아님)\n");
//	        }
//		}
//	        
//	        
//	        
//	    
//		return "";
//	}

	@Override
	protected Object executeAlgorithm(HashMapImpl<Integer, ArrayListImpl<Integer>> map) {

		// =============================================//
		for (Integer key : map.keySet()) {
			System.out.println("키: " + key + ", 값: " + map.get(key));
			if (map.get(key) != null) {
				// =============================================//
				boolean isPrime = true;
				for (Integer value : map.get(key)) {
					// =============================================//
					if (value <= 1) {
						isPrime = false;
					} else {
						// 소수 판별
						for (int i = 2; i <= Math.sqrt(value); i++) {
							if (value % i == 0) {
								isPrime = false;
								break;
							}
						}
					}
					// 결과 출력
					if (isPrime) {
						// dm.getOutputHandler().append(value + " = true입니다. (소수)\n");
						outputMessageln(value + " = true입니다. (소수)\n");
					} else {
						// dm.getOutputHandler().append(value + " = false입니다. (소수가 아님)\n");
						outputMessageln(value + " = false입니다. (소수가 아님)\n");
					}
					// =============================================//
				}
			}

		}
		return dm;
	}

}
