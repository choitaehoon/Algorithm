package kakao;

public class 보행자천국 {

    static int MOD = 20170805;
    static int[][] right;
    static int[][] down;

    public static void main(String[] args) {
        System.out.println(solution(
                3, 6,
                new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}
        ));
    }

    public static int solution(int m, int n, int[][] cityMap) {

        right = new int[501][501];
        down = new int[501][501];

        right[1][1] = down[1][1] = 1;

        for (int i = 1; i <= m; ++i) {
            for (int z = 1; z <= n; ++z) {
                int cityMapArray = cityMap[i - 1][z - 1];

                if (i == 1 && z == 1)
                    continue;

                if (cityMapArray == 0) {
                    right[i][z] = (right[i][z - 1] + down[i - 1][z]) % MOD;
                    down[i][z] = (right[i][z - 1] + down[i - 1][z]) % MOD;
                } else if (cityMapArray == 1) {
                    right[i][z] = 0;
                    down[i][z] = 0;
                } else {
                    right[i][z] = right[i][z - 1];
                    down[i][z] = down[i - 1][z];
                }
            }
        }

        return right[m][n];
    }


}
