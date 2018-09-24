import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code_9012_1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());

        for (int i=0; i<n; ++i)
        {
            String[] temp = buffer.readLine().split("");
            int opening=0,closing=0;
            for (int j=0; j<temp.length; ++j)
            {
                if (temp[j].equals("("))
                    opening +=1;
                else
                    closing +=1;
            }
            System.out.println(opening - closing ==0 ? "YES" : "NO");
        }
    }
}
