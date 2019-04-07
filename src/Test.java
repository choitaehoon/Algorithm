import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        String temp = "()(((()())(())()))(())";
        System.out.println(solution(temp));
    }

    public static int solution(String arrangement) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i=0; i<arrangement.length(); ++i) {
            if (arrangement.charAt(i) == '(') {
                stack.push(i);
            }

            else if (i-stack.peek() == 1) {
                stack.pop();
                result += stack.size();
            }

            else {
                stack.pop();
                result += 1;
            }

        }
        return result;
    }
}
