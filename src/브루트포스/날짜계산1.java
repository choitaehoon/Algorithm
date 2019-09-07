package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 날짜계산1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int E = Integer.parseInt(token.nextToken());
        int S = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        System.out.println(yearCalculate(E,S,M));
    }

    private static int yearCalculate(int e, int s, int m) {
        int value = 0;
        int eStart = 1;
        int sStart = 1;
        int mStart = 1;

        for (int i=1; i<7981; ++i){
            ++value;

            //입력값에 변수가 도달하면 멈추기
            if (eStart == e && sStart == s && mStart == m) {
                break;
            }

            eStart = (eStart+1)%16 == 0 ? 1 : (eStart+1)%16;
            sStart = (sStart+1)%29 == 0 ? 1 : (sStart+1)%29;
            mStart = (mStart+1)%20 == 0 ? 1 : (mStart+1)%20;
        }

        return value;
    }

}
