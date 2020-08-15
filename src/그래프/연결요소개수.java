package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연결요소개수 {

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        int[][] graph = new int[n + 1][n + 1];
        boolean[] isVisit = new boolean[n + 1];

        for (int i = 0; i < m; ++i) {
            StringTokenizer num = new StringTokenizer(buffer.readLine());
            int givenNumberA = Integer.parseInt(num.nextToken());
            int givenNumberB = Integer.parseInt(num.nextToken());

            graph[givenNumberA][givenNumberB] = 1;
            graph[givenNumberB][givenNumberA] = 1;
        }

        int count = 0;
        for (int i = 1; i <= n; ++i) {
            if (!isVisit[i]) {
                ++count;
                searchConnectLine(i, graph, isVisit);
            }
        }

        System.out.println(count);
    }

    private static void searchConnectLine(int index, int[][] graph, boolean[] isVisit) {
        isVisit[index] = true;

        for (int i = 1; i <= n; ++i) {
            if (!isVisit[i] && graph[index][i] == 1)
                searchConnectLine(i, graph, isVisit);
        }
    }

}
