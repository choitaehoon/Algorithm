package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 경로찾기 {

    private static int givenNumber;
    private static int[][] array;
    private static boolean[] check;
    private static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());
        array = new int[givenNumber][givenNumber];
        check = new boolean[givenNumber];
        result = new int[givenNumber][givenNumber];

        //배열 삽입
        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            for (int j=0; j<givenNumber; ++j)
                array[i][j] = Integer.parseInt(token.nextToken());
        }

        //dfs
        for (int i=0; i<givenNumber; ++i) {
            dfs(i);

            for (int j=0; j<givenNumber; ++j)
                if (check[j]){
                    result[i][j] = 1;
                }

            makeFalseCheck();
        }

        print();
    }

    private static void dfs(int x) {
        for (int i=0; i<givenNumber; ++i){
            if (!check[i] && array[x][i] == 1) {
                check[i] = true;
                dfs(i);
            }
        }
    }

    private static void makeFalseCheck(){
        for (int i=0; i<givenNumber; ++i)
            check[i] = false;
    }

    private static void print(){
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<givenNumber; ++i) {
            for (int j=0; j<givenNumber; ++j)
                builder.append(result[i][j]).append(" ");
            builder.append("\n");
        }

        System.out.println(builder);
    }

}
