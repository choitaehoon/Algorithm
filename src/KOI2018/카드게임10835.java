package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드게임10835 {

    public static int givenNumber;
    public static int[] leftCards;
    public static int[] rightCards;
    public static int[][] scoreMaximumCard;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());

        leftCards = new int[givenNumber+1];
        rightCards = new int[givenNumber+1];
        scoreMaximumCard = new int[givenNumber+1][givenNumber+1];

        StringTokenizer leftToken = new StringTokenizer(buffer.readLine());
        StringTokenizer rightToken = new StringTokenizer(buffer.readLine());

        for (int i=1; i<=givenNumber; ++i)
            leftCards[i] = Integer.parseInt(leftToken.nextToken());

        for (int i=1; i<=givenNumber; ++i)
            rightCards[i] = Integer.parseInt(rightToken.nextToken());

        for (int i=1; i<=givenNumber; ++i)
            for (int j=1; j<=givenNumber; ++j)
                scoreMaximumCard[i][j] = -1;

        System.out.println(compareCards(1,1));
    }

    public static int compareCards(int x, int y) {
        if (x == givenNumber+1 || y == givenNumber+1)
            return 0;

        //memoization
        if (scoreMaximumCard[x][y] != -1)
            return scoreMaximumCard[x][y];

        scoreMaximumCard[x][y] = Math.max(compareCards(x+1,y), compareCards(x+1,y+1));
        if (rightCards[y] < leftCards[x])
            scoreMaximumCard[x][y] = Math.max(scoreMaximumCard[x][y], compareCards(x,y+1)+rightCards[y]);

        return scoreMaximumCard[x][y];
    }

}
