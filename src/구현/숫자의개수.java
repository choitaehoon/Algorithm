package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int aNumber = Integer.parseInt(buffer.readLine());
        int bNumber = Integer.parseInt(buffer.readLine());
        int cNumber = Integer.parseInt(buffer.readLine());

        String result = String.valueOf(aNumber * bNumber * cNumber);

        int[] resultNew = new int[10];
        for (int i = 0 ; i < result.length(); ++i)
            resultNew[result.charAt(i) - '0'] ++;

        for (int value  : resultNew)
            System.out.println(value);
    }


}
