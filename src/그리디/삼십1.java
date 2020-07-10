package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

//테케 점검하기
public class 삼십1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] numberArray = buffer.readLine().split("");

        System.out.println(thirtyCheck(numberArray));
    }

    private static int thirtyCheck(String[] numberArray) {
        boolean isZero = false;
        int sum = 0;

        for (String s : numberArray) {
            if (s.equals("0"))
                isZero = true;
            sum += Integer.parseInt(s);
        }

        if (!isZero || sum % 3 != 0) {
            return -1;
        }

        Arrays.sort(numberArray, Comparator.reverseOrder());
        StringBuilder builder = new StringBuilder();
        for (String s : numberArray)
            builder.append(s);

        return Integer.parseInt(builder.toString());
    }

}