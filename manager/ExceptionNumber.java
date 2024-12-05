package basic.algorithm2.manager;

import java.util.Scanner;

public class ExceptionNumber {
	
	public int getIntegerInput(Scanner scanner) {
		
		return getIntegerInput_2(scanner);
	}

	public int getIntegerInput_2(Scanner scanner) {

		int input = -1;
		boolean validInput = false;
		while (!validInput) {
			try {
				input = Integer.parseInt(scanner.nextLine()); // 정수로 변환
				validInput = true; // 정수가 입력되면 유효한 입력으로 처리
			} catch (NumberFormatException e) {
				System.out.println("@@@@@@@@@@@@@@@@@@@@.");
				System.out.println("    정수를 입력하세요.");
				System.out.println("@@@@@@@@@@@@@@@@@@@@.");
			}
		}
		return input;
	}

	public String getStringInput(Scanner scanner) {
		// TODO Auto-generated method stub
		String input = "";
		boolean validInput = false;
		
		while (!validInput) {
			try {
				input = scanner.nextLine(); // 사용자 입력 받기
	            if (input.trim().isEmpty()) { // 빈 입력 처리
	                throw new IllegalArgumentException("빈 입력은 허용되지 않습니다.");
	            }
	            validInput = true; // 유효한 입력으로 처리
			} catch (NumberFormatException e) {
				System.out.println("@@@@@@@@@@@@@@@@@@@@.");
				System.out.println("    문자를 입력하세요.");
				System.out.println("@@@@@@@@@@@@@@@@@@@@.");
			}
		}
		return input;
	}
}
