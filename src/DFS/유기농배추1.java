package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 유기농배추1 {

    static int givenNumber;
    static int[] xMove = {-1,0,1,0};
    static int[] yMove = {0,1,0,-1};
    static boolean[][] check;
    static int[][] map;
    static int width;
    static int vertical;
    static int location;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        inputGivenNumber();
        printGo();
    }

    private static void inputGivenNumber() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token =
                    new StringTokenizer(buffer.readLine());
            width = Integer.parseInt(token.nextToken());
            vertical = Integer.parseInt(token.nextToken());
            location = Integer.parseInt(token.nextToken());

            check = new boolean[width][vertical];
            map = new int[width][vertical];

            for (int z=0; z<location; ++z) {
                StringTokenizer second =
                        new StringTokenizer(buffer.readLine());
                map[Integer.parseInt(second.nextToken())][Integer.parseInt(second.nextToken())] = 1;
            }

            actionMap();
        }
    }

    private static void actionMap() {
        int sum = 0;

        for (int i=0; i<width; ++i) {
            for (int z=0; z<vertical; ++z) {
                if (!check[i][z] && map[i][z] == 1) {
                    recursiveMap(i, z);
                    ++sum;
                }
            }
        }

        list.add(sum);
    }

    private static void recursiveMap(int wid, int ver) {
        check[wid][ver] = true;

        for (int i=0; i<4; ++i) {
            int xGo = wid + xMove[i];
            int yGo = ver + yMove[i];

            if (xGo < 0 || xGo >= width || yGo < 0 || yGo >=vertical || check[xGo][yGo] || map[xGo][yGo] == 0)
                continue;

            recursiveMap(xGo, yGo);
        }
    }

    private static void printGo() {
        for (int i=0; i<list.size(); ++i)
            System.out.println(list.get(i));
    }

}
