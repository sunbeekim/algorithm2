package basic.algorithm2.datastructure.implementations;



import java.util.Iterator;

import basic.algorithm2.datastructure.interfaces.ArrayList;


public class LinkedListImpl<T> implements ArrayList<T>{

	/**
	 * 직렬화 - 객체를 파일화 해서 저장이나 전송이 가능해짐
	 * 바이트스트림으로 변환 즉 이 객체 자체가 char 2byte int 4byte...
	 * char 16bit = 2^16 = 65536 
	 * 유니코드(코드 포인트) 일관적으로 사용할 수 있는 일종의 기준표
	 * unicoded(65) = 'A', unicoded(44032) = '가'
	 * 0~65535 즉, char가 나타낼 수 있는 문자는 최대 65536개
	 */
	private static final long serialVersionUID = 1L;

	// Node 클래스
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // 리스트의 첫 번째 노드와 크기 변수
    private Node<T> head;
    private int size;

    public LinkedListImpl() {
        head = null;
        size = 0;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;  // 리스트가 비었으면, 첫 번째 노드로 설정
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;  // 마지막 노드로 이동
            }
            current.next = newNode;  // 마지막 노드의 next에 새 노드 추가
        }
        size++;  // 리스트 크기 증가
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;  // 주어진 인덱스까지 탐색
        }
        return current.data;  // 해당 인덱스의 데이터 반환
    }

    @Override
    public void clear() {
        head = null;  // 모든 노드를 제거하여 리스트 비우기
        size = 0;
    }

    @Override
    public T search(int data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return current.data;  // 데이터가 일치하면 반환
            }
            current = current.next;  // 다음 노드로 이동
        }
        return null;  // 데이터가 없으면 null 반환
    }

    @Override
    public boolean modify(int index, int newdata) {
        if (index < 0 || index >= size) {
            return false;  // 유효하지 않은 인덱스
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;  // 주어진 인덱스까지 탐색
        }
        current.data = (T) Integer.valueOf(newdata);  // 새로운 데이터로 수정
        return true;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> current = head;
        T removedData;
        
        // 만약 첫 번째 노드를 삭제하려면
        if (index == 0) {
            removedData = head.data;
            head = head.next;  // 첫 번째 노드 삭제
        } else {
            Node<T> previous = null;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;  // 주어진 인덱스까지 탐색
            }
            removedData = current.data;
            previous.next = current.next;  // 현재 노드를 연결 리스트에서 제거
        }
        size--;  // 리스트 크기 감소
        return removedData;
    }

    @Override
    public int size() {
        return size;  // 리스트의 크기 반환
    }

    @Override
    public boolean isEmpty() {
        return size == 0;  // 리스트가 비었으면 true, 아니면 false
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;  // 더 이상 탐색할 노드가 있으면 true 반환
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                T data = current.data;
                current = current.next;  // 다음 노드로 이동
                return data;
            }
        };
    }

	
	
//===================================================//
//	private static LinkedList instance;
//	private static class Node {
//
//		int data;// 데이터값
//		Node next;// 다음주소를 가르키는 node - 재귀호출
//
//		// 노드 생성자
//		public Node(int data) {
//			this.data = data;
//			this.next = null;
//		}
//	}
//
//	private Node head;// 시작지점이자 datamanager의 필드에 선언
//
//	// private 생성자 (싱글톤)
//	public LinkedListImpl() {//packge를 나눠서 public으로
//		this.head = null;// 리스트의 첫번째 순서 head를 null로 초기화
//	}
//	public static LinkedList getInstance() {
//		if (instance == null) {
//			instance = new LinkedList();
//		}
//		return instance;
//	}

//	public void add(int data) {
//
//		Node newNode = new Node(data);// data를 넣은 node를 생성
//		if (head == null) {// head가 null이면
//			head = newNode;// 데이터를가진 node는 head가 됨
//		} else {// head가 null이 아니라면
//			Node current = head;// head는 데이터를 가지고 있는것이므로 head는 current로 대입
//			while (current.next != null) {// 재귀호출이기때문에 결국 head가 가지고 있는 node객체의 객체변수 (node)next로 이동
//				// null이 아닐때까지 next를 타고 이동하다가 null이면 반복문을 빠져나감
//				current = current.next;// 다음주소를 가진 자기자신을 호출해서 덮어씌움
//				// 즉, 마지막 노드가 next객체(node)를 생성함
//			}
//			current.next = newNode;// 생성한 객체에는 데이터가 존재하지 않으므로
//			// 데이터를 가진 node객체 newnode를 대입하면 마지막 node객체의 필드변수 data는 값을가지고 있고
//			// next는 null인 상태
//		}
//		System.out.println("데이터 추가: " + data);
//	}

	// 데이터 삭제 메서드
//	public void remove(int data) {// 삭제할 데이터
//		if (head == null) {// head(초기값)이 비어있으면 데이터가 없다는 뜻이므로 경고문 출력
//			System.out.println("리스트가 비어 있습니다.");
//			return;
//		}
//
//		if (head.data == data) {// data는 head가 가지고 있는 data와 같다면
//			head = head.next;// 좌변의 head 즉, 기존head는 다음head로 덮어씌어지고 기존head는 사라진다.
//
//			System.out.println("데이터 삭제: " + data);
//			return;
//		}
//		// null도 아니고 head랑 같은 값도 아니면
//		Node current = head;// head는 node에 대입. current는 첫번째 노드가 되는 것
//		while (current.next != null) {// 다음 node가 없으면 반복 중단
//			if (current.next.data == data) {// 다음 노드의 데이터가 인자값과 같으면
//				current.next = current.next.next; // 노드 삭제(덮어쓰기*주소상실)
//				System.out.println("데이터 삭제: " + data);
//				return;
//			}
//			current = current.next; // 다음 노드로 이동
//		}
//
//		System.out.println("삭제할 데이터가 없습니다: " + data);
//
//	}

//	// 데이터 출력 메서드
//	public void printList() {
//		if (head == null) {
//			System.out.println("리스트가 비어 있습니다.");
//			return;
//		}
//
//		Node current = head;
//		System.out.print("리스트 데이터: ");
//		while (current != null) {
//			System.out.print(current.data + " -> ");
//			current = current.next;
//		}
//		System.out.println("null");
//	}

	// 리스트 초기화 메서드
//	public void clear() {
//		head = null;
//		System.out.println("리스트 초기화 완료.");
//	}

//	public Integer getDataAtIndex(int index) {// 정수가 아닌 null을 반환 할 수도 있으므로 integer로
//		if (head == null) { // 리스트가 비어 있으면
//			System.out.println("리스트가 비어 있습니다.");
//			return null;
//		}
//
//		Node current = head; // head부터 탐색 시작
//		int currentIndex = 0; // 현재 인덱스
//
//		// 주어진 인덱스에 해당하는 노드를 찾을 때까지 탐색
//		while (current != null) {
//			if (currentIndex == index) {
//				return current.data; // 해당 인덱스에 있는 데이터 반환
//			}
//			current = current.next; // 다음 노드로 이동
//			currentIndex++; // 인덱스 증가
//		}
//
//		System.out.println("주어진 인덱스가 리스트 범위를 벗어났습니다.");
//		return null; // 인덱스가 범위를 벗어나면 null 반환
//	}
//
//	public int getIndexOfData(int targetData) {
//		if (head == null) { // 리스트가 비어 있으면
//			System.out.println("리스트가 비어 있습니다.");
//			return -1; // 값이 없으므로 -1 반환
//		}
//
//		Node current = head; // head부터 탐색 시작
//		int currentIndex = 0; // 현재 인덱스
//
//		while (current != null) {
//			if (current.data == targetData) { // 찾고자 하는 data 값과 일치하는지 확인
//				System.out.println("Index : " + currentIndex);
//				return currentIndex; // 일치하면 해당 인덱스 반환
//			}
//			current = current.next; // 다음 노드로 이동
//			currentIndex++; // 인덱스 증가
//		}
//
//		System.out.println("주어진 데이터가 리스트에 없습니다.");
//		return -1; // 리스트에서 찾을 수 없는 경우 -1 반환
//	}
//
//	public int getLength() {// node의 개수를 반환
//		int length = 0;
//		Node current = head;
//		while (current != null) {
//			length++;
//			current = current.next;
//		}
//		return length;
//	}
//
//	public boolean modify(int index, int newData) {// 수정 메서드
//		if (head == null) {
//			System.out.println("리스트가 비어 있습니다.");
//			return false;
//		}
//
//		Node current = head;
//		int currentIndex = 0;
//
//		while (current != null) {
//			if (currentIndex == index) {// 0 == index
//				current.data = newData; // 데이터 수정
//				System.out.println("인덱스 " + index + "의 값을 " + newData + "(으)로 수정했습니다.");
//				return true;
//			}
//			current = current.next;
//			currentIndex++;
//		}
//
//		System.out.println("주어진 인덱스가 리스트 범위를 벗어났습니다.");
//		return false; // 인덱스가 범위를 벗어난 경우;
//	}
//	public void  addAfter(data, newData)
//	public void  printReversed()

}
