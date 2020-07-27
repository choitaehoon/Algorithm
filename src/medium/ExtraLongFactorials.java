package medium;

import java.math.BigInteger;

public class ExtraLongFactorials {

    public static void main(String[] args) {
        extraLongFactorials(
                25
        );
    }

    static void extraLongFactorials(int n) {
        BigInteger bigInteger = new BigInteger(String.valueOf(1));

        while (n != 0)
            bigInteger = bigInteger.multiply(BigInteger.valueOf(n--));

        System.out.println(bigInteger);
    }

}
