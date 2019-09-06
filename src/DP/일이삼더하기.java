package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이삼더하기 {

    static int[] array = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        array[0] = 0; array[1] = 1; array[2] = 2; array[3] = 4;

        for (int i=0; i<givenNumber; ++i) {
            int num = Integer.parseInt(buffer.readLine());
            System.out.println(recursive(num));
        }

    }

    private static int recursive(int calculator) {
        if (calculator == 0 || calculator == 1 || calculator == 2 || calculator == 3) return array[calculator];
        if (array[calculator] > 0) return array[calculator];
        return array[calculator] = recursive(calculator-3) + recursive(calculator-2) + recursive(calculator-1);
    }

}
