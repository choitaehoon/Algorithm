package 알고리즘중급.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] minus = buffer.readLine().split("-");

        int result = 0;
        for (int i=0; i<minus.length; ++i) {

            int sum = 0;
            String[] plus = minus[i].split("\\+");

            for (int j=0; j<plus.length; ++j)
                sum += Integer.parseInt(plus[j]);

            if (i == 0) {
                result = sum;
                continue;
            }
            result -= sum;
        }

        System.out.println(result);
    }
}
