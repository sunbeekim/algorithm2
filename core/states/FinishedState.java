package basic.algorithm2.core.states;

import basic.algorithm2.core.StateManager;

public class FinishedState implements State{
	
	@Override
    public void handle(StateManager stateManager) {
        // 완료 상태에서의 동작: 리소스 정리 또는 로그 출력
		stateManager.initializeDataNumber();
        System.out.println("작업이 성공적으로 완료되었습니다.");

        // 필요한 추가 종료 작업
        cleanupResources();
    }

    private void cleanupResources() {
        // 종료 시 리소스 정리 작업 (필요하면 구현)
        //System.out.println("리소스가 정리되었습니다.");
    }

}
