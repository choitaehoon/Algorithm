package 알고리즘중급.자료구조2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
*  시간 복잡도 O(n) -> n 이 5천만 이니까 O(n^2) 불가 /  변수 범위 int -> 2^31 보다 작으니까
*  n만큼 반복
*  스택이 비어 있지 않고
*/

public class 오아시스재결합 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        Stack<Mate> stack = new Stack<>();
        long answer = 0;

        for (int i=0; i<givenNumber; ++i) {
            int number = Integer.parseInt(buffer.readLine());
            Mate mate = new Mate(number,1);
            while (!stack.isEmpty()) {
                if (stack.peek().height <= number) {
                    answer += stack.peek().compare;
                    if (stack.peek().height == number)
                        mate.compare += stack.peek().compare;
                    stack.pop();
                }
                else
                    break;

            }
            if (!stack.isEmpty()) answer +=1L;
            stack.push(mate);
        }

        System.out.println(answer);
    }
}

class Mate{
    int height;
    int compare;

    public Mate(int height, int compare) {
        this.height = height;
        this.compare = compare;
    }

}
