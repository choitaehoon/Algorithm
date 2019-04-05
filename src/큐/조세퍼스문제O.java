package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 조세퍼스문제O {

    static Queue<Integer> queue = new LinkedList<>();
    static int[] queueArray;
    static int queueIndex;

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        queueArray = new int[n];

        for (int i=0; i<n; ++i)
            queue.offer(i+1);

        while (!queue.isEmpty()) {

            for (int i=0; i<k-1; ++i)
                queue.offer(queue.poll());

            queueArray[queueIndex++] = queue.poll();
        }

        System.out.print("<");
        for (int i=0; i<queueArray.length; ++i)
            if (i != queueArray.length-1)
                System.out.print(queueArray[i]+", ");
            else
                System.out.print(queueArray[i]+">");
    }
}
