package kakao;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class 비밀지도1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{0, 0, 0, 0, 0}, new int[]{30, 1, 21, 17, 28})));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        AtomicInteger index = new AtomicInteger();
        String[] answer = new String[n];

        List<String> list = Arrays.stream(arr1)
                .mapToObj(word -> Integer.toBinaryString(word | arr2[index.getAndIncrement()]))
                .map(word -> zeroPlus(word, n))
                .map(비밀지도1::changeWord)
                .collect(Collectors.toList());

        for (int i=0; i<list.size(); ++i) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    private static String zeroPlus(String word, int n){
        StringBuilder builder = new StringBuilder(word);
        int len = n - word.length();
        for (int i=0; i<len; ++i)
            builder.insert(0, "0");

        return builder.toString();
    }

    private static String changeWord(String word)  {

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<word.length(); ++i) {
            if (word.charAt(i) == '1')
                builder.append("#");
            else
                builder.append(" ");
        }

        return builder.toString();
    }

}
