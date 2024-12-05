package basic.algorithm2.manager;

import basic.algorithm2.dataalgorithm.impements_a.BubbleSortImpl;
import basic.algorithm2.datastructure.implementations.LinkedListImpl;

public class DataStructureManager {
	
    private final LinkedListImpl linkedList;

    public DataStructureManager() {
        
        this.linkedList = new LinkedListImpl();
    }

    public LinkedListImpl getLinkedList() {
        return linkedList;
    }
}
