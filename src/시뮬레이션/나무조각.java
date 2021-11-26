package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무조각 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int[] array = new int[5];

        for (int i = 0; i < 5; ++i) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        repeatOrderSort(array);
    }

    private static void repeatOrderSort(int[] array) {
        while (true) {
            if (array[0] > array[1]) {
                swap(array, 0, 1);
                printArray(array);
            }

            if (array[1] > array[2]) {
                swap(array, 1, 2);
                printArray(array);
            }

            if (array[2] > array[3]) {
                swap(array, 2, 3);
                printArray(array);
            }

            if (array[3] > array[4]) {
                swap(array, 3, 4);
                printArray(array);
            }

            if (isOrderSort(array))
                break;
        }
    }

    private static boolean isOrderSort(int[] array) {
        for (int i = 1, index = 0; i <= 5; ++i, ++index) {
            if (array[index] != i)
                return false;
        }

        return true;
    }

    private static void swap(int[] array, int pre, int post) {
        int temp = array[pre];
        array[pre] = array[post];
        array[post] = temp;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i< 5; ++i) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

}
