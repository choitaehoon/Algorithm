package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 로또 {

    static List<String> list = new ArrayList<>();
    static int[] newInt;
    static int first;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));

        do {
            StringTokenizer token =
                    new StringTokenizer(buffer.readLine());
            first = Integer.parseInt(token.nextToken());
            newInt = new int[first];

            for (int i=0; i<first; ++i) {
                newInt[i] = Integer.parseInt(token.nextToken());
            }

            recursive(0, "" ,0);
            for (int i=0; i<list.size(); ++i)
                System.out.println(list.get(i).trim());

            System.out.println();
            list.clear();
        } while (first != 0);
    }

    private static void recursive(int index, String temp, int sum) {
        if (sum == 6) {
            list.add(temp);
            return;
        }

        if (index < first) {
            recursive(index + 1, temp+" "+newInt[index], sum + 1);
            recursive(index + 1, temp, sum);
        }
    }

}
