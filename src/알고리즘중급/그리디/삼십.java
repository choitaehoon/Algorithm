package 알고리즘중급.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("Duplicates")
public class 삼십 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = buffer.readLine().split("");

        int sum = 0;
        boolean check = false;
        for (int i=0; i<temp.length; ++i) {
            if (temp[i].equals("0"))
                check = true;
            sum += Integer.parseInt(temp[i]);
        }

        if (!check || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(temp, Comparator.reverseOrder());

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<temp.length; ++i)
            builder.append(temp[i]);

        System.out.println(builder);
    }
}
