package 알고리즘기초.다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이삼더하기 {

    public static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());

        array = new int[11];
        array[0] = 0; array[1] = 1; array[2] = 2; array[3] = 4; array[4] = 7;

        for (int i=0; i<number; ++i)
            System.out.println( recursive(Integer.parseInt(buffer.readLine())) );

    }

    //1, 2, 3으로만
    public static int recursive(int n) {
        if (n == 0 || n == 1 || n == 2 || n == 3 || n == 4 ) return array[n];
        if (0 > array[n]) return array[n];
        array[n] = recursive(n-3) + recursive(n-2) + recursive(n - 1);
        return array[n];
    }

}
