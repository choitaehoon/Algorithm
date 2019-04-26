package 미해결문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 점프게임 {

    static int[][] array;
    static int n;
    static int k;
    static boolean check = false;
    static boolean[] checkNumber;
    static int[] move;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(token.nextToken());
        k = Integer.parseInt(token.nextToken());
        array = new int[2][n];
        checkNumber = new boolean[n*2];
        move = new int[]{1,-1,k};

        for (int i=0; i<2; ++i){
            String[] tokenizer = buffer.readLine().split("");
            for (int j=0; j<n; ++j)
             array[i][j] = Integer.parseInt(tokenizer[j]);
        }

        dfs(0,0,0);
        dfs(0,0,1);

        if (check)
            System.out.println(1);
        else
            System.out.println(0);
    }

    static void dfs(int index, int removeScope, int upDown){
        if (index < 0 || removeScope > index)
            return;

        if (n < index) {
            check = true;
            return;
        }

        for (int i=0; i<3; ++i){
            if (array[upDown][index] == 1 && !check)
                if (i == 2 && upDown == 0)
                    dfs(index+move[i],removeScope+1,1);
                else if (i == 2 && upDown == 1)
                    dfs(index+move[i],removeScope+1,0);
                else
                    dfs(index+move[i],removeScope+1,upDown);
        }

    }

}
