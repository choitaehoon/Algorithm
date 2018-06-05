import java.util.Arrays;

public class CountDiv {
    static int[] a = new int[10];

    static int fibonacci(int n) {
        a[1] = a[2] = 1;
        for (int i = 3; i <= n; ++i) a[i] = a[i - 1] + a[i - 2];
        return a[n];
    }

    public static void main(String[] args) {
        int value = fibonacci(7);
        System.out.println(Arrays.toString(a));
    }
}
