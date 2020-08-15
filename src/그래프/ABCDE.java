package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ABCDE {

    static List<List<Integer>> persons = new ArrayList<>();
    static boolean endCircleCheck = false;
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int person = Integer.parseInt(token.nextToken());
        int friendNumber = Integer.parseInt(token.nextToken());
        isVisit = new boolean[person];

        for (int i = 0; i < person; ++i) {
            persons.add(new ArrayList<>());
        }

        for (int i = 0; i < friendNumber; ++i) {
            StringTokenizer line = new StringTokenizer(buffer.readLine());
            int friendsA = Integer.parseInt(line.nextToken());
            int friendsB = Integer.parseInt(line.nextToken());

            persons.get(friendsA).add(friendsB);
            persons.get(friendsB).add(friendsA);
        }

        for (int i = 0; i < person; ++i) {
            dfs(i, 0);
        }

        System.out.println(endCircleCheck ? 1 : 0);
    }

    private static void dfs(int index, int count) {
        isVisit[index] = true;

        if (endCircleCheck)
            return;

        if (count == 4) {
            endCircleCheck = true;
            return;
        }

        for (int i = 0; i < persons.get(index).size(); ++i) {
            if (!isVisit[persons.get(index).get(i)])
                dfs(persons.get(index).get(i), count + 1);
        }

        isVisit[index] = false;
    }


}
