package 알고리즘중급.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 부분수열의합 {

    static int plus;
    static int n;
    static int s;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(token.nextToken());
        s = Integer.parseInt(token.nextToken());
        array = new int[n];

        StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
        for (int i=0; i<n; ++i)
            array[i] = Integer.parseInt(tokenizer.nextToken());

        recursive(0, 0);
        if (s == 0) plus--;
        System.out.println(plus);
    }

    static void recursive(int index, int sum) {
        if (index == n) {
            if (sum == s)
                ++plus;
            return;
        }

        recursive(index+1,sum + array[index]);
        recursive(index+1,sum);
    }

}
