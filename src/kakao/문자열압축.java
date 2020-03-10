package kakao;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 문자열압축 {

    public static void main(String[] args) {
        System.out.println(solution2("aabbaccc"));
    }

    public static int solution2(String word) {
        if (word.length() == 1)
            return 1;

        int result = 1000;
        for (int i=1; i <= word.length()/2; ++i) {

            int correct = 1;
            String now = "";
            String next = "";
            StringBuilder builder = new StringBuilder();

            for (int z=0; z <= word.length() / i; ++z) {
                int start = i * z;
                int end = Math.min(start + i, word.length());
                now = next;
                next = word.substring(start, end);

                if (now.equals(next))
                    ++correct;
                else {
                    builder.append(
                            correct == 1 ? "" : correct
                    ).append(now);
                    correct = 1;
                }
            }

            builder.append(
                    correct == 1 ? "" : correct
            ).append(next);
            System.out.println(builder);
            result = Math.min(result, builder.length());
        }

        return result;
    }

    public static int solution(String word) {
        if (word.length() == 1)
            return 1;

        int result = Integer.MAX_VALUE;

        for (int i=1; i <= word.length()/2; ++i) {
            List<String> list = new ArrayList<>();

            for (int j=0; j<word.length(); j+=i){
                if (i + j <= word.length())
                    list.add(word.substring(j, j+i));
                else
                    list.add(word.substring(j));
            }

            Stack<String> stack = new Stack<>();
            int sumAll = 0;
            int index = 0;
            for (String s : list) {
                if (stack.isEmpty()) {
                    stack.push(s);
                    ++index;
                } else if (stack.peek().equals(s)) {
                    ++index;
                } else if (!stack.peek().equals(s)) {
                    if (index != 1) {
                        sumAll += String.valueOf(index).length();
                    }
                    sumAll += stack.remove(0).length();
                    stack.push(s);
                    index = 1;
                }
            }

            if (index != 1) {
                sumAll += String.valueOf(index).length();
            }

            while (!stack.isEmpty()) {
                sumAll += stack.pop().length();
            }

            result = Math.min(result, sumAll);
        }

        return result;
    }

}
