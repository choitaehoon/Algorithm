package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class 나무자르기2 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int treeNumber = Integer.parseInt(token.nextToken());
        int treeLength = Integer.parseInt(token.nextToken());
        int[] tree = Stream.of(buffer.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(treeMaxCut(treeNumber, treeLength, tree));
    }

    private static long treeMaxCut(int treeNumber, int treeLength, int[] tree) {
        Arrays.sort(tree);

        long left = 0;
        long right = tree[treeNumber-1];
        long resultTree = 0;

        while (left <= right) {
            long middle = (left + right) / 2;
            long count = 0;

            for (int i = 0; i < treeNumber; ++i) {
                count += tree[i] - middle > 0 ? tree[i] - middle : 0;
            }

            if (count < treeLength) {
                right = middle - 1;
            } else {
                resultTree = Math.max(middle, resultTree);
                left = middle + 1;
            }
        }

        return resultTree;
    }

}
