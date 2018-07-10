import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Modification
{
    static class CompareA
    {
        int x;
        int y;
        CompareA(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());

        CompareA[] c = new CompareA[number];
        for(int i=0; i<number; ++i)
        {
            String[] temp = buffer.readLine().split(" ");
            c[i] = new CompareA(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }

        Arrays.sort(c, new Comparator<CompareA>() {
            @Override
            public int compare(CompareA c1, CompareA c2)
            {
                if(c1.x >c2.y)
                    return c1.x;
                else if(c1.x == c2.x)
                    return c1.y - c2.y;
                else return 0;
            }
        });

        for(int i=0; i<c.length; ++i)
            System.out.printf("%d %d\n", c[i].x, c[i].y);
    }
}
