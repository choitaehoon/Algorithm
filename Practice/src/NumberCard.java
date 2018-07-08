import java.util.HashMap;
import java.util.Scanner;

public class NumberCard
{
    public static void main(String[] args)
    {
        HashMap<Integer,Integer> hash = new HashMap<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for(int i=0; i<n; ++i)
            hash.put(input.nextInt(),1);

        n = input.nextInt();
        for(int i=0; i<n; ++i)
            System.out.printf("%d ", hash.get(input.nextInt()) == null ? 0 : 1);
    }
}
