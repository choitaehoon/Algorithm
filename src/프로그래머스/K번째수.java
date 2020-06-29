package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class K번째수 {

    public static void main(String[] args) {

    }

    public static int[] solution(int[] array, int[][] commands) {

        int len = commands.length;
        int[] result = new int[commands.length];

        for (int i = 0; i < len; ++i) {
            int[] commandRangeStore = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(commandRangeStore);
            result[i] = commandRangeStore[commands[i][2] - 1];
        }


        return result;
    }
}
