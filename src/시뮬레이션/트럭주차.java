package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트럭주차 {

    static int[] map = new int[101];
    static int a, b, c;

    public static void main(String[] args) throws IOException {
        inputMapAndABC();
        actionCost();
    }

    private static void inputMapAndABC() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        a = Integer.parseInt(token.nextToken());
        b = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());

        for (int i=0; i<3; ++i) {
            StringTokenizer input =
                    new StringTokenizer(buffer.readLine());
            int start = Integer.parseInt(input.nextToken());
            int end = Integer.parseInt(input.nextToken());

            actionSum(start-1, end-1);
        }

    }

    private static void actionSum(int start, int end) {
        for (int i = start; i < end; ++i)
            map[i]++;
    }

    private static void actionCost() {
        int sum = 0;

        for (int i=0; i<101; ++i) {
            if (map[i] == 1) {
                sum += map[i] * a;
            } else if (map[i] == 2) {
                sum += map[i] * b;
            } else if (map[i] == 3) {
                sum += map[i] * c;
            }
        }

        System.out.println(sum);
    }

}
