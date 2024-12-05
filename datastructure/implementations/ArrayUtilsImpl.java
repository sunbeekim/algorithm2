package basic.algorithm2.datastructure.implementations;



import basic.algorithm2.datastructure.interfaces.ArrayUtils;

public class ArrayUtilsImpl implements ArrayUtils{

	@Override
    public <T> T[] copyOf(T[] original, int newLength) {//오버로딩해서 오버라이드
		//타입 - generic타입의 배열
		//메소드명 - copyOf
		//파라미터 - generic타입배열 original, int타입 newLength
        if (original == null) {//original이 null이라면
            throw new NullPointerException("Original array cannot be null.");
            //null이 될 수 없다는 예외처리
        }

        if (newLength < 0) {//0보다 작으면
        	//배열의 크기는 음수일 수 없다고 예외처리
            throw new NegativeArraySizeException("New length must be non-negative.");
        }
        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[newLength];
        //generic 배열 은 형변환-upcasting(generic) 객체생성 Object[] newLength값만큼의 크기
        int copyLength = Math.min(original.length, newLength);
        //두개의 배열 중에 더 작은 값을 반환
        //원본이 3 사본이 5이면 복사할 요소가 3개뿐이라 2개의 저장공간이 낭비되므로 3을 반환
        //원본이 5 사본이 3이면 저장공간이 3개뿐이므로 나머지를 버려야해서 3을 반환
        for (int i = 0; i < copyLength; i++) {
            newArray[i] = original[i];//최소배열의 수만큼 복사
        }
        return newArray;//리턴
    }

	@Override
    public int[] copyOf(int[] original, int newLength) {
        if (original == null) {
            throw new NullPointerException("Original array cannot be null.");
        }

        if (newLength < 0) {
            throw new NegativeArraySizeException("New length must be non-negative.");
        }

        int[] newArray = new int[newLength];
        int copyLength = Math.min(original.length, newLength);
        for (int i = 0; i < copyLength; i++) {
            newArray[i] = original[i];
        }
        return newArray;
    }

    @Override
    public double[] copyOf(double[] original, int newLength) {
        if (original == null) {
            throw new NullPointerException("Original array cannot be null.");
        }

        if (newLength < 0) {
            throw new NegativeArraySizeException("New length must be non-negative.");
        }

        double[] newArray = new double[newLength];
        int copyLength = Math.min(original.length, newLength);
        for (int i = 0; i < copyLength; i++) {
            newArray[i] = original[i];
        }
        return newArray;
    }

    @Override
    public <T> boolean isEmpty(T[] array) {//배열이 null인지 boolean 반환
        return array == null || array.length == 0;
    }

    @Override
    public Integer[] toIntegerArray(int[] original) {//Integer타입으로 전체복사 반환
        if (original == null) {
            throw new NullPointerException("Original array cannot be null.");
        }

        Integer[] newArray = new Integer[original.length];
        for (int i = 0; i < original.length; i++) {
            newArray[i] = original[i];
        }
        return newArray;
    }

    @Override
    public Double[] toDoubleArray(double[] original) {//Double
        if (original == null) {
            throw new NullPointerException("Original array cannot be null.");
        }

        Double[] newArray = new Double[original.length];
        for (int i = 0; i < original.length; i++) {
            newArray[i] = original[i];
        }
        return newArray;
    }
    //=====================================================//
    //fill 메서드() 초기화를 위해 모든 요소를 동일한 값으로 바꾸는 메서드
    //다형성의 무서움 너무 많음
    //범위체크 메서드만 일단 추가해 봄
    //더 깊이 들어가면 collections.sort()내부에서 사용되는 알고리즘들이 나오기 시작
    //직접호출이 불가능
    //똑같이 만들어서 사용할수는 있는데
    //어디까지 올라가야할지...Object까지 갈수도 있을듯
    
    //배열의크기, 범위시작인덱스, 범위끝인덱스
    static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
        	//끝인덱스가 시작인덱스보다 작으면 
            throw new IllegalArgumentException(
                "fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }//논리오류 에러처리 인덱스의 범위가 잘못됨
        if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        }//배열의 인덱스는 음수가 될수 없으므로 유효한범위가 아니면 예외처리
        if (toIndex > arrayLength) {
            throw new ArrayIndexOutOfBoundsException(toIndex);
        }//배열의 길이다보 검증하려는 범위가 크면 예외처리
    }
    
    
    public static void fill(long[] a, long val) {
        for (int i = 0, len = a.length; i < len; i++)
            a[i] = val;
    }

    public static void fill(long[] a, int fromIndex, int toIndex, long val) {
        rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;
    }

    public static void fill(int[] a, int val) {
        for (int i = 0, len = a.length; i < len; i++)
            a[i] = val;
    }

    public static void fill(int[] a, int fromIndex, int toIndex, int val) {
        rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;
    }

    public static void fill(short[] a, short val) {
        for (int i = 0, len = a.length; i < len; i++)
            a[i] = val;
    }

    public static void fill(short[] a, int fromIndex, int toIndex, short val) {
        rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;
    }

    public static void fill(char[] a, char val) {
        for (int i = 0, len = a.length; i < len; i++)
            a[i] = val;
    }

    public static void fill(char[] a, int fromIndex, int toIndex, char val) {
        rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;
    }

    public static void fill(byte[] a, byte val) {
        for (int i = 0, len = a.length; i < len; i++)
            a[i] = val;
    }

    public static void fill(byte[] a, int fromIndex, int toIndex, byte val) {
        rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;
    }

    public static void fill(boolean[] a, boolean val) {
        for (int i = 0, len = a.length; i < len; i++)
            a[i] = val;
    }

    public static void fill(boolean[] a, int fromIndex, int toIndex,
                            boolean val) {
        rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;
    }

    public static void fill(double[] a, double val) {
        for (int i = 0, len = a.length; i < len; i++)
            a[i] = val;
    }

    public static void fill(double[] a, int fromIndex, int toIndex,double val){
        rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;
    }

    public static void fill(float[] a, float val) {
        for (int i = 0, len = a.length; i < len; i++)
            a[i] = val;
    }

    public static void fill(float[] a, int fromIndex, int toIndex, float val) {
        rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;
    }

    public static void fill(Object[] a, Object val) {
        for (int i = 0, len = a.length; i < len; i++)
            a[i] = val;
    }

    public static void fill(Object[] a, int fromIndex, int toIndex, Object val) {
        rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;
    }
}


