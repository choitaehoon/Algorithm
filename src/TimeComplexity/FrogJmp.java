package TimeComplexity;

public class FrogJmp {

    public static void main(String[] args) {
//        System.out.println(solution(10, 85, 30));
        System.out.println(solution(5, 105, 3));
    }

    public static int solution(int X, int Y, int D) {
        return (int)(Math.ceil((Y - X) / (double)D));
    }
}
