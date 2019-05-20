package 알고리즘중급.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//다시 풀기
@SuppressWarnings("Duplicates")
public class 외판원순회2 {

    static int[][] array = new int[11][11];
    static boolean[] check = new boolean[11];
    static int givenNumber;
    static int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=1; i<=givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            for (int j=1; j<=givenNumber; ++j)
                array[i][j] = Integer.parseInt(token.nextToken());
        }

        check[1] = true;

    }

}
