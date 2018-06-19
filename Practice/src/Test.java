import java.util.Arrays;

public class Test {
    static int[] a = new int[100];
    static int count =0;

    static int fibonacci(int n) {
        ++count;
        if (n == 1 || n == 2) a[n] = 1;
        else a[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return a[n];
    }

    public static void main(String[] args) {
        int value = fibonacci(7);
        System.out.println(value);
        System.out.println(count);
    }
}
