package basic.algorithm2.core;


import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import basic.algorithm2.algorithms.DigitSum;
import basic.algorithm2.algorithms.Fibonachi;
import basic.algorithm2.algorithms.GCDivisor;
import basic.algorithm2.algorithms.MaxAndMin;
import basic.algorithm2.algorithms.PerfectNum;
import basic.algorithm2.algorithms.Power;
import basic.algorithm2.algorithms.PrimeNum;
import basic.algorithm2.algorithms.Pyramid;
import basic.algorithm2.algorithms.ReverseNum;
import basic.algorithm2.algorithms.WhileSum;
import basic.algorithm2.algorithms.sorting.AscSort;
import basic.algorithm2.algorithms.sorting.DescSort;
import basic.algorithm2.algorithms.sorting.SelectionSort;
import basic.algorithm2.algorithms.sorting.SellSort;
import basic.algorithm2.manager.InputHandler;



public class MainAlgorithm2 {
	Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		InputHandler input = new InputHandler();
		AlgorithmManager manager = new AlgorithmManager();	
		 // ExecutorService를 이용해 하나의 스레드 풀을 생성하여 순차적으로 실행
		manager.addAlgorithms();        	
		
		while (true) {
			
			manager.displayMenu();
			int choice = input.getIntegerInput(scanner);

			if (choice == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			try {
				manager.executeAlgorithm(choice);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		scanner.close();
	}
}
