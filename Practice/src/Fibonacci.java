import java.util.Arrays;

public class Fibonacci
{
    static int [] a = new int[1000];
    public static int solution(int n) {
        if(a[n] != 0) return a[n];
        if(n == 1)  return a[n] = 1;
        if(n == 0)  return a[n] = 0;
        else
            a[n] = solution (n-1) + solution(n-2);
        return a[n] % 1234567;
    }

    public static void main(String[] args)
    {
        System.out.println(solution(5));
    }
}
