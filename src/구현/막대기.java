package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 막대기 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        int[] stick = new int[givenNumber];

        for (int i = 0; i < givenNumber; ++i)
            stick[i] = Integer.parseInt(buffer.readLine());

        int max = stick[givenNumber - 1];
        int count = 1;
        for (int i = givenNumber - 2; i >= 0; --i) {
            if (max < stick[i]) {
                ++count;
                max = stick[i];
            }
        }

        System.out.println(count);
    }

}
