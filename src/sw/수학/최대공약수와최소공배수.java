package sw.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 최대공약수와최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int r = 0;

        int aMove = a;
        int bMove = b;

        while (bMove != 0) {
            if (aMove < bMove) {
                aMove ^= bMove;
                bMove ^= aMove;
                aMove ^= bMove;
            }

            r = aMove%bMove;
            aMove = bMove;
            bMove = r;
        }

        System.out.println(aMove);
        System.out.println((a*b)/aMove);
    }
}
