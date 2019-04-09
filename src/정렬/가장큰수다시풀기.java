package 정렬;

import java.util.Arrays;

public class 가장큰수다시풀기 {
    public static void main(String[] args) {
        int[] numbers = {0,0,0,2,0,0,0};
//        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        String[] strings = new String[numbers.length];
        for (int i=0; i<strings.length; ++i)
            strings[i] = String.valueOf(numbers[i]);

        Arrays.sort(strings, (a,b) -> (b+a).compareTo(a+b));

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<strings.length; ++i)
            builder.append(strings[i]);

        return builder.toString();
    }
}
