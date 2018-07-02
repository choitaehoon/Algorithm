import java.util.Scanner;

public class Fibonacci
{
    static int[] tt = new int[50];
    static int fibonacci(int n)
    {
        if(n == 0 ) return ++tt[0]; //종료 조건
        else if(n == 1) return ++tt[1]; //종료 조건
        else
            return tt[n]=fibonacci(n-1)+fibonacci(n-2);
    }

    static void empty()
    {
        tt[0] = 0;
        tt[1] = 0;
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int temp = input.nextInt();
        for(int i=0; i<temp; ++i)
        {
            int temp1 = input.nextInt();
            empty();
            fibonacci(temp1);
            System.out.printf("%d %d", tt[0], tt[1]);
        }
    }
}
