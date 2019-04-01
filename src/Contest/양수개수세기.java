package Contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 양수개수세기 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int end = token.countTokens();
        int sum = 0;

        for (int i=0; i<end; ++i)
            if (Integer.parseInt(token.nextToken()) > 0)
                ++sum;

        System.out.println(sum);
    }
}
