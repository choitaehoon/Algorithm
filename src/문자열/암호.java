package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호 {

    static char[] keyword;
    static char[] key;

    public static void main(String[] args) throws IOException {
        inputKeyAndKeyword();
        actionGo();
    }

    private static void inputKeyAndKeyword() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        keyword = buffer.readLine().toCharArray();
        key = buffer.readLine().toCharArray();
    }

    private static void actionGo() {
        StringBuilder builder = new StringBuilder();
        int len = Math.max(key.length, keyword.length);

        for (int i=0; i<len; ++i) {
            int alphabet = key[i%key.length] - 'a' + 1;

            if (i >= keyword.length)
                builder.append(" ");
            else if (keyword[i] == ' ')
                builder.append(" ");
            else if (keyword[i] - alphabet >= 97)
                builder.append((char)(keyword[i] - alphabet));
            else {
                builder.append((char)(keyword[i] - alphabet + 26));
            }
        }

        System.out.println(builder);
    }
}
