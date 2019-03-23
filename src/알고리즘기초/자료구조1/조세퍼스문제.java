package 알고리즘기초.자료구조1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 조세퍼스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<n; ++i)
            queue.offer(i+1);

        StringBuilder builder = new StringBuilder();
        builder.append("<");
        for (int i=0; i<n; ++i) {

            //값 뒤로 넣기
            for (int j=0; j<k-1; ++j)
                queue.offer(queue.poll());

            if (n - 1 != i) {
                builder.append(queue.poll()).append(", ");
                continue;
            }

            builder.append(queue.poll()).append(">");
        }

        System.out.println(builder);

    }
}
