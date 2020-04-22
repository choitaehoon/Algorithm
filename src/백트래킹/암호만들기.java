package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 암호만들기 {

    static int l;
    static int c;
    static String[] array;
    static List<String> list = new ArrayList<>();
    static boolean[] isCheck;

    public static void main(String[] args) throws IOException {
        inputLC();
        recursive(0, "", 0, 0, 0);
        Collections.sort(list);
        for (int i = 0; i < list.size(); ++i)
            System.out.println(list.get(i));
    }

    private static void inputLC() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        l = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());
        array = new String[c];
        isCheck = new boolean[c];

        StringTokenizer alphabet =
                new StringTokenizer(buffer.readLine());

        for (int i = 0; i < c; ++i) {
            array[i] = alphabet.nextToken();
        }

        Arrays.sort(array);
    }

    private static void recursive(int index, String temp, int minOne, int minTwo, int count) {
        if (count == l && minOne >= 1 && minTwo >= 2) {
            list.add(temp);
            return;
        }

        if (index >= c)
            return;

        if (array[index].equals("a") || array[index].equals("e") || array[index].equals("i") ||
                array[index].equals("o") || array[index].equals("u")) {
            recursive(index + 1, temp + array[index], minOne + 1, minTwo, count + 1);
        } else
            recursive(index + 1,ㅇ temp + array[index], minOne, minTwo + 1, count + 1);
        recursive(index + 1, temp, minOne, minTwo, count);
    }
}
