import java.util.Arrays;
import java.util.Scanner;

public class Coin
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int sum = 0;
        int count = 0;

        int[] temp = new int[n];
        for(int i=0; i<n; ++i)
            temp[i] = input.nextInt();

        for(int i=n-1; i>=0; --i)
            if(temp[i] < k)
                while (sum < k)
                {
                    if(sum + temp[i] > k) break;
                    sum += temp[i];
                    ++count;
                }
        System.out.println(count);
    }
}
