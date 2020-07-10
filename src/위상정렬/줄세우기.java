package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 줄세우기 {

    static int N; // 정점 개수
    static int E; // 간선 개수
    static List<List<Integer>> nodeArray = new ArrayList<>(); // 정점 리스트
    static int[] nodeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        N = Integer.parseInt(token.nextToken());
        E = Integer.parseInt(token.nextToken());
        nodeCount = new int[N + 1];

        for (int i = 0; i <= N; ++i)
            nodeArray.add(new ArrayList<>());

        //단방향 연결 설정
        for (int i = 0; i < E; ++i) {
            StringTokenizer tokenNode = new StringTokenizer(buffer.readLine());
            int v1 = Integer.parseInt(tokenNode.nextToken());
            int v2 = Integer.parseInt(tokenNode.nextToken());

            nodeArray.get(v1).add(v2);
            nodeCount[v2]++;
        }

        System.out.println(nodeArray);

        //위상 정렬 (A B : A가 B보다 앞에 선다)
        topologicalSort();
    }

    private static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        //초기 : 진입 간선이 없는 노드를 큐에 삽입
        for (int i = 1; i <= N; ++i) {
            if (nodeCount[i] == 0)
                queue.offer(i);
        }

        for (int i = 0; i < N; ++i) {
            int v = queue.remove();
            System.out.print(v +" ");

            for (int nextV : nodeArray.get(v)) {
                nodeCount[nextV]--;

                if (nodeCount[nextV] == 0)
                    queue.offer(nextV);
            }
        }
    }

}
