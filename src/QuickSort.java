import java.util.Arrays;

public class QuickSort {

    static int[] array = {15,7,2,9,14};

    public static void main(String[] args) {
        quickSort(0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int start, int end) {
        if (start >= end) return;
        int middle = partition(start, end);
        quickSort(start, middle -1);
        quickSort(middle + 1, end);
    }

    private static int partition(int start, int end) {
        int value = array[end];
        int i = start - 1;

        for (int j=start; j<end; ++j)
            if (array[j] < value)
                swap(++i,j);
            swap(i+1,end);
            return i+1;

//        int value = array[start];
//        int i = end + 1;
//        for (int j=end; j > start; --j)
//            if (array[j] > value)
//                swap(--i, j);
//            swap(i-1, start);
//            return i-1;
    }

    private static void swap(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}