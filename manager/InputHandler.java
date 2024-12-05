package basic.algorithm2.manager;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.Scanner;

public class InputHandler {
    private final ExceptionNumber exceptionNumber;

    public InputHandler() {
        this.exceptionNumber = new ExceptionNumber();
    }

    public int getIntegerInput(Scanner scanner) {
        return exceptionNumber.getIntegerInput(scanner); // 입력과 예외처리 위임
    }
    public String getStringInput(Scanner scanner) {
    	return exceptionNumber.getStringInput(scanner);
    }
}
