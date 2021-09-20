package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속부분최대곱 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        double[] array = new double[n];

        for (int i = 0; i < n; ++i) {
            array[i] = Double.parseDouble(buffer.readLine());
        }

        double result = 0;
        for (int i = 0; i < n; ++i) {
            double compare = 1;
            for (int k = i; k < n; ++k) {
                compare *= array[k];
                result = Math.max(result, compare);
            }
        }

        System.out.printf("%.3f%n", result);
    }

}
