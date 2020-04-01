package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기1 {

    static int tree;
    static int treeLength;
    static int[] array;
    static long maxLength;
    static long lengthStandard;

    public static void main(String[] args) throws IOException {
        inputTree();
        binarySearchTree();
        System.out.println(maxLength);
    }

    private static void inputTree() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =
                new StringTokenizer(buffer.readLine());

        tree = Integer.parseInt(token.nextToken());
        treeLength = Integer.parseInt(token.nextToken());
        array = new int[tree];

        StringTokenizer token2 =
                new StringTokenizer(buffer.readLine());

        for (int i=0; i<tree; ++i) {
            array[i] = Integer.parseInt(token2.nextToken());
        }

        Arrays.sort(array);
    }

    private static void binarySearchTree() {
        int start = 0;
        int end = array[tree-1];

        while (start <= end) {
            int middle = (start + end) / 2;
            long sum = 0;

            for (int i=0; i<tree; ++i) {
                if (middle < array[i]) {
                    sum += array[i] - middle;
                }
            }

            if (sum < treeLength) {
                end = middle - 1;
            } else {
                start = middle + 1;
                maxLength = Math.max(maxLength, middle);
            }
        }

    }

}
