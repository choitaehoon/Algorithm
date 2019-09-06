package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 빙산 {

    static int xTemp;
    static int yTemp;
    static int[][] array;
    static int[] xCheck = {-1,1,0,0};
    static int[] yCheck = {0,0,-1,1};
    static boolean[][] checkIce;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        xTemp = Integer.parseInt(token.nextToken());
        yTemp = Integer.parseInt(token.nextToken());
        array = new int[xTemp][yTemp];
        checkIce = new boolean[xTemp][yTemp];

        //배열 삽입
        for (int i = 0; i< xTemp; ++i){
            StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
            for (int j = 0; j< yTemp; ++j)
                array[i][j] = Integer.parseInt(tokenizer.nextToken());
        }

        int cnt = 0;
        while (true){
            ++cnt;
            makeTrue();
            checkReduceIce();
            makeFalseCheck();

            if (allRun() && separateTwoLumps() == 0){
                System.out.println(0);
                makeFalseCheck();
                return;
            }

            if (separateTwoLumps() == 1 ) {
                makeFalseCheck();
                continue;
            }

            break;
        }

        System.out.println(cnt);
    }


    //허용 할 수 있는 칸만 채우기
    private static void makeTrue(){
        for (int i = 0; i< xTemp; ++i)
            for (int j = 0; j< yTemp; ++j)
                if (array[i][j] != 0)
                    checkIce[i][j] = true;
    }

    //일년 마다 빙산의 높이는지 체크하는 메서드
    private static void checkReduceIce(){
        for (int i = 0; i< xTemp; ++i)
            for (int j = 0; j< yTemp; ++j)
                if (checkIce[i][j]) {
                    minusIce(i,j);
                }
    }

    //일년 마다 빙산의 높이 줄이는 메서드
    private static void minusIce(int x, int y){

        for (int i=0; i<4; ++i){
            int xGo = x + xCheck[i];
            int yGo = y + yCheck[i];

            if (array[xGo][yGo] != 0 || checkIce[xGo][yGo])
                continue;

            if (array[x][y] > 0)
                array[x][y]--;
        }
    }

    //두 덩어리가 분리 되는지 체크하는 메소드 -> count 가 1이면 분리 안됨
    private static int separateTwoLumps(){
        int count = 0;

        for (int i = 0; i< xTemp; ++i)
            for (int j = 0; j< yTemp; ++j)
                if (!checkIce[i][j] && array[i][j] > 0) {
                    ++count;
                    dfs(i,j);
                }

        return count;
    }

    //탐색하는 메소드
    private static void dfs(int x, int y) {
        checkIce[x][y] = true;

        for (int i=0; i<4; ++i){
            int xGo = x + xCheck[i];
            int yGo = y + yCheck[i];

            if (xGo >= xTemp || xGo <= 0 || yGo >= yTemp || yGo <= 0 || checkIce[xGo][yGo] || array[xGo][yGo] == 0)
                continue;

            dfs(xGo,yGo);
        }
    }

    //false 로  만들기
    private static void makeFalseCheck(){
        for (int i = 0; i< xTemp; ++i)
            for (int j = 0; j< yTemp; ++j)
                checkIce[i][j] = false;
    }

    //얼음이 전부 녹았는지 확인
    private static boolean allRun(){
        for (int i=0; i<xTemp; ++i)
            for (int j=0; j<yTemp; ++j)
                if (array[i][j] != 0)
                    return false;
        return true;
    }

}