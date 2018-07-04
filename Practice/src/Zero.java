import java.util.Arrays;

public class Zero
{
    static int[] d = new int[50];
    public static int search(int n)
    {
        if(n == 1) return 0;
        if(d[n] > 0 )return d[n]; //memoization
        d[n] = search(n-1)+1;

        if(n % 2 == 0)
        {
            int temp = search(n/2) +1;
            if(d[n] > temp ) d[n] = temp;
        }
        if(n % 3 == 0)
        {
            int temp = search(n/3)+1;
            if(d[n] > temp) d[n] = temp;
        }
        return d[n];
    }

    public static void main(String[] args)
    {
        System.out.println(search(10));
        System.out.println(Arrays.toString(d));
    }
}
