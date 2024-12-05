package basic.algorithm2.core.states;

import basic.algorithm2.core.StateManager;
public class ClearedState implements State{

	@Override
	public void handle(StateManager stateManager) {
		 System.out.println("DataNumber의 데이터를 초기화했습니다.");
		
	}

	

}
