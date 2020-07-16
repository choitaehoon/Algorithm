package 스택;

import java.util.Stack;

public class Fish {

    public int solution(int[] A, int[] B) {
        int len = A.length;
        Stack<Integer> lowerRiver = new Stack<>();
        int count = 0;

        for (int i = 0; i < len; ++i) {
            if (B[i] == 1)
                lowerRiver.push(A[i]);
            else if (B[i] == 0){
                if (lowerRiver.isEmpty())
                    count++;
                else {
                    while (!lowerRiver.isEmpty()) {
                        if (A[i] > lowerRiver.peek()) {
                            lowerRiver.pop();
                            if (lowerRiver.isEmpty())
                                ++count;
                        }
                        else
                            break;
                    }
                }
            }
        }

        return count + lowerRiver.size();
    }
}
