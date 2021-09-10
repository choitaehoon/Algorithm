package leetcode.bfs;

public class Main_1254 {

    int[] xMove = {-1, 1, 0, 0};
    int[] yMove = {0, 0, -1, 1};
    boolean found;

    public int closedIsland(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        boolean[][] visit = new boolean[x][y];
        int count = 0;

        for (int i = 0; i < x; ++i) {
            for (int k = 0; k < y; ++k) {
                if (!visit[i][k] && grid[i][k] == 0) {
                    dfs(visit, grid, i, k, x - 1, y - 1);

                    count += found ? 0 : 1;
                    found = false;
                }
            }
        }

        return count;
    }

    private void dfs(boolean[][] visit, int[][] grid, int x, int y, int xSize, int ySize) {
        visit[x][y] = true;

        if (x == 0 || x == xSize || y == 0 || y == ySize) {
            found = true;
        }

        for (int i = 0; i < 4; ++i) {
            int xGo = x + xMove[i];
            int yGo = y + yMove[i];

            if (xGo < 0 || xGo > xSize || yGo < 0 || yGo > ySize || visit[xGo][yGo] || grid[xGo][yGo] == 1)
                continue;

            dfs(visit, grid, xGo, yGo, xSize, ySize);
        }
    }

}
