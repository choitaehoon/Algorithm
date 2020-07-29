package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 좋은수열 {

    static int givenNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());

        dfsNumber(1, "1");
    }

    private static void dfsNumber(int index, String word) {
        if (index == givenNumber) {
            System.out.println(word);
            System.exit(0);
        }

        for (int i = 1; i <= 3; ++i) {
            if (goodSequence(word + i)) {
                dfsNumber(index + 1, word + i);
            }
        }

    }

    private static boolean goodSequence(String str) {
        int s = str.length() - 1;
        int e = str.length();

        for(int i=1; i<=str.length()/2; i++, --s) {
            if(str.substring(s-i, e-i).equals(str.substring(s, e)))
                return false;
        }

        return true;
    }

}
