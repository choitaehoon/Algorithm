package 알고리즘기초.다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로만들기 {

    public static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());
        array = new int[number+1];

        System.out.println(recursive(number));
    }

    public static int recursive(int n) {
        if (n == 1)
            return 0;

        if (0 < array[n])
            return array[n];

        array[n] = recursive(n-1)+1;

        if (n % 3 == 0)
            array[n] = Math.min(array[n], recursive(n/3)+1);

        else if (n % 2 == 0)
            array[n] = Math.min(array[n], recursive(n/2)+1);

        return array[n];
    }

}
