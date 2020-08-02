package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 알약 {

    static long[][] word = new long[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber;

        for (long[] value : word)
            Arrays.fill(value, - 1);

        while (true) {
            givenNumber = Integer.parseInt(buffer.readLine());
            if (givenNumber == 0)
                break;
            System.out.println(pillIntake(givenNumber, 0));
        }

    }

    private static long pillIntake(int pill, int halfPill) {
        if (word[pill][halfPill] != -1) return word[pill][halfPill];
        if (pill == 0) return 1;
        if (halfPill == 0) return word[pill][halfPill] = pillIntake(pill - 1, halfPill + 1);

        return word[pill][halfPill] = pillIntake(pill - 1, halfPill + 1) + pillIntake(pill, halfPill - 1);
    }


}
