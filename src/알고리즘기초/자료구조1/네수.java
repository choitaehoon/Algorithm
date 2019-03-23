package 알고리즘기초.자료구조1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 네수 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        String aTemp = "";
        String bTemp = "";

        for (int i=0; i<4; ++i) {
            if (i <= 1) {
                aTemp += token.nextToken();
                continue;
            }

            bTemp += token.nextToken();
        }

        System.out.println(Long.parseLong(aTemp) + Long.parseLong(bTemp));
    }
}
