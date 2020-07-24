package medium;

import java.util.*;

public class ClimbingTheLeaderboard {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(climbingLeaderboard(
                new int[]{100, 100, 50, 40, 40, 20, 10},
                new int[]{5, 25, 50, 120}
        )));
    }

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        Map<Integer, Integer> resultScores = new TreeMap<>(Collections.reverseOrder());
        TreeSet<Integer> treeSet =  new TreeSet<>();
        int rank = 1;

        for (int value : scores) {
            treeSet.add(value);
            if (!resultScores.containsKey(value))
                resultScores.put(value, rank++);
        }

        NavigableSet<Integer> navigableSet = treeSet.descendingSet();
        int[] result = new int[alice.length];
        int index = 0;

        for (int value : alice) {
            if (value > navigableSet.first())
                result[index++] = 1;
            else if (value < navigableSet.last())
                result[index++] = resultScores.size() + 1;
            else
                result[index++] = resultScores.get(navigableSet.ceiling(value));
        }

        return result;
    }
}
