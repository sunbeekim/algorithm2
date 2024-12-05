package basic.algorithm2.core.states;

import basic.algorithm2.core.StateManager;


public class ErrorState implements State {

	@Override
	public void handle(StateManager stateManager) {
		System.out.println("DataNumber에서 오류가 발생했습니다.");
		
	}

}
