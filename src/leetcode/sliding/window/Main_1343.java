package leetcode.sliding.window;

public class Main_1343 {

    public static void main(String[] args) {

    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int start = 0;
        int sum = 0;
        int max = 0;
        int count = 0;

        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];

            if (i >= k - 1) {

                if ( (sum / k) >= threshold) {
                    ++count;
                }

                sum -= arr[start++];
            }
        }

        return count;
    }
}
