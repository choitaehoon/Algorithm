package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());

        int count = 0;
        while (n > 0) {
            if (n % 5 == 0) {
                count += (n / 5);
                n %= 5;
            } else {
                count++;
                n -= 3;
            }
        }

        System.out.println(n < 0 ? -1 : count);
    }

}
