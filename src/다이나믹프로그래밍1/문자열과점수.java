package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열과점수 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());

        String one = " "+buffer.readLine();
        String two = " "+buffer.readLine();

        int[][] d = new int[one.length()][two.length()];

        for (int i=1; i<one.length(); ++i)
            d[i][0] = b*i;

        for (int i=1; i<two.length(); ++i)
            d[0][i] = b*i;

        for (int i=1; i<one.length(); ++i)
            for (int j=1; j<two.length(); ++j) {
                if (one.charAt(i) == two.charAt(j)) {
                    d[i][j] = d[i-1][j-1] + a;
                    continue;
                }

                d[i][j] = Math.max(d[i-1][j],d[i][j-1])+b;
                d[i][j] = Math.max(d[i][j], d[i-1][j-1]+c);
            }

        System.out.println(d[one.length()-1][two.length()-1]);
    }
}
