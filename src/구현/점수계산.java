package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 점수계산 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int[] number = new int[8];
        int[] preNumber = new int[8];
        Map<Integer, Integer> numberMap = new HashMap<>();

        for (int i = 0; i < 8; ++i) {
            int num = Integer.parseInt(buffer.readLine());
            number[i] = num;
            preNumber[i] = num;
        }

        Arrays.sort(number);
        int totalSum = 0;
        for (int i = 3; i < 8; ++i) {
            totalSum += number[i];
            numberMap.put(number[i], i);
        }

        System.out.println(totalSum);
        for (int i = 0; i < 8; ++i) {
            if (numberMap.containsKey(preNumber[i])) {
                System.out.print((i+1)+" ");
            }
        }
    }

}
