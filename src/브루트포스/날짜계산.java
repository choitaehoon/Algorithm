package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 날짜계산 {

    static int earthSum;
    static int sunSum;
    static int moonSum;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int earth = Integer.parseInt(token.nextToken());
        int sun = Integer.parseInt(token.nextToken());
        int moon = Integer.parseInt(token.nextToken());

        for (int i=0; i<Integer.MAX_VALUE; ++i) {
            if (earthSum == earth && sun == sunSum && moonSum == moon)
                break;
            else {
                ++total;
                earthSum = (earthSum%15)+1;
                sunSum = (sunSum%28)+1;
                moonSum = (moonSum%19)+1;
            }
        }

        System.out.println(total);
    }
}
