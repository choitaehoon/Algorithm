package 깊이너비우선탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스 {

    static int[][] connection;
    static boolean[] checkNumber;
    static int sum;
    static int givenNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());
        int computer = Integer.parseInt(buffer.readLine());
        connection = new int[givenNumber+1][givenNumber+1];
        checkNumber = new boolean[givenNumber+1];

        for (int i=0; i<computer; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            connection[x][y] = 1;
            connection[y][x] = 1;
        }

        dfs(1);
        if (sum >0)
            System.out.println(sum-1);
        else
            System.out.println(0);
    }

    public static void dfs(int index) {
        ++sum;
        checkNumber[index] = true;

        for (int i=1; i<=givenNumber; ++i)
            if (connection[index][i] == 1 && !checkNumber[i] && index != i)
                dfs(i);
    }

}
