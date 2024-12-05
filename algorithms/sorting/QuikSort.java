package basic.algorithm2.algorithms.sorting;

import java.util.Arrays;

public class QuikSort {

	public class QuickSort {
	    public static void quickSort(int[] array, int low, int high) {
	        if (low < high) {
	            // 분할 작업
	            int pivotIndex = partition(array, low, high);
	            // 피벗 기준으로 왼쪽 정렬
	            quickSort(array, low, pivotIndex - 1);
	            // 피벗 기준으로 오른쪽 정렬
	            quickSort(array, pivotIndex + 1, high);
	        }
	    }

	    private static int partition(int[] array, int low, int high) {
	        int pivot = array[high]; // 피벗을 배열의 마지막 값으로 선택
	        int i = low - 1; // 작은 값의 인덱스
	        
	        for (int j = low; j < high; j++) {
	            if (array[j] < pivot) {
	                i++;
	                swap(array, i, j);
	            }
	        }
	        swap(array, i + 1, high); // 피벗을 제 위치로 이동
	        return i + 1;
	    }

	    private static void swap(int[] array, int i, int j) {
	        int temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	    }

	    public static void main(String[] args) {
	        int[] numbers = {8, 3, 5, 2, 7, 4};
	        quickSort(numbers, 0, numbers.length - 1);
	        System.out.println(Arrays.toString(numbers)); // 출력: [2, 3, 4, 5, 7, 8]
	    }
	}

}
