import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 드래곤커브다시풀기 {

    static boolean[][] vertext = new boolean[100][100];
    static int[][] generation = new int[4][1024];
    static int[] moveX = {0,-1,0,1};
    static int[] moveY = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        //세대 저장하기
        insertGeneration();

        //방문 체크 하기
        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            int d = Integer.parseInt(token.nextToken());
            int g = Integer.parseInt(token.nextToken());
            vertext[x][y] = true;
            visitCheck(x,y,d,g);
        }

        //꼭지점 개수 구하기
        System.out.println(getVertextNumber());
    }

    //세대 저장 하기
    private static void insertGeneration() {
        generation[1][0] = 1;
        generation[2][0] = 2;
        generation[3][0] = 3;

        //방향 세대 순열
        for (int i=0; i<4; ++i)
            for (int j=1; j<11; ++j){
                int end = (int)(Math.pow(2,j));
                int half = end / 2;
                int minusIndex = 1;
                for (int z = half; z< end; ++z, minusIndex+=2)
                    generation[i][z] = (generation[i][z-minusIndex] + 1) % 4;
            }

    }

    //방문 체크 하기
    private static void visitCheck(int x, int y, int d, int g) {
        int end = (int)(Math.pow(2,g));

        //세대 만큼 돌기
        for (int i=0; i<end; ++i){
            int xGo = x + moveX[generation[d][i]];
            int yGo = y + moveY[generation[d][i]];

            if (xGo < 0 || xGo >= 100 || yGo < 0 || yGo >= 100)
                continue;

            vertext[xGo][yGo] = true;
        }

    }

    //꼭지점 개수 구하기
    private static int getVertextNumber() {
        int sum = 0;

        for (int i=0; i<99; ++i)
            for (int j=0; j<99; ++j)
                if (vertext[i][j] && vertext[i][j+1] && vertext[i+1][j] && vertext[i+1][j+1])
                    ++sum;

        return sum;
    }

}