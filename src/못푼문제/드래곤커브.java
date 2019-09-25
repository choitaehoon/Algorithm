package 못푼문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 드래곤커브 {

    static boolean[][] vertext = new boolean[100][100];
    static int[] moveX = {1,0,-1,0};
    static int[] moveY = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=0; i<givenNumber; ++i){
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            searchRotation(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
        }

        System.out.println(checkVertext());
    }

    //회전 할때 boolean 체크
    private static void searchRotation(int x, int y, int d, int generation) {
        int end = (int)(Math.pow(2,generation));
    }

    //네 꼭지점 탐색했는지 확인 메소드
    private static int checkVertext(){
        int sum = 0;

        for (int i=0; i<99; ++i)
            for (int j=0; j<99; ++j) {
                if (vertext[i][j] && vertext[i+1][j] && vertext[i][j+1] && vertext[i+1][j+1])
                    ++sum;
            }

        return sum;
    }

}
