import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {7,2, 9,14,1,15,8};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr){
        for (int i=arr.length-1; i>0; --i){
            boolean check = false;
            for (int j=0; j<i; ++j)
                if (arr[j] > arr[j+1]) {
                    swap(j,j+1,arr);
                    check = true; // 정렬 되어 있지 x
                }

            if (!check) break;
        }
    }

    private static void swap(int i, int j, int[] arr){
        int store = arr[i];
        arr[i] = arr[j];
        arr[j] = store;
    }

}
