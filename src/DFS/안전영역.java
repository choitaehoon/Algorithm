package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SuppressWarnings("Duplicates")
public class 안전영역 {

    static int [][] array;
    static int[] xMove = {-1,1,0,0};
    static int[] yMove = {0,0,-1,1};
    static boolean[][] check;
    static Set<Integer> set = new HashSet<>();
    static List<Integer> list = new ArrayList<>();
    static int count;
    static int givenNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());
        array = new int[givenNumber][givenNumber];
        check = new boolean[givenNumber][givenNumber];

        //배열 삽입
        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            for (int j=0; j<givenNumber; ++j) {
                int number = Integer.parseInt(token.nextToken());
                array[i][j] = number;
                set.add(number);
            }
        }

        list.addAll(set);

        int length = set.size();

        //높이 이하 인지 검사
        for (int z=0; z<length; ++z) {
            int num = list.remove(0);

            for (int i=0; i<givenNumber; ++i)
                for (int j=0; j<givenNumber; ++j) {
                    if (num >= array[i][j] && !check[i][j]) {
                        dfs(i,j, num);
                    }
                }

            int cnt = countCheck();
            count = Math.max(count, cnt);
            falseMake();
        }

        //아무 지역도 물에 잠기지 않을 수 있기 때문
        count = count == 0 ? 1 : count;
        System.out.println(count);
    }

    private static void dfs(int x, int y, int num) {
        check[x][y] = true;

        for (int i=0; i<4; ++i) {
            int xGo = x + xMove[i];
            int yGo = y + yMove[i];

            if (xGo >= givenNumber || xGo < 0 || yGo >= givenNumber || yGo < 0 || check[xGo][yGo] || num < array[xGo][yGo])
                continue;

            dfs(xGo,yGo, num);
        }
    }

    private static int countCheck(){
        int count = 0;

        for (int i=0; i<givenNumber; ++i)
            for (int j=0; j<givenNumber; ++j)
                if (!check[i][j]) {
                    ++count;
                    countDfs(i,j);
                }

        return count;
    }

    private static void countDfs(int x, int y){
        check[x][y] = true;

        for (int i=0; i<4; ++i) {
            int xGo = x + xMove[i];
            int yGo = y + yMove[i];

            if (xGo >= givenNumber || xGo < 0 || yGo >= givenNumber || yGo < 0 || check[xGo][yGo])
                continue;

            countDfs(xGo,yGo);
        }
    }

    private static void falseMake() {
        for (int i=0; i<givenNumber; ++i)
            for (int j=0; j<givenNumber; ++j)
                check[i][j] = false;
    }

}