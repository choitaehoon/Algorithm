package 그리디;

public class Main_807 {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int gridLength = grid.length;
        int[] row = new int[gridLength];
        int[] col = new int[gridLength];

        for (int r = 0; r < gridLength; ++r)
            for (int c = 0; c < gridLength; ++c) {
                row[r] = Math.max(row[r], grid[r][c]);
                col[c] = Math.max(col[c], grid[r][c]);
            }

        int ans = 0;
        for (int r = 0; r < gridLength; ++r)
            for (int c = 0; c < gridLength; ++c)
                ans += Math.min(row[r], col[c]) - grid[r][c];

        return ans;
    }

}
