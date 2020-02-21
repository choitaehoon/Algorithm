package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열 {

    static String keywordA;
    static String keywordB;

    public static void main(String[] args) throws IOException {
        inputKeyword();
        actionKeyword();
    }

    private static void inputKeyword() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        keywordA = token.nextToken();
        keywordB = token.nextToken();

    }

    private static void actionKeyword() {
        int len = keywordB.length() - keywordA.length();
        int sum = Integer.MAX_VALUE;

        for (int i=0; i<=len; ++i) {
            int cnt = 0;

            for (int j=0; j<keywordA.length(); ++j) {
                if (keywordA.charAt(j) != keywordB.charAt(i+j)) {
                    cnt++;
                }
            }

            sum = Math.min(sum, cnt);
        }

        System.out.println(sum);
    }

}
