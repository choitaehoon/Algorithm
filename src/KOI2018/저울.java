package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//다시 생각해보기
public class 저울 {

    public static int[][] array = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        int pairOfThings = Integer.parseInt(buffer.readLine());
        int sum;

        //무한대 값 삽입
        for (int i=1; i<=givenNumber; ++i)
            for (int j=1; j<=givenNumber; ++j)
                if (i != j)
                    array[i][j] = Integer.MAX_VALUE;

                //값이 있는 곳에 1 삽입
        for (int i=0; i<pairOfThings; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            array[x][y] = 1;
        }


        for (int i=1; i<=givenNumber; ++i)
            for (int j=1; j<=givenNumber; ++j)
                for (int k=1; k<=givenNumber; ++k)
                    if (array[j][k] > array[j][i] + array[i][k])
                        array[j][k] = array[j][i] + array[i][k];

        for (int i=0; i<givenNumber; ++i) {
            sum = 0;

            for (int j=0; j<givenNumber; ++j)
                if (array[i][j] == Integer.MAX_VALUE && array[j][i] == Integer.MAX_VALUE)
                    sum++;

                System.out.println(sum);
        }

    }
}
