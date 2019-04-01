package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 줄세우기 {

    static int[] child = new int[1000001];
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        for (int i=1; i<=givenNumber; ++i) {
            int number = Integer.parseInt(token.nextToken());
            child[number] = child[number-1] +1;
            max = max < child[number] ? child[number] : max;
        }

        System.out.println(givenNumber - max);
    }
}
