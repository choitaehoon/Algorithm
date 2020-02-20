package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS {

    static boolean[][] checkDot;
    static boolean[] bfs;
    static boolean[] check;
    static int n;
    static int m;
    static int startDot;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder dfsBuilder = new StringBuilder();
    static StringBuilder bfsBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        inputDfsAndBfs();
        actionDfs(startDot);
        actionBfs();
        System.out.println(dfsBuilder);
        System.out.println(bfsBuilder);
    }

    private static void inputDfsAndBfs() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        startDot = Integer.parseInt(token.nextToken());

        checkDot = new boolean[n+1][n+1];
        bfs = new boolean[n+1];
        check = new boolean[n+1];

        //checkDot
        for (int i=0; i<m; ++i) {
            StringTokenizer tokenizer =
                    new StringTokenizer(buffer.readLine());

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            checkDot[a][b] = true;
            checkDot[b][a] = true;
        }

        //bfs
        queue.offer(startDot);
        bfs[startDot] = true;
    }

    private static void actionDfs(int startDot) {
        check[startDot] = true;
        dfsBuilder.append(startDot).append(" ");

        for (int i=1; i<=n; ++i) {
            if (checkDot[startDot][i] && !check[i]) {
                actionDfs(i);
            }
        }
    }

    private static void actionBfs() {
        while (!queue.isEmpty()) {
            int dot = queue.poll();
            bfsBuilder.append(dot).append(" ");

            for (int i=1; i<=n; ++i)
               if (checkDot[dot][i] && !bfs[i]) {
                   queue.offer(i);
                   bfs[i] = true;
               }
        }
    }

}
