package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 방문길이 {

    static int[] xMove = {0, 1, 0, -1};
    static int[] yMove = {1, 0, -1, 0};
    static Map<Character, Integer> dirsGo = new HashMap<>();
    static int count;
    static boolean[][][][] visit = new boolean[11][11][11][11];

    public static void main(String[] args) {
        System.out.println(solution(
                "ULURRDLLU"
        ));
    }

    public static int solution(String dirs) {
        addDirsGo();

        int x = 5;
        int y = 5;
        for (int i = 0; i < dirs.length(); ++i) {
            int xGo = x + xMove[dirsGo.get(dirs.charAt(i))];
            int yGo = y + yMove[dirsGo.get(dirs.charAt(i))];

            if (xGo < 0 || xGo > 10 || yGo < 0 || yGo > 10)
                continue;

            if (!visit[x][y][xGo][yGo]) {
                visit[x][y][xGo][yGo] = true;
                visit[xGo][yGo][x][y] = true;
                ++count;
            }

            x = xGo;
            y = yGo;
        }

        return count;
    }

    private static void addDirsGo() {
        dirsGo.put('U', 0);
        dirsGo.put('R', 1);
        dirsGo.put('D', 2);
        dirsGo.put('L', 3);
    }

}