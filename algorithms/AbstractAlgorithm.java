package basic.algorithm2.algorithms;

import basic.algorithm2.core.StateManager;
import basic.algorithm2.core.states.ErrorState;
import basic.algorithm2.core.states.InitializedState;
import basic.algorithm2.datastructure.implementations.ArrayListImpl;
import basic.algorithm2.datastructure.implementations.HashMapImpl;
import basic.algorithm2.manager.DataManager;
import basic.algorithm2.utill.DataNumber;

public abstract class AbstractAlgorithm implements Algorithm {
	protected final DataManager dm; // DataManager 참조
	protected final DataNumber dataNumber; // 공용 DataNumber
	protected final StateManager state; // DataNumber의 상태를 관리
	private final java.util.Scanner scanner = new java.util.Scanner(System.in); // Scanner 객체 재사용

	public AbstractAlgorithm(DataManager dm) {
		this.dm = dm;
		this.dataNumber = DataNumber.getInstance(); // Singleton DB라고 생각
		this.state = new StateManager(dataNumber);
	}

	public AbstractAlgorithm() {//AbstractAlgorithm을 상속받는 DataManager를 인스턴스화
		this(new DataManager());
		//DataNumber= 싱글톤, StateManager:DataNumber에 의존
		//DataManager(입출력을 예외처리하고 버퍼사용) = 사용이 많이 되기 때문에 혼선방지를위해
		//DataManager에서만 처리할 수 있도록 외부에서 전달받아 사용
	}

	// ===========================================================================//
	public boolean numArrayInPut(Integer[] inputs) {
		for (int i = 0; i < inputs.length; i++) {
			if (inputs[i] < 0) {
				dataNumber.getStateManager().setState("ErrorState");
				outputMessageln("잘못된 입력입니다: 음수는 입력할 수 없습니다.");
				return false; // 음수가 있으면 false 반환
			}
		}
		return true; // 모두 양수일 경우 true 반환
	}

	// ===========================================================================//
	public boolean numArrayCheck(int num) {
		if (num > 10 || num < 1)
			return false;
		return true;
	}

	// ===========================================================================//
	// List[N] 또는 Map(key, List[N])로 입력값 처리
	public boolean numArrayInPut(int[] inputs) {
		for (int i = 0; i < inputs.length; i++) {
			if (inputs[i] < 0) {
				dataNumber.getStateManager().setState("ErrorState");
				outputMessageln("잘못된 입력입니다: 음수는 입력할 수 없습니다.");
				return false; // 음수가 있으면 false 반환
			}
		}
		return true; // 모두 양수일 경우 true 반환
	}

	// ===========================================================================//
	@Override
	public void setCalculate() {
		// 상태 확인
		if (state.getCurrentState() instanceof ErrorState) {
			outputMessageln("데이터 저장 불가: 현재 Error 상태입니다.");
			return;
		}
		
		state.setState("InUseState");
		
		outputMessage("입력 할 Map의 개수 : ");
		dataNumber.setInputNum(inputInteger(""));
		int numInputs = dataNumber.getInputNum();
		if (numArrayCheck(numInputs) == false) {
			outputMessageln("1부 10까지만 입력할 수 있습니다.\n");
			return;
		}
		// N의 입력 개수 10으로 제한
		// 입력값 처리
		// 입력값을 List 또는 Map에 저장
		// outputMessage("타입을 입력해주세요. (List/Map) :");
		// String choice = inputString("");
		// int[] numarray = new int[numInputs];
		// 입력값을 List[N] or Map(key, List[N])
//		if ("List".equalsIgnoreCase(choice)) {
//			for (int i = 0; i < numInputs; i++) {
//				outputMessage((i + 1) + "번째 값을 입력하세요.");
//				int inputVal = inputInteger("");
//				dataNumber.list.add(inputVal); // List에 값 추가
//			} // 입력 값만큼 반복해서 리스트에 추가
//			if (!numArrayInPut(dataNumber.list.toIntegerArray())) {
//				return; // 음수 입력 시 바로 리턴
//			}
//			outputMessageln("입력값이 저장되었습니다: " + dataNumber.list.toString());
//		} else 
//			if ("Map".equalsIgnoreCase(choice)) {

		for (int i = 0; i < numInputs; i++) {
			dataNumber.addNewList();
			outputMessage("입력할 List의 개수 :");
			int listVal = inputInteger("");

			outputMessageln("==== " + (i + 1) + "번 map =====");
			for (int j = 0; j < listVal; j++) {
				outputMessage("map list " + (j + 1) + " :");
				int inputVal = inputInteger("");
				dataNumber.listArray.get(i).add(inputVal);
			}
			dataNumber.map.put(i, dataNumber.listArray.get(i)); // Map에 key, value 리스트 추가
		}

		if (!numArrayInPut(dataNumber.map.keySet())) {
			return; // 음수 입력 시 바로 리턴
		}
		outputMessageln("입력값이 저장되었습니다");
		// 리스트 내 전체 순번

		for (Integer key : dataNumber.map.keySet()) {
			if (dataNumber.map.get(key) != null) {
				outputMessageln("==== " + (key + 1) + "번 map =====");
				ArrayListImpl<Integer> list = dataNumber.map.get(key);
				for (Integer value : list) {
					int index = list.searchIndex(value); // 리스트에서 값의 인덱스 찾기
					outputMessage("List Value : " + value + " (인덱스: " + (index + 1) + ")\n");
				}
			}
		}
//		}
	}

	// ===========================================================================//
	@Override
	public void getCalculate() {
		// 상태 확인
		if (state.getCurrentState() instanceof InitializedState) {
			outputMessageln("계산 불가: 데이터가 초기화된 상태입니다.");
			return;
		}
//		// List or Map 처리
//		if (dataNumber.list != null) { // list가 존재하는 경우
//			executeAlgorithm(dm, dataNumber.list); // executeAlgorithm에 List 전달
//			outputMessageln(dataNumber.list + "");
//			dataNumber.setState(new FinishedState());
//			dataNumber.handle();	}
		if (dataNumber.map.keySet() != null) { // map이 존재하는 경우
			executeAlgorithm(dataNumber.map); // executeAlgorithm에 Map 전달
			outputMessageln("");
			outputMessageln(dataNumber.map + "");
			state.setState("FinishedState");
			
		}
	}

	// ===========================================================================//
	// 추상 메서드: 개별 알고리즘 구현 로직
	protected abstract Object executeAlgorithm(HashMapImpl<Integer, ArrayListImpl<Integer>> map);

	// protected abstract Object executeAlgorithm(DataManager dm,
	// ArrayListImpl<Integer> inputList);

	// ===========================================================================//
	// 정수 입력 메서드
	protected Integer inputInteger(String prompt) {

		return dm.getInputHandler().getIntegerInput(scanner); //
	}

	protected String inputString(String prompt) {

		return dm.getInputHandler().getStringInput(scanner);
	}
	// ===========================================================================//

	// 출력 처리 공통 메서드
	protected void outputMessage(String message) {
		dm.getOutputHandler().append(message);
		dm.getOutputHandler().print();
		dm.getOutputHandler().clear();
	}

	protected void outputMessageln(String message) {
		dm.getOutputHandler().append(message);
		dm.getOutputHandler().println();
		dm.getOutputHandler().clear();
	}

	protected void outputMessageWait(String message) {
		dm.getOutputHandler().append(message);
	}

	protected void outputMessagePrint(String message) {
		dm.getOutputHandler().print();
	}

	
}
