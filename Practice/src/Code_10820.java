import java.util.Scanner;

public class Code_10820
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine())
        {
            String temp = input.nextLine();
            int upper =0;
            int lower =0;
            int number =0;
            int gap =0;
            for (int i=0; i<temp.length(); ++i)
            {
                if (Character.isDigit(temp.charAt(i)))
                    ++number;
                else if (Character.isLowerCase(temp.charAt(i)))
                    ++lower;
                else if (Character.isUpperCase(temp.charAt(i)))
                    ++upper;
                else
                    ++gap;
            }
            System.out.printf("%d %d %d %d\n",lower,upper,number,gap);
        }
    }
}
