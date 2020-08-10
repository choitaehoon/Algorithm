package easy;

public class Main231 {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(
                218
        ));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;

        if (n == 1)
            return true;

        while (n % 2 == 0) {
            n /= 2;
        }

        return n == 1;
    }

}
