package basic.algorithm2.manager;

public class OutputHandler {

    private StringBuilder sb = new StringBuilder();
   
    public void append(Object object) {
        sb.append(object);
    }
    public void append(int num) {
        sb.append(num);
    }
    public void print() {
        System.out.print(sb.toString());
    }
    public void println() {
        System.out.println(sb.toString());
    }
    public void clear() {
        sb.setLength(0); // StringBuilder 초기화
    }
}
