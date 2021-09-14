package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < n; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            boolean[] check = new boolean[100_000];

            Queue<Word> queue = new LinkedList<>();
            queue.offer(new Word(start, ""));
            solution(queue, end, check);
        }
    }

    private static void solution(Queue<Word> queue, int end, boolean[] check) {
        while (!queue.isEmpty()) {
            Word word = queue.poll();
            int num = word.word;

            int d = D(num);
            if (d == end) {
                System.out.println(word.result + "D");
                return;
            }
            else if (!check[d]) {
                check[d] = true;
                queue.offer(new Word(d, word.result+"D"));
            }

            int s = S(num);
            if (s == end) {
                System.out.println(word.result + "S");
                return;
            }
            else if (!check[s]) {
                check[s] = true;
                queue.offer(new Word(s, word.result + "S"));
            }

            int l = L(num);
            if (l == end) {
                System.out.println(word.result + "L");
                return;
            }
            else if (!check[l]) {
                check[l] = true;
                queue.offer(new Word(l, word.result + "L"));
            }

            int r = R(num);
            if (r == end) {
                System.out.println(word.result + "R");
                return;
            }
            else if (!check[r]) {
                check[r] = true;
                queue.offer(new Word(r, word.result + "R"));
            }
        }
    }

    private static int R(int num) {
        return ((num % 10) * 1000) + (num / 10);
    }

    private static int L(int num) {
        return ((num % 1000) * 10) + num / 1000;
    }

    private static int D(int num) {
        return (num * 2) % 10_000;
    }

    private static int S(int num) {
        int calculate = num - 1;
        return calculate == -1 ? 9999 : num - 1;
    }

}

class Word {

    int word;
    String result;

    public Word(int word, String result) {
        this.word = word;
        this.result = result;
    }

}