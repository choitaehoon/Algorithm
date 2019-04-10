package 깊이너비우선탐색;

public class 네트워크 {

    static boolean[] checkComputers;

    public static void main(String[] args) {
        int n = 3;
//        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution(n,computers));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        checkComputers = new boolean[n];

        for (int i=0; i<n; ++i) {
                if (!checkComputers[i]) {
                    ++answer;
                    dfs(i, computers, n);
                }
        }

        return answer;
    }

    private static void dfs(int index , int[][] computers, int n) {
        checkComputers[index] = true;

        for (int i=0; i<n; ++i)
            if (!checkComputers[i] && computers[index][i] == 1)
                dfs(i,computers,n);
    }
}
