package solve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 주식가격 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new int[]{1, 2, 3, 2, 3}
        )));
    }

    public static int[] solution(int[] prices) {
        int[] answer;
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<prices.length; ++i) {
            int sum = 0;
            for (int j=i+1; j<prices.length; ++j)
                if (prices[i] <= prices[j])
                    ++sum;
                else {
                    ++sum;
                    break;
                }
            list.add(sum);
        }

        answer = new int[list.size()];

        for (int i=0; i<answer.length; ++i)
            answer[i] = list.get(i);

        return answer;
    }
}
