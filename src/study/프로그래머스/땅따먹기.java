package study.프로그래머스;

public class 땅따먹기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,2,3,5}, {5,6,7,8}, {4,3,2,1}}));
    }

    static int solution(int[][] land) {
        int[][] sum = new int[land.length][4];

        for (int i=0; i<4; ++i)
            sum[0][i] = land[0][i];

        for (int i=1; i<land.length; ++i) {
            for (int j=0; j<4; ++j)
                for (int k=0; k<4; ++k){
                    if (j == k) continue;
                    sum[i][k] = Math.max(sum[i-1][j] + land[i][k], sum[i][k]);
                }

        }

        int max = 0;
        for (int i=0; i<4; ++i)
            max = Math.max(sum[land.length-1][i], max);

        return max;
    }
}
