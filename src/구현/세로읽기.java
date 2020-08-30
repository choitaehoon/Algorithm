package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세로읽기 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[][] word = new String[5][15];
        int rowMax = 0;

        for (int i = 0; i < 5; ++i) {
            String[] token = buffer.readLine().split("");
            int tokenLen = token.length;
            rowMax = Math.max(rowMax, tokenLen);

            System.arraycopy(token, 0, word[i], 0, tokenLen);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rowMax; ++i) {
            for (int k = 0; k < 5; ++k) {
                String nowWord = word[k][i];
                if (nowWord != null) {
                    result.append(nowWord);
                }
            }
        }

        System.out.println(result);
    }

}
