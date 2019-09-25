package 완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 외판원순회2 {

    static int givenCity;
    static int[][] cost;
    static boolean[] check;
    static int minExpense = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenCity = Integer.parseInt(buffer.readLine());
        cost = new int[givenCity][givenCity];
        check = new boolean[givenCity];

        //비용 입력
        for (int i=0; i<givenCity; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
            for (int j=0; j<givenCity; ++j)
                cost[i][j] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i=0; i<givenCity; ++i) {
            check[i] = true;
            minCost(i,0,1, i);
        }

        System.out.println(minExpense);
    }

    private static void minCost(int city, int expense, int cityVisitNumber, int start) {

        if (cityVisitNumber == givenCity && start == city){
            minExpense = Math.min(minExpense, expense);
            return;
        }

            for (int i=0; i<givenCity; ++i){
                if (cost[city][i] > 0 && !check[i]){
                    check[i] = true;
                    minCost(i,expense+cost[city][i], cityVisitNumber+1, start);
                    check[i] = false;
            }
        }

    }

}
