package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 소음 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(buffer.readLine());
        String calculate = buffer.readLine();
        BigInteger b = new BigInteger(buffer.readLine());

        if (calculate.equals("+"))
            System.out.println(a.add(b));
        else
            System.out.println(a.multiply(b));
    }

}
