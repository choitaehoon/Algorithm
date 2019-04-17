package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간 초과 이유 확인 하기

public class 스타트와링크 {

    static int[][] givenArray;
    static int givenNumber;
    static int min = Integer.MAX_VALUE;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        givenNumber = Integer.parseInt(buffer.readLine());
        givenArray = new int[givenNumber+1][givenNumber+1];
        check = new boolean[givenNumber+1];

        for (int i=1; i<=givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            for (int j=1; j<=givenNumber; ++j)
                givenArray[i][j] = Integer.parseInt(token.nextToken());
        }

        combination(1,0);
        System.out.println(min);
    }

    public static void combination (int start, int depth) {
        if (depth == givenNumber/2) {
            min = Math.min(min, findMinimumOfCombinations() );
            return;
        }

        for (int i=start; i<=givenNumber; ++i) {
            if (!check[i]) {
                check[i] = true;
                combination(start+1, depth+1);
                check[i] = false;
            }
        }

    }

    public static int findMinimumOfCombinations() {
        int start = 0;
        int link = 0;

        for (int i=1; i<=givenNumber; ++i)
            for (int j=1; j<=givenNumber; ++j) {

                if (check[i] && check[j])
                    start += givenArray[i][j];

                if (!check[i] && !check[j])
                    link += givenArray[i][j];
            }

        return Math.abs(start - link);
    }
}
