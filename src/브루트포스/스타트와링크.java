package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 스타트와링크 {

    static int givenNumber;
    static int[][] array;
    static boolean[] check;
    static int min = Integer.MAX_VALUE;
    static int half;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());
        array = new int[givenNumber+1][givenNumber+1];
        check = new boolean[givenNumber+1];
        half = givenNumber / 2;

        //배열 삽입
        for (int i=1; i<=givenNumber; ++i)
            insertArray(i, buffer.readLine());

        //재귀로 팀 만들기
        makeTeam(1,0);

        //스타트와 링크팀 차이
        System.out.println(min);
    }

    //배열 삽입
    private static void insertArray(int index ,String text) {
        StringTokenizer token = new StringTokenizer(text);
        for (int j=1; j<=givenNumber; ++j)
            array[index][j] = Integer.parseInt(token.nextToken());
    }

    private static void makeTeam(int start,int depth) {
        if (depth == half) {
            difference();
            return;
        }

        for (int i=start; i<=givenNumber; ++i){
            if (!check[i]){
                check[i] = true;
                makeTeam(i+1,depth+1);
                check[i] = false;
            }
        }

    }

    //스타트와 링크팀 차이 계산
    private static int difference(){
        int start = 0;
        int link = 0;

        for (int i=1; i<=givenNumber; ++i)
            for (int j=1; j<=givenNumber; ++j) {
                //모두 체크 되어 있으면 스타트 팀
                if (check[i] && check[j])
                    start += array[i][j];
                //체크 되어 있지 않으면 링크 팀
                if (!check[i] && !check[j])
                    link += array[i][j];
            }

        return min = Math.min(min, Math.abs(start - link));
    }

}