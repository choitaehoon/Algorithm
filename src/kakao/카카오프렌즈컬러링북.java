package kakao;

import java.util.*;

// 반례 찾기
public class 카카오프렌즈컬러링북 {
    static int area;
    static int maxArea = 1;
    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, 1, 0, -1};
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0},
                        {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));

        System.out.println(Arrays.toString(solution(13, 16,
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0},
                        {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0},
                        {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}
                }
        )));
    }

    public static int[] solution(int m, int n, int[][] picture) {

        boolean[][] isCheck = new boolean[m][n];

        for (int i=0; i<m; ++i) {
            for (int j=0; j<n; ++j){
                if (!isCheck[i][j] && picture[i][j] != 0) {
                    recursivePicture(i, j, m, n, picture, isCheck, picture[i][j]);
                    list.add(maxArea);
                    maxArea = 1;
                    ++area;
                }
            }
        }

        Collections.sort(list);
        Collections.reverse(list);

        int[] answer = new int[2];
        answer[0] = area;
        answer[1] = list.get(0);

        return answer;
    }

    private static void recursivePicture(int width, int vertical, int m, int n, int[][] picture,
                                         boolean[][] isCheck, int pictureValue) {

        isCheck[width][vertical] = true;

        for (int i=0; i<4; ++i) {
            int xGo = width + xMove[i];
            int yGo = vertical + yMove[i];

            if (xGo < 0 || xGo >= m || yGo < 0 || yGo >= n ||
                    isCheck[xGo][yGo] || pictureValue != picture[xGo][yGo])
                continue;

            recursivePicture(xGo, yGo, m, n, picture, isCheck, pictureValue);
            ++maxArea;
        }
    }

}
