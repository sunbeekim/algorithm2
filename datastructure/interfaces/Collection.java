package basic.algorithm2.datastructure.interfaces;

import java.io.Serializable;
import java.util.RandomAccess;

public interface Collection<T> extends Iterable<T>, Serializable, Cloneable, RandomAccess{
	T remove(int index); // 공통 메서드 정의

	int size(); // 모든 데이터 구조에서 공통적으로 사용될 메서드

	boolean isEmpty(); // 공통적으로 사용할 수 있는 메서드
}
