package basic.algorithm2.core.states;

import basic.algorithm2.core.StateManager;

public class InUseState implements State {
    @Override
    public void handle(StateManager stateManager) {
        System.out.println("DataNumber 인스턴스가 사용중입니다.");
    }
}