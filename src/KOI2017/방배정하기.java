package KOI2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방배정하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());
        int sum = Integer.parseInt(token.nextToken());

        boolean check = false;

        for (int i=0; i<=300; ++i)
            for (int j=0; j<=300; ++j)
                for (int k=0; k<=300; ++k)
                    if (a*i + b*j + c*k == sum) {
                        check = true;
                        break;
                    }

        System.out.println(check ? 1 : 0);
    }
}
