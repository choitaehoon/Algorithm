import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        StringTokenizer arrayNumber = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int index = Integer.parseInt(token.nextToken());
        int[] array = new int[n];

        for (int i=0; i<n; ++i)
            array[i] = Integer.parseInt(arrayNumber.nextToken());

        quickSort(array, 0, array.length-1 );
        System.out.println(array[index-1]);
    }

    private static void quickSort(int[] array, int start, int end){
        if (start >= end) return;
        int middle = partition(array, start,end);
        quickSort(array, start, middle-1);
        quickSort(array,middle+1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int value = arr[end];
        int i = start -1;

        for (int j=start; j<arr.length; ++j) {
            if (value > arr[j])
                swap(++i, j, arr);
        }
        swap(i+1,end,arr);
        return i+1;
    }

    private static void swap(int i, int j, int [] arr) {
        int store = arr[i];
        arr[i] = arr[j];
        arr[j] = store;
    }
}
