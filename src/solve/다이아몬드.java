package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//테케 점검 하기
public class 다이아몬드 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        if (givenNumber % 2 == 0) {
            evenNumber(givenNumber);
        } else {
            oddNumber(givenNumber);
        }
    }

    private static void oddNumber(int givenNumber) {

        int startLen = (givenNumber - 1) / 2;
        int endLen = (givenNumber - 1) / 2;
        StringBuilder builder = new StringBuilder();

        loop : for (int i = 0; i < givenNumber; ++i) {
            for (int k = 0; k <= endLen; ++k) {
                if (startLen <= k)
                    builder.append("*");
                else {
                    builder.append(" ");
                }
            }
            builder.append("\n");

            if ((givenNumber - 1) / 2 <= i ) {
                ++startLen;
                --endLen;
            } else {
                --startLen;
                ++endLen;
            }
        }

        System.out.println(builder);
    }

    private static void evenNumber(int givenNumber) {
        int startLen = givenNumber / 2;
        int endLen = givenNumber / 2;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < givenNumber / 2; ++i) {
            StringBuilder builder = new StringBuilder();
            for (int k = 0; k <= endLen; ++k) {
                if (startLen <= k)
                    builder.append("*");
                else
                    builder.append(" ");
            }
            result.add(builder.toString());

            --startLen;
            ++endLen;
        }

        for (String s : result)
            System.out.println(s);

        Collections.reverse(result);

        for (String s : result)
            System.out.println(s);
    }

}
