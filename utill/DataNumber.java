package basic.algorithm2.utill;

import java.util.ArrayList;
import java.util.List;

import basic.algorithm2.core.StateManager;
import basic.algorithm2.datastructure.implementations.ArrayListImpl;
import basic.algorithm2.datastructure.implementations.HashMapImpl;

public class DataNumber {
    private static DataNumber instance;
    private final StateManager stateManager;

    public static HashMapImpl<Integer, ArrayListImpl<Integer>> map = new HashMapImpl<>();
    public static ArrayListImpl<Integer> list = new ArrayListImpl<>();
    public static List<ArrayListImpl<Integer>> listArray = new ArrayList<>();
    private Integer inputNum;

    // 싱글턴 생성자
    private DataNumber() {
        this.stateManager = new StateManager(this);
        this.stateManager.setState("InUseState");
    }

    // 싱글턴 인스턴스 반환
    public static DataNumber getInstance() {
        if (instance == null) {
        	synchronized (DataNumber.class) { // 동기화 블록
                if (instance == null) {
                    instance = new DataNumber();
                }
            }
        }
        return instance;
    }

    // DataNumber 초기화 메서드
    public void initialize() {
        list.clear();
        map.clear();
        listArray.clear();
        inputNum = 0;
    }

    // 상태 관리자 반환
    public StateManager getStateManager() {
        return stateManager;
    }

    // 입력 값 설정
    public void setInputNum(Integer inputNum) {
        this.inputNum = inputNum;
    }

    public Integer getInputNum() {
        return inputNum;
    }

    // 새로운 리스트 추가
    public void addNewList() {
        ArrayListImpl<Integer> newList = new ArrayListImpl<>();
        listArray.add(newList);
    }
}
