package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도영이가만든맛있는음식 {

    static int givenNumber;
    static int[][] value;
    static boolean[][] check;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());
        value = new int[2][givenNumber];
        check = new boolean[2][givenNumber];

        //배열 삽입
        for (int i=0; i<givenNumber; ++i)
            insertValue(i, buffer.readLine());

        //재귀로 최소값 구하기
        taste(0,1,0);

        System.out.println(min);
    }

    //쓴 맛 재귀 함수
    private static void taste(int index, long bitter, long sour){

        if (index >= 1){
            min = Math.min(min,Math.abs(bitter - sour));
        }

        if (index >= givenNumber)
            return;

        for (int i=index; i<givenNumber; ++i)
            if (!check[0][i] && !check[1][i]){
                check[1][i] = true;
                check[0][i] = true;
                taste(index+1,bitter*value[0][i], sour+value[1][i]);
                check[1][i] = false;
                check[0][i] = false;
            }
    }

    //배열 삽입
    private static void insertValue(int index, String readLine) {
        StringTokenizer token = new StringTokenizer(readLine);
        for (int i=0; i<2; ++i)
            value[i][index] = Integer.parseInt(token.nextToken());
    }


}
