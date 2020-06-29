package 프로그래머스;

import java.util.Arrays;

public class 가장큰수 {

    public static void main(String[] args) {

    }

    public static String solution(int[] numbers) {

        String[] storeNumbers = new String[numbers.length];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numbers.length; ++i)
            storeNumbers[i] = String.valueOf(numbers[i]);

        Arrays.sort(storeNumbers, (a1, a2) -> {
            return (a2.concat(a1)).compareTo(a1.concat(a2));
        });

        if (storeNumbers[0].equals("0"))
            return "0";

        for (int i = 0; i < numbers.length; ++i)
            result.append(storeNumbers[i]);

        return result.toString();
    }

}
