package 프로그래머스;

import java.util.*;

public class 가장먼노드 {

    public static void main(String[] args) {
        System.out.println(solution(
                6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}
        ));
    }

    public static int solution(int n, int[][] edge) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] isCheck = new boolean[n + 1];
        boolean[][] newInt = new boolean[n + 1][n + 1];

        for (int i = 0; i < edge.length; ++i) {
            newInt[edge[i][0]][edge[i][1]] = true;
            newInt[edge[i][1]][edge[i][0]] = true;
        }

        isCheck[0] = true;
        isCheck[1] = true;
        queue.add(1);

        int count;
        List<Integer> node = new ArrayList<>();
        while (true) {
            count = queue.size();
            while (!queue.isEmpty()) {
                int num = queue.poll();

                for (int i=1; i <= n; ++i) {
                    if (!isCheck[i] && newInt[num][i]) {
                        isCheck[i] = true;
                        node.add(i);
                    }
                }
            }

            if (node.isEmpty())
                break;

            queue.addAll(node);
            node.clear();
        }

        return count;
    }

}
