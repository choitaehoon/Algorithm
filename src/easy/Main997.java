package easy;

import java.util.Arrays;

public class Main997 {

    public static void main(String[] args) {
        System.out.println(findJudge(
                4, new int[][]{{1,3}, {1,4}, {2, 3}, {2, 4}, {4,3}}
        ));
    }

    public static int findJudge(int N, int[][] trust) {
        if (trust.length == 0 && N == 1)
            return 1;
        else if (trust.length == 0 && N > 1)
            return -1;

        int[] trustPeople = new int[N + 1];
        boolean[] townJudgeCheck = new boolean[N + 1];
        Arrays.fill(trustPeople, N - 1);

        for (int[] trustNowPeople : trust) {
            trustPeople[trustNowPeople[1]]--;
            townJudgeCheck[trustNowPeople[0]] = true;
        }

        for (int i = 1; i < N + 1; ++i) {
            if (!townJudgeCheck[i] && trustPeople[i] == 0)
                return i;
        }

        return -1;
    }

}
