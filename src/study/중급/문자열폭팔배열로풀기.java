package study.중급;

import java.io.*;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class 문자열폭팔배열로풀기 {

    static char[] keword;
    static char[] compare;
    static char[] store;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        keword = buffer.readLine().toCharArray();
        compare = buffer.readLine().toCharArray();
        store = new char[1000001];

        int kewordLength = keword.length;
        int compareLength = compare.length;

        int pos = 0;
        for (int i=0; i<kewordLength; ++i) {
            store[pos++] = keword[i];

            if (pos - compareLength >=0 && isMatch(pos - compareLength, compareLength))
                pos -= compareLength;
        }

        if (pos == 0)
            System.out.println("FRULA");
        else {
            for (int i=0; i<pos; ++i)
                writer.write(store[i]);
            writer.close();
        }
    }

    static boolean isMatch(int start, int compareLength) {
        int compareIndex = 0;

        for (int i=start; i<start+compareLength; ++i)
            if (store[i] != compare[compareIndex++])
                return false;

            return true;
    }
}
