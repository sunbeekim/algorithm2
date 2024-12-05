package basic.algorithm2.core;

import java.util.HashMap;
import java.util.Map;

import basic.algorithm2.algorithms.Algorithm;
import basic.algorithm2.algorithms.DigitSum;
import basic.algorithm2.algorithms.Fibonachi;
import basic.algorithm2.algorithms.GCDivisor;
import basic.algorithm2.algorithms.MaxAndMin;
import basic.algorithm2.algorithms.PerfectNum;
import basic.algorithm2.algorithms.Power;
import basic.algorithm2.algorithms.PrimeNum;
import basic.algorithm2.algorithms.Pyramid;
import basic.algorithm2.algorithms.ReverseNum;
import basic.algorithm2.algorithms.WhileSum;
import basic.algorithm2.algorithms.sorting.AscSort;
import basic.algorithm2.algorithms.sorting.DescSort;
import basic.algorithm2.algorithms.sorting.SelectionSort;
import basic.algorithm2.algorithms.sorting.SellSort;

public class AlgorithmManager {
	private final Map<Integer, Algorithm> algorithmMap = new HashMap<>();

	public void registerAlgorithm(int key, Algorithm algorithm) {
		//키값에 맞는 클랙스의 객체를 생성해서 map에 put
		algorithmMap.put(key, algorithm);
	}

	public void executeAlgorithm(int key) {//메인에서 받은 choice -> key
		Algorithm algorithm = algorithmMap.get(key);
		//interface Algorithm을 구현한 객체에 key에 해당하는 값을 대입
		//ex) key : 1 value : new PrimNum();
		//즉, 객체는 인터페이스화 되어 객체를 가진 인터페이스 -> 구현할 때 인터페이스의 요소를 필수로 구현
		//객체의 실제 클래스 타입은 유지되지만, 변수는 인터페이스 타입
		//(인터페이스(객체))는 인터페이스객체 - 이걸 변수로 선언한다면
		// Algorithm (new PrimNum()) -> algorithm
		// Algorithm 타입의 PrimNum이므로 algorithm을 구현할때 
		// Algorithm의 타입은 setCalculate(), getCalculate()을 포함하므로
		// algorithm은 위 두개의 메서드를 가지고 있어야 하는데
		// algorithm은 PrimNum을 요소로 가지고 있기때문에
		// PrimNum은 Algorithm의 타입(메서드 2개)를 포함해야 함
		// 결국 algorithm은 인터페이스구현클래스
		
		
		if (algorithm != null) {
			algorithm.setCalculate();
			algorithm.getCalculate();
		} else {
			throw new IllegalArgumentException("유효하지 않은 알고리즘 번호입니다.");
		}
		
	}

	public void displayMenu() {
		System.out.println("|==================================================|");
		algorithmMap.forEach((key, algorithm) -> // 매개변수
		System.out.printf("| %d. %s\n", key, algorithm.getClass().getSimpleName())
		//매개변수를 받아서 실행할 코드
		);
		System.out.println("| 0. 종료                                           |");
		System.out.println("|==================================================|");
		System.out.print("메뉴 선택 :");
	}
	
	public void addAlgorithms() {
        registerAlgorithm(1, new PrimeNum());
        registerAlgorithm(2, new Fibonachi());
        registerAlgorithm(3, new ReverseNum());
        registerAlgorithm(4, new DigitSum());
        registerAlgorithm(5, new PerfectNum());
        registerAlgorithm(6, new Power());
        registerAlgorithm(7, new GCDivisor());
        registerAlgorithm(8, new WhileSum());
        registerAlgorithm(9, new MaxAndMin());
        registerAlgorithm(10, new Pyramid());
        registerAlgorithm(11, new AscSort());
        registerAlgorithm(12, new DescSort());
        registerAlgorithm(13, new SelectionSort());
        registerAlgorithm(14, new SellSort());
    }
}
