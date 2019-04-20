package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 일곱난쟁이 {

    static int[] givenArray;
    static boolean[] check;
    static List<Integer> list = new ArrayList<>();
    static boolean search = false;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenArray = new int[9];
        check = new boolean[9];

        for (int i=0; i<9; ++i)
            givenArray[i] = Integer.parseInt(buffer.readLine());

        dfs(0,0, 0);

        Collections.sort(list);

        for (int i=0; i<list.size(); ++i)
            System.out.println(list.get(i));
    }

    static void dfs (int index, int sum, int indexSum) {
        if (index > 9) return;

        if (sum == 100 && indexSum == 7) {
            for (int j = 0; j < 9; ++j)
                if (check[j])
                    list.add(givenArray[j]);
                search = true;
            return;
        }

        else  {
            for (int i=0; i<9; ++i) {
                if (!check[i] && !search) {
                    check[i] = true;
                    dfs(i+1, sum + givenArray[i], indexSum + 1);
                    check[i] = false;
                }
            }

        }
    }


}
