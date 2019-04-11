package 깊이너비우선탐색;

import java.util.Arrays;

public class 단어변환 {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = { "dot", "hot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean check = false;

        for (int i=0; i<words.length; ++i)
            if (words[i].contains(target))
                check = true;

        if (!check)
            return 0;

        for (int i=0; i<words.length; ++i) {
            int sum = 0;
            for (int j=0; j<target.length(); ++j)
                if (words[i].charAt(j) == target.charAt(j))
                    ++sum;
            if (sum >= 2) {
                return i+2;
            }
        }



        return answer;
    }
}
