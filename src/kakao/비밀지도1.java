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

/* stream 변경 전
* 테스트 1 〉	통과 (20.19ms, 54.4MB)
테스트 2 〉	통과 (21.47ms, 54.7MB)
테스트 3 〉	통과 (18.10ms, 54.5MB)
테스트 4 〉	통과 (18.74ms, 54.2MB)
테스트 5 〉	통과 (19.38ms, 52.3MB)
테스트 6 〉	통과 (19.03ms, 54.5MB)
테스트 7 〉	통과 (18.84ms, 54MB)
테스트 8 〉	통과 (18.88ms, 54MB)
*
* -----
*
* stream 변경 후
* 테스트 1 〉	통과 (10.49ms, 52.8MB)
테스트 2 〉	통과 (11.84ms, 53.1MB)
테스트 3 〉	통과 (11.06ms, 51MB)
테스트 4 〉	통과 (11.72ms, 53.1MB)
테스트 5 〉	통과 (9.91ms, 51.6MB)
테스트 6 〉	통과 (11.27ms, 50.4MB)
테스트 7 〉	통과 (10.02ms, 50.8MB)
테스트 8 〉	통과 (8.87ms, 52.7MB)
* */