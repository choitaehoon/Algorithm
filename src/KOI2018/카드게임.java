package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드게임 {

    public static int [] aCard = new int[10];
    public static int [] bCard = new int[10];
    public static int aRoundWin;
    public static int bRoundWin;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer aCardInput = new StringTokenizer(buffer.readLine());
        StringTokenizer bCardInput = new StringTokenizer(buffer.readLine());

        for (int i=0; i<10; ++i)
            aCard[i] = Integer.parseInt(aCardInput.nextToken());

        for (int i=0; i<10; ++i)
            bCard[i] = Integer.parseInt(bCardInput.nextToken());

        for (int i=0; i<10; ++i) {
            if (aCard[i] < bCard[i]) {
                bRoundWin++;
                continue;
            }
            if (aCard[i] > bCard[i]) {
                aRoundWin++;
                continue;
            }
        }

        if (aRoundWin < bRoundWin)
            System.out.println("B");
        else if (aRoundWin > bRoundWin)
            System.out.println("A");
        else
            System.out.println("D");
    }
}
