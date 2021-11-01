package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평균은넘겠지 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < n; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int nowNumber = Integer.parseInt(token.nextToken());
            int[] array = new int[nowNumber];

            for (int k = 0; k < nowNumber; ++k)
                array[k] = Integer.parseInt(token.nextToken());

            double average = average(nowNumber, array);
            overAverage(average, nowNumber, array);
        }
    }

    private static double average(int nowNumber, int[] array) {
        int sum = 0;
        for (int i = 0; i < nowNumber; ++i) {
            sum += array[i];
        }

        return (sum * 1.0) / nowNumber;
    }

    private static void overAverage(double average, int nowNumber, int[] array) {
        int count = 0;
        for (int i = 0; i < nowNumber; ++i) {
            if (Double.compare(average, (array[i] * 1.0)) == -1)
                ++count;
        }

        double result = (count * 1.0) / nowNumber * 100;
        System.out.println(String.format("%.3f", result)+"%");
    }

}
