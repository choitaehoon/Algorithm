package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 부등호 {

    static List<String> result = new ArrayList<>();
    static boolean[] visit = new boolean[10];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(buffer.readLine());
        String[] word = buffer.readLine().split(" ");
        
        solution(n, word);
        System.out.println(result.get(result.size() - 1));
        System.out.println(result.get(0));
    }

    private static void solution(int n, String[] word) {
        for (int i = 0; i <= 9; ++i) {
            visit[i] = true;
            circle(i, 0, i + "", word);
        }
    }

    private static void circle(int i, int count, String s, String[] word) {
        if (count == n) {
            result.add(s);
        } else {
            for (int k = 0; k <= 9; ++k) {
                if(!visit[k]) {
                    if (word[count].equals("<")) {
                        if (i >= k)
                            continue;
                    } else {
                        if (i <= k)
                            continue;
                    }

                    visit[k] = true;
                    circle(k, count + 1, s + k, word);
                }
            }
        }

        visit[i] = false;
    }

}
