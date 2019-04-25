package 미해결문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//시간 초과 다시풀기...
@SuppressWarnings("Duplicates")
public class 숨바꼭질4 {

    static int n;
    static int k;
    static int min = Integer.MAX_VALUE;
    static int[] numberMove = {-1,1,2};
    static boolean[] checkNumber;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> store = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(token.nextToken());
        k = Integer.parseInt(token.nextToken());
        checkNumber = new boolean[k];

        if (n == k) {
            System.out.println(0);
            System.out.println(n);
            return;
        }
        else if (n > k) {
            System.out.println(n-k);
            StringBuilder builder = new StringBuilder();
            while (n != k-1)
                builder.append(n--).append(" ");
            System.out.println(builder);
            return;
        }

        dfs(n,0);
        System.out.println(min);
        store.add(0,n);

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<store.size(); ++i)
            builder.append(store.get(i)).append(" ");

        System.out.println(builder);
    }

    private static void dfs(int n,int count) {
        if (n < 1 || n > k)
            return;

        if (n == k && min > count) {
            min = count;
            store.clear();
            store.addAll(list);
            return;
        }

        for (int i=0; i<3; ++i) {
            if (!checkNumber[n-1]) {
                checkNumber[n-1] = true;
                if (i <= 1) {
                    list.add(n+numberMove[i]);
                    dfs(n+numberMove[i], count+1);
                }
                else {
                    list.add(n*numberMove[i]);
                    dfs(n*numberMove[i], count+1);
                }
                list.remove(list.size()-1);
                checkNumber[n-1] = false;
            }
        }

    }
}
