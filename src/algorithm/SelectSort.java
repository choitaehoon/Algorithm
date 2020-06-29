package algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectSort {

    static int[] array = {31, 8, 48, 73, 11, 3, 20, 29, 65, 15};

    public static void main(String[] args) {
        selectSort();
        System.out.println(Arrays.toString(array));
    }

    private static void selectSort() {
        for (int i = 0; i < array.length; ++i) {
            int min = array[i];
            boolean isCheck = false;
            int jIndex = 0;

            for (int j = i + 1; j < array.length; ++j) {
                if (array[j] < min) {
                    isCheck = true;
                    min = array[j];
                    jIndex = j;
                }
            }

            if (isCheck) {
                int temp = array[i];
                array[i] = array[jIndex];
                array[jIndex] = temp;
            }
        }

    }

}
