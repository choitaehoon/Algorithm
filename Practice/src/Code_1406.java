import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Code_1406
{
    public static void main(String[] args)
    {
        List<String> link = new LinkedList<>();
        Scanner input = new Scanner(System.in);

        String temp = input.nextLine();
        int n = input.nextInt();
        int k=temp.length();

        link.add(temp);
        link.add(1,"d");
        System.out.println(link);
//        for (int i=0; i<n; ++i)
//        {
//
//        }

        System.out.printf("%d",k);
    }
}
