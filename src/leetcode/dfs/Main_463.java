package leetcode.dfs;

import java.util.*;

public class Main_463 {

    int[] xGo = {-1, 1, 0, 0};
    int[] yGo = {0, 0, -1, 1};
    int sum = 0;

    public int islandPerimeter(int[][] grid) {
        boolean[][] check = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; ++i) {
            for (int k = 0; k < grid[i].length; ++k) {
                if (!check[i][k] && grid[i][k] == 1)
                    search(i, k, grid, check);
            }
        }

        return sum;
    }

    public void search(int row, int col, int[][] grid, boolean[][] check) {
        check[row][col] = true;

        //left
        if (col == 0 || grid[row][col - 1] == 0)
            ++sum;

        //right
        if (col == grid[0].length - 1 || grid[row][col + 1] == 0)
            ++sum;

        //up
        if (row == 0 || grid[row - 1][col] == 0)
            ++sum;

        //down
        if (row == grid.length - 1 || grid[row + 1][col] == 0)
            ++sum;

        for (int i = 0; i < 4; ++i) {
            int xNow = row + xGo[i];
            int yNow = col + yGo[i];

            if (xNow < 0 || xNow >= grid.length || yNow < 0 || yNow >= grid[0].length
                    || check[xNow][yNow] || grid[xNow][yNow] == 0)
                continue;

            search(xNow, yNow, grid, check);
        }
    }

}
