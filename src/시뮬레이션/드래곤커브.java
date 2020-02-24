package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 드래곤커브 {

    static boolean[][] isMap = new boolean[101][101];
    static int[][] generation = new int[4][1024];
    static int givenNumber;
    static int[] xMove = {1,0,-1,0};
    static int[] yMove = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        checkDragon();
        printGo();
    }

    private static void checkDragon() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());

        inputDragonGeneration();

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token =
                    new StringTokenizer(buffer.readLine());

            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            int d = Integer.parseInt(token.nextToken());
            int g = Integer.parseInt(token.nextToken());

            actionDragon(x,y,d,g);
        }

    }

    private static void actionDragon(int x, int y, int d, int g) {
        int xGo = x;
        int yGo = y;

        isMap[yGo][xGo] = true;

        //세대 만큼 이동
        for (int i=0; i<(int)Math.pow(2,g); ++i) {
            xGo = xGo + xMove[generation[d][i]];
            yGo = yGo + yMove[generation[d][i]];

            isMap[yGo][xGo] = true;
        }
    }

    private static void inputDragonGeneration() {

        generation[0][0] = 0;
        generation[1][0] = 1;
        generation[2][0] = 2;
        generation[3][0] = 3;

        for (int i=0; i<4; ++i) {
            for (int g=1; g<11; ++g) {
                int start = (int)Math.pow(2, g) / 2;
                int end = (int)(Math.pow(2, g));
                int otherWay = 1;

                for (; start < end; ++start) {
                    generation[i][start] = (generation[i][start - otherWay] + 1) % 4;
                    otherWay += 2;
                }
            }
        }
    }

    private static void printGo() {
        int sum = 0;

        for (int i=0; i<100; ++i) {
            for (int j=0; j<100; ++j) {
                if (isMap[i][j] && isMap[i][j+1] && isMap[i+1][j] && isMap[i+1][j+1])
                    ++sum;
            }
        }

        System.out.println(sum);
    }

}
