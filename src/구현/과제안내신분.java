package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 과제안내신분 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        boolean[] result = new boolean[31];

        for (int i = 0; i < 28; ++i)
            result[Integer.parseInt(buffer.readLine())] = true;

        for (int i = 1; i < 31; ++i)
            if (!result[i])
                System.out.println(i);
    }

}
