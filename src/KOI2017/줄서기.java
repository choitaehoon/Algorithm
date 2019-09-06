package KOI2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 줄서기 {

    static int[] card;
    static boolean[] check;
    static int people;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        people = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        card = new int[people];
        check = new boolean[people];

        for (int i=0; i<people; ++i)
            card[i] = i+1;

        for (int i=0; i<M; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
            cardRankCountUp(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
        }

        for (int i=0; i<people; ++i){
            if (isVisitNumber(i)) {
                System.out.println("-1");
                return;
            }
            check[card[i]-1] = true;
        }

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<people; ++i)
            builder.append(card[i]).append(" ");
        System.out.println(builder);
    }

    private static void cardRankCountUp(int up, int down){
        card[up-1]++;
        card[down-1]--;
    }

    // 3 1 4 5 2
    private static boolean isVisitNumber(int cardNumber){
        return card[cardNumber] < 1 || card[cardNumber] > people || check[card[cardNumber] - 1];
    }

}
