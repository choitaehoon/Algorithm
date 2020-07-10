package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SuppressWarnings("all")
public class 문제집 {

    static int N;
    static int E;
    static int[] nodeCount;
    static List<List<Integer>> nodeArray = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        N = Integer.parseInt(token.nextToken());
        E = Integer.parseInt(token.nextToken());
        nodeCount = new int[N + 1];

        for (int i = 0; i <= N; ++i)
            nodeArray.add(new ArrayList<>());

        for (int i = 0; i < E; ++i) {
            StringTokenizer node = new StringTokenizer(buffer.readLine());
            int preNode = Integer.parseInt(node.nextToken());
            int nextNode = Integer.parseInt(node.nextToken());

            nodeArray.get(preNode).add(nextNode);
            nodeCount[nextNode]++;
        }

        workBookSearch();
    }

    private static void workBookSearch() {
        PriorityQueue<Integer> book = new PriorityQueue<>();

        for (int i = 1; i <= N; ++i) {
            if (nodeCount[i] == 0)
                book.offer(i);
        }

        for (int i = 1; i <= N; ++i) {
            int v = book.remove();
            System.out.print(v+" ");

            for (int nextV : nodeArray.get(v)) {
                nodeCount[nextV]--;

                if (nodeCount[nextV] == 0)
                    book.offer(nextV);

                System.out.println(book);
            }
        }
    }

}
