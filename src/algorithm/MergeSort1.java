package algorithm;

import java.util.Arrays;

// 수행시간 O(nlong)
// 공간 복잡도 O(N)
public class MergeSort1 {

    static int[] array = new int[]{31, 3, 65, 73, 8, 11, 20, 29, 48, 15};

    public static void main(String[] args) {
        merge(0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void merge(int start, int end) {
        if (start >= end) return;
        int middle = (start + end) / 2;
        merge(start, middle);
        merge(middle + 1, end);
        mergeSort(start, middle, end);
    }

    private static void mergeSort(int start, int middle, int end) {
        int s = start;
        int m = middle + 1;
        int [] newArray = new int[end - start + 1];
        int newIndex = 0;

        while (s <= middle && m <= end) {
            if (array[s] <= array[m])
                newArray[newIndex++] = array[s++];
            else
                newArray[newIndex++] = array[m++];
        }

        while (s <= middle)
            newArray[newIndex++] = array[s++];

        while (m <= end)
            newArray[newIndex++] = array[m++];

        int len = newArray.length;
        for (int i = 0; i < len; ++i)
            array[start++] = newArray[i];
    }


}
