package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수들의합2 {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        StringTokenizer pointerNumber = new StringTokenizer(buffer.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        int[] pointerArray = new int[N];
        for (int i = 0; i < N; ++i)
            pointerArray[i] = Integer.parseInt(pointerNumber.nextToken());

        numberSumCheck(pointerArray);
    }

    private static void numberSumCheck(int[] pointerArray) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        while (start < N) {

            if (sum >= M || end == N) {
                sum -= pointerArray[start++];
            } else
                sum += pointerArray[end++];

            if (sum == M)
                ++count;
        }

        System.out.println(count);
    }


}
