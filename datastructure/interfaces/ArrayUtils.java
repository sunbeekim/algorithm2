package basic.algorithm2.datastructure.interfaces;

public interface ArrayUtils {
	
	<T> T[] copyOf(T[] original, int newLength);
	
	int[] copyOf(int[] original, int newLength);
	
	double[] copyOf(double[] original, int newLength);
	
	<T> boolean isEmpty(T[] array);
	
	Integer[] toIntegerArray(int[] original);
	
	Double[] toDoubleArray(double[] original);
	
}
