package 미해결문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈옥 {

    static int min = Integer.MAX_VALUE;
    static Queue<PointerLocation> queue = new LinkedList<>();
    static String[][] array;
    static int[][] sumArray;
    static int[] xMove = {-1,1,0,0};
    static int[] yMove = {0,0,-1,1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            n = Integer.parseInt(token.nextToken());
            m =Integer.parseInt(token.nextToken());
            array = new String[n][m];
            sumArray = new int[n][m];

            for (int a=0; a<n; ++a) {
                String[] store = buffer.readLine().split("");
                for (int b=0; b<m; ++b) {
                    if (( (a == 0 || a == n-1 || b == 0 || b == m-1 ) && (store[b].equals("#") || store[b].equals(".")))) {
                        queue.offer(new PointerLocation(a,b));
                    }
                    array[a][b] = store[b];
                }
            }

            while (!queue.isEmpty()) {
                PointerLocation pointerLocation = queue.poll();
                dfs(pointerLocation.x, pointerLocation.y, 0,0);
            }
        }


    }

    static void dfs(int x, int y, int sum, int prisoner) {
        if (prisoner == 2) {
            min = Math.min(min,sum);
            return;
        }

        for (int i=0; i<4; ++i) {
            int xGo = x + xMove[i];
            int yGo = y + yMove[i];

            if (xGo < 0 || xGo >=n || yGo < 0 || yGo >= m  || array[xGo][yGo].equals("*"))
                continue;

            if (array[xGo][yGo].equals("#"))
                dfs(xGo,yGo,sum+1,0);
            else if (array[xGo][yGo].equals("$"))
                dfs(xGo,yGo,sum,prisoner+1);
            else if (array[xGo][yGo].equals("."))
                dfs(xGo,yGo,sum,prisoner);

        }

    }

}

class Pointer{
    int x;
    int y;

    public Pointer(int x, int y){
        this.x = x;
        this.y = y;
    }
}