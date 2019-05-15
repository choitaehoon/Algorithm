package 알고리즘중급.자료구조2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 집합의표현 {

    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        tree = new int[n+1];

        //초기화
        for (int i=0; i<=n; ++i)
            tree[i] = i;

        for (int i=0; i<m; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());

            int check = Integer.parseInt(tokenizer.nextToken());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            if (check == 0)
                union(a,b);
            else {
                a = find(a);
                b = find(b);
                if (a == b)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }

    static int find(int index) {
        if (index == tree[index])
            return index;
        else
            return tree[index] = find(tree[index]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y)
            tree[y] = x;
    }

}
