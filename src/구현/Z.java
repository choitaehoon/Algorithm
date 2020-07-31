package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {

    static int N;
    static int R;
    static int C;
    static int count;
    static boolean isCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        N = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        searchZ((int)Math.pow(2, N), 0, 0);
        System.out.println(count - 1);
    }

    private static void searchZ(int n, int r, int c) {
        if (isCheck)
            return;

        if (n == 2) {

            if (r == R && c == C) {
                count++;
                isCheck = true;
                return;
            }

            count++;
            if (r == R && c + 1 == C) {
                count++;
                isCheck = true;
                return;
            }

            count++;
            if (r + 1 == R && c == C) {
                count++;
                isCheck = true;
                return;
            }

            count++;
            if (r + 1 == R && c + 1 == C) {
                count++;
                isCheck = true;
                return;
            }

            count++;
            return;
        }

        searchZ(n / 2, r, c);
        searchZ(n / 2, r, c + n / 2);
        searchZ(n / 2, r + n / 2, c);
        searchZ(n / 2, r + n / 2, c + n / 2);
    }

}