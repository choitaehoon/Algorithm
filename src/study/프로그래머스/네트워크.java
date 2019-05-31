package study.프로그래머스;

@SuppressWarnings("Duplicates")
public class 네트워크 {

    static int sum;
    static boolean [] checkNumber;

    public static void main(String[] args) {
//        System.out.println(solution(3,new int[][]{{1,1,0} , {1,1,0}, {0,0,1}}));
        System.out.println(solution(3,new int[][]{{1,1,0} , {1,1,1}, {0,1,1}}));
    }

    public static int solution(int n, int[][] computers) {
        checkNumber = new boolean[n];

        for (int i=0; i<n; ++i)
            if (!checkNumber[i]) {
                ++sum;
                dfs(i,computers, n);
            }
        return sum;
    }

    private static void dfs(int index, int [][] computers, int n) {
        checkNumber[index] = true;

        for (int i=0; i<n; ++i)
            if (index != i && computers[index][i] == 1 && !checkNumber[i])
                dfs(i,computers,n);
    }

}
