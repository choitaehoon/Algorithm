package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {

    static int n;
    static int c;
    static long[] location;
    static long wifi;

    public static void main(String[] args) throws IOException {
        inputNAndCAndLocation();
        searchWifi();
        System.out.println(wifi);
    }

    private static void inputNAndCAndLocation() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());
        location = new long[n];

        for (int i=0; i<n; ++i) {
            location[i] = Integer.parseInt(buffer.readLine());
        }

        Arrays.sort(location);
    }

    private static void searchWifi() {
        long start = 1;
        long end = location[n-1];

        while (start <= end) {
            long middle = (start+end) / 2;
            long startValue = location[0];
            int count = 1;

            for (int i=1; i<location.length; ++i) {
                if (middle <= location[i] - startValue) {
                    startValue = location[i];
                    ++count;
                }
            }

            if (count < c) {
                end = middle - 1;
            } else {
                start = middle + 1;
                wifi = middle;
            }
        }
    }
}
