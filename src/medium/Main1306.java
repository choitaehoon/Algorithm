package medium;

public class Main1306 {

    public static void main(String[] args) {
        System.out.println(canReach(
                new int[]{3, 0, 2, 1, 2}, 2
        ));
    }

    public static boolean canReach(int[] arr, int start) {
        return recursive(arr, start);
    }

    private static boolean recursive(int[] arr, int start) {
        if (arr.length > start && start >= 0 && arr[start] >= 0) {
            if (arr[start] == 0) {
                return true;
            }

            arr[start] = -arr[start];
            return recursive(arr, start + arr[start]) || recursive(arr, start - arr[start]);
        }

        return false;
    }

}
