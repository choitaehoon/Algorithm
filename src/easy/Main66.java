package easy;

import java.math.BigInteger;
import java.util.Arrays;

public class Main66 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(
                new int[]{9, 8, 7 ,6, 5, 4, 3, 2, 1, 0}
        )));
    }

    public static int[] plusOne(int[] digits) {
        StringBuilder builder = new StringBuilder();
        for (int value : digits)
            builder.append(value);

        BigInteger bigInteger = new BigInteger(builder.toString());
        bigInteger = bigInteger.add(new BigInteger(String.valueOf(1)));
        String resultBigInteger = bigInteger.toString();
        int resultBigIntegerLen = resultBigInteger.length();
        int[] result = new int[resultBigIntegerLen];

        for (int i = 0; i < resultBigIntegerLen; ++i)
            result[i] = Integer.parseInt(String.valueOf(resultBigInteger.charAt(i)));

        return result;
    }

}
