package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        int k = Integer.parseInt(buffer.readLine());

        int start = 1;
        int end = k;
        int result = 0;

        while (start <= end) {
            int middle = (start+end)/2;
            int count = 0;

            for (int i=1; i<=givenNumber; ++i)
                count += Math.min(middle/i, givenNumber);

            if (count < k)
                start = middle + 1;
            else {
                result = middle;
                end = middle - 1;
            }
        }

        System.out.println(result);

    }
}
