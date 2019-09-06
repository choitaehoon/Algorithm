import java.util.Arrays;

public class MergeSort {

    private static int[] array = {31, 3, 65, 73, 8, 11};

    public static void main(String[] args) {
        merge(0,array.length-1);
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
        int m = middle+1;
        int[] newArray = new int[end - start + 1];
        int newIndex = 0;

        //왼쪽 배열과 오른쪽 배열값 비교
        while (s <= middle && m <= end){
            if (array[s] <= array[m])
                newArray[newIndex++] = array[s++];
            else
                newArray[newIndex++] = array[m++];
        }

        //왼쪽 값이 남아 있으면
        while (s <= middle)
            newArray[newIndex++] = array[s++];

        //오른쪽 값이 남아 있으면
        while (m <= end)
            newArray[newIndex++] = array[m++];

        int circle = newArray.length;
        for (int i=0; i<circle; ++i)
            array[start++] = newArray[i];
    }

}