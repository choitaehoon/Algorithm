package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 플로이드 {

    static int[][] distance;
    static int city;
    static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        city = Integer.parseInt(buffer.readLine());
        int bus = Integer.parseInt(buffer.readLine());

        distance = new int[city+1][city+1];

        for (int i = 1; i <= city; ++i)
            for (int j = 1; j <= city; ++j) {
                if (i == j) continue;
                distance[i][j] = INF;
            }

        for (int i = 0; i < bus; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            int cost = Integer.parseInt(token.nextToken());

            distance[from][to] = Math.min(distance[from][to], cost);
        }

        minCost();
        minPrint();
    }

    private static void minCost() {
        for (int k = 1; k <= city; ++k) {
            for (int i = 1; i <= city; ++i) {
                for (int j = 1; j <= city; ++j) {
                    System.out.println(distance[i][k] + distance[k][j]);
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
                }
            }
        }
    }

    private static void minPrint() {
        for (int i = 1; i <= city; ++i) {
            for (int j = 1; j <= city; ++j) {
                System.out.print(distance[i][j] == INF ? 0+" " : distance[i][j]+" ");
            }
            System.out.println();
        }
    }

}
