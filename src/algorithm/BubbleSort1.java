package algorithm;

import java.util.Arrays;

public class BubbleSort1 {

    static int[] array = {31, 8, 48, 73, 11, 3, 20, 29, 65, 15};

    public static void main(String[] args) {
        bubbleSort();
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort() {

        for (int j = array.length - 1; j >= 1; --j) {
            boolean isCheck = false;
            for (int i = 0; i < j; ++i) {
                if (array[i + 1] < array[i]) {
                    isCheck = true;
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }

            if (!isCheck)
                return;
        }
    }
}
