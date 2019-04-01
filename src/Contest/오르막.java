package Contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오르막 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int[] array = new int[token.countTokens()];
        boolean check = true;

        for (int i=0; i<array.length; ++i)
            array[i] = Integer.parseInt(token.nextToken());

        for (int i=1; i<array.length; ++i)
            if (array[i-1] > array[i])
                check = false;

        System.out.println(check ? "Good" : "Bad");
    }
}
