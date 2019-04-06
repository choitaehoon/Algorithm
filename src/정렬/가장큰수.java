package 정렬;

import java.util.Arrays;

public class 가장큰수 {
    public static void main(String[] args) {
        int [] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        String answer = "";
        String[] temp = new String[numbers.length];

        for (int i=0; i<temp.length; ++i)
            temp[i] = String.valueOf(numbers[i]);

        Arrays.sort(temp, (a,b) -> (b+a).compareTo(a+b));

        System.out.println(Arrays.toString(temp));

        if (temp[0].equals("0"))
            return "0";

        for (int i=0; i<temp.length; ++i)
             answer += temp[i];

        return answer;
    }
}
