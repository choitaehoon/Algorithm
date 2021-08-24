package 문자열;

import java.io.*;

public class 문자열폭팔 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] s = buffer.readLine().toCharArray();
        char[] t = buffer.readLine().toCharArray();
        char[] compare = new char[s.length];

        int index = 0;
        for (int i = 0; i < s.length; ++i) {
            compare[index++] = s[i];

            if (index - t.length >= 0 && isCheck(index - t.length, compare, t)) {
                index -= t.length;
            }
        }

        if (index == 0) {
            System.out.println("FRULA");
        } else {
            for (int i = 0; i < index; ++i) {
                writer.write(compare[i]);
            }

            writer.close();
        }

    }

    private static boolean isCheck(int start, char[] compare, char[] t) {

        for (int i = start, k = 0; i < start + t.length; ++i, ++k) {
            if (compare[i] != t[k])
                return false;
        }

        return true;
    }

}
