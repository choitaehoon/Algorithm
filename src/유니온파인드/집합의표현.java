package 유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의표현 {

    static int[] setNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        setNumber = new int[n + 1];

        for (int i = 1; i <= n; ++i)
            setNumber[i] = i;

        for (int i = 0; i < m; ++i) {
            StringTokenizer givenToken = new StringTokenizer(buffer.readLine());
            int distinguishOneOrZero = Integer.parseInt(givenToken.nextToken());
            int a = Integer.parseInt(givenToken.nextToken());
            int b = Integer.parseInt(givenToken.nextToken());

            if (distinguishOneOrZero == 0) {
                union(a, b);
            } else {
                isSameParent(a, b);
            }
        }

    }

    private static void isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b)
            setNumber[b] = a;
    }

    private static int find(int x) {
        if (x == setNumber[x])
            return x;
        else
            return setNumber[x] = find(setNumber[x]);
    }

}
