package basic.algorithm2.core.states;

import basic.algorithm2.core.StateManager;


public class InitializedState implements State {
    @Override
    public void handle(StateManager stateManager) {
    	
        System.out.println("새로운 DataNumber 인스턴스 생성 및 상태초기화 실행");
    }
}

