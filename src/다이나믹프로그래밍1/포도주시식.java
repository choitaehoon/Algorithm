package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        int[] wineAmount = new int[givenNumber];
        int[] wineCompare = new int[givenNumber];
        for (int i=0; i<givenNumber; ++i)
            wineAmount[i] = Integer.parseInt(buffer.readLine());

        if (1 <= givenNumber)
        wineCompare[0] = wineAmount[0];

        if (2 <= givenNumber)
        wineCompare[1] = wineAmount[1] + wineAmount[0];

        if (3 <= givenNumber)
        wineCompare[2] = Math.max(wineCompare[1], Math.max(wineAmount[2]+wineCompare[0], wineAmount[1] + wineAmount[2]));

        for (int i=3; i<givenNumber; ++i)
            wineCompare[i] = Math.max(wineCompare[i-1], Math.max(wineAmount[i] + wineCompare[i-2], wineAmount[i]+ wineAmount[i-1] + wineCompare[i-3]));

        System.out.println(wineCompare[givenNumber-1]);
    }
}
