import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code_1722
{
    public static long[] factorial = new long[21];
    public static boolean[] search = new boolean[21];

    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        factorial();
        int number = Integer.parseInt(token.nextToken());

        if (number == 1)
        {
            long k =Integer.parseInt(token.nextToken());
            StringBuilder builder = new StringBuilder();
            int[] list = new int[n];
            for (int i=0; i<n; ++i)
            {
                for (int j=1; j<=n; ++j)
                {
                    if (search[j]) continue;
                    if (factorial[n-i-1] < k)
                        k -= factorial[n-i-1];
                    else
                    {
                        list[i] = j;
                        search[j] =true;
                        break;
                    }
                }
            }
            for (int i=0; i<n; ++i)
                builder.append(list[i]).append(" ");
            System.out.println(builder);
        }

        else if (number == 2)
        {
            int [] list = new int[n];
            for (int i=0; i<n; ++i)
                list[i] = Integer.parseInt(token.nextToken());
            long k = 0;
            for (int i=0; i<n; ++i)
            {
                for (int j=1; j<list[i]; ++j)
                    if (!search[j]) k += factorial[n-i-1];
                search[list[i]] = true;
            }
            System.out.println(k+1);
        }
    }

    public static void factorial()
    {
        factorial[0] = 1;
        for (int i=1; i<21; ++i)
            factorial[i] = factorial[i-1] * i;
    }

}
