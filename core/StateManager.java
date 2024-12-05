package basic.algorithm2.core;

import basic.algorithm2.core.states.*;
import basic.algorithm2.utill.DataNumber;
import java.util.Map;
import java.util.HashMap;

public class StateManager implements State{
    private final Map<String, State> states;  // 여러 상태를 저장
    private State currentState; // 현재 상태
    private final DataNumber dataNumber; // 상태 관리 대상 객체

    // 생성자
    public StateManager(DataNumber dataNumber) {
        this.dataNumber = dataNumber; // DataNumber 의존성 주입
        this.states = new HashMap<>();
        initializeStates();  // 상태 초기화
        this.currentState = states.get("Initialized");  // 초기 상태 설정
    }

    // 상태를 초기화
    private void initializeStates() {
        states.put("InitializedState", new InitializedState());
        states.put("FinishedState", new FinishedState());
        states.put("InUseState", new InUseState());
    }

    // 상태를 전환
    public synchronized void setState(String stateKey) {
        if (states.containsKey(stateKey)) {
            this.currentState = states.get(stateKey);
            this.currentState.handle(this);
            System.out.println("상태 : " + stateKey );
        } else {
            throw new IllegalArgumentException("유효하지 않은 상태: " + stateKey);
        }
    }

    // 현재 상태를 반환
    public State getCurrentState() {
        return currentState;
    }

    // DataNumber 초기화를 위임
    public void initializeDataNumber() {
        dataNumber.initialize();
        setState("InitializedState"); // 상태 전환
    }

	@Override
	public void handle(StateManager stateManager) {
		if (currentState != null) {
            currentState.handle(stateManager);
        }
		
	}
}
