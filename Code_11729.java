import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code_11729
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int number = Integer.parseInt(buffer.readLine());
        builder.append((int)Math.pow(2,number)-1).append("\n");
        builder = search(builder,number,1,2,3);
        System.out.println(builder);
    }

    public static StringBuilder search(StringBuilder builder,int number, int one, int two, int three)
    {
        if (number == 1)
            builder.append(one).append(" ").append(three).append("\n");
        else
        {
            search(builder,number-1,one,three,two);
            builder.append(one).append(" ").append(three).append("\n");
            search(builder,number-1,two,one,three);
        }
        return builder;
    }
}
