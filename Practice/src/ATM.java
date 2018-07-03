import java.util.Arrays;
import java.util.Scanner;

public class ATM
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int sum=0; int sum1 = 0;
        int[] temp = new int[n];
        for(int i=0; i < temp.length; ++i)
            temp[i] = input.nextInt();
        Arrays.sort(temp);

        for(int i=0; i<n; ++i)
           sum1 += sum += temp[i];
        System.out.println(sum1);
    }
}
