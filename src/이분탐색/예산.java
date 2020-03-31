package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 예산 {

    static int[] area;
    static long totalBudget;
    static int nowBudget;

    public static void main(String[] args) throws IOException {
        inputAreaAndTotalBudget();
        searchMaxBudget();
        System.out.println(nowBudget);
    }

    private static void inputAreaAndTotalBudget() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(buffer.readLine());
        area = new int[n];
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        for (int i=0; i<n; ++i)
            area[i] = Integer.parseInt(token.nextToken());

        Arrays.sort(area);

        totalBudget = Integer.parseInt(buffer.readLine());
    }

    private static void searchMaxBudget() {
        int start = 0;
        int end = area[area.length-1];

        while (start <= end) {
            long sum = 0;
            int middle = (start + end) / 2;

            for (int value : area) {
                if (middle <= value) {
                    sum += middle;
                    continue;
                }

                sum += value;
            }

            if (totalBudget < sum) {
                end = middle - 1;
            } else {
                start = middle + 1;
                nowBudget = middle;
            }

        }

    }

}
