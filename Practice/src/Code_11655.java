import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code_11655
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String temp = buffer.readLine();
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<temp.length(); ++i)
        {
            if (Character.isUpperCase(temp.charAt(i)))
                builder.append(temp.charAt(i)+13);
        }

        int b = temp.charAt(0)+13;
        System.out.println(Character.toString((char) b));
    }
}
