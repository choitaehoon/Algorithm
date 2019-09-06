import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {7,2, 9,14,1,15,8};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {

        for (int i=1; i<arr.length; ++i){
            int value = arr[i];
            int j;
            for (j=i-1; j>=0; --j){
                if (value < arr[j])
                    arr[j+1] = arr[j];
                else
                    break;
            }
            arr[j+1] = value;
        }

    }

    private static void swap(int i, int j, int ... arr) {
        int store = arr[i];
        arr[i] = arr[j];
        arr[j] = store;
    }

}
