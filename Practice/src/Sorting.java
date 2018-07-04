import java.util.Arrays;
import java.util.Scanner;

public class Sorting
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] temp = new int[n];
        for(int i=0; i < n ; ++i)
            temp[i] = input.nextInt();
        Arrays.sort(temp);

        for(int i=0; i < n; ++i)
            System.out.println(temp[i]);
    }
}
