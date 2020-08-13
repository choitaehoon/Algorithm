package medium;

import java.util.ArrayList;
import java.util.List;

public class Main1267 {

    public static void main(String[] args) {
        System.out.println(countServers(
                new int[][]{ {1, 0}, {1, 1}}
        ));
    }

    public static int countServers(int[][] grid) {
        int totalCount = 0;

        totalCount += serverCount(grid, grid.length, grid[0].length, "row");
        totalCount += serverCount(grid, grid[0].length, grid.length, "column");

        return totalCount;
    }

    private static int serverCount(int[][] grid, int m, int n, String direction) {
        int totalCount = 0;

        for (int i = 0; i < m; ++i) {
            int count = 0;
            boolean isCheck = false;
            List<Integer> location = new ArrayList<>();

            for (int k = 0; k < n; ++k) {
                if (direction.equals("row")) {
                    if (grid[i][k] == 1) {
                        ++count;
                        location.add(i);
                        location.add(k);
                    }
                    else if (grid[i][k] == 2)
                        isCheck = true;
                } else {
                    if (grid[k][i] == 1) {
                        ++count;
                        location.add(k);
                        location.add(i);
                    }
                    else if (grid[k][i] == 2)
                        isCheck = true;
                }

            }

            if (isCheck && count >= 1 || !isCheck && count >= 2) {
                gridTwoChange(grid, location);
                totalCount += count;
            }

        }

        return totalCount;
    }

    private static void gridTwoChange(int[][] grid, List<Integer> location) {
        int len = location.size() / 2;

        for (int i = 0; i < len; ++i) {
            grid[location.remove(0)][location.remove(0)] = 2;
        }
    }

}
