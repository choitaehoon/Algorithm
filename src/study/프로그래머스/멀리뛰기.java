package study.프로그래머스;

import java.util.Arrays;

public class 멀리뛰기 {

    static long [] array;

    public static void main(String[] args) {
        System.out.println(solution(1));
    }

    public static long solution(int n) {
        array = new long[n];

        if (n <= 2)
            return n;

        recursive(n);
        System.out.println(Arrays.toString(array));
        return array[n-1];
    }

    private static long recursive(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        else if (array[n - 1] > 0) return array[n - 1]; //memoization
        return array[n - 1] =  (recursive(n - 1) + recursive(n - 2)) % 1234567;
    }
}
