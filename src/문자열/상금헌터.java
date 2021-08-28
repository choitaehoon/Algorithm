package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상금헌터 {

    static int[] oneFestival = {1, 3, 6, 10, 15, 21};
    static int[] onePrice = {5_000_000, 3_000_000, 2_000_000, 500_000, 300_000, 100_000};

    static int[] twoFestival = {1, 3, 7, 15, 31};
    static int[] twoPrice = {5_120_000, 2_560_000, 1_280_000, 640_000, 320_000};

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < n; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int sum = 0;

            sum += one(a);
            sum += two(b);

            System.out.println(sum);
        }
    }

    private static int one(int a) {
        if (a == 0)
            return 0;

        if (a == 1) {
            return onePrice[0];
        }

        for (int i = 1; i < 6; ++i) {
            if (oneFestival[i - 1] < a  && a <= oneFestival[i]) {
                return onePrice[i];
            }
        }

        return 0;
    }

    private static int two(int b) {
        if (b == 0)
            return 0;

        if (b == 1) {
            return twoPrice[0];
        }

        for (int i = 1; i < 5; ++i) {
            if (twoFestival[i - 1] < b  && b <= twoFestival[i]) {
                return twoPrice[i];
            }
        }

        return 0;
    }
}
