import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class CompareA implements Comparable<CompareA>
{
    int x;
    int y;

    CompareA(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(CompareA c1)
    {
        if(this.x >c1.x)
            return 1;
        else if(this.x == c1.x)
        {
            if(this.y > c1.y)
                return 1;
            else if(this.y == c1.y)
                return 0;
            else
                return -1;
        }
        else
            return -1;
    }

}

public class Code_11650
{
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

        Arrays.sort(c);

        StringBuilder s = new StringBuilder();
        for(CompareA a : c)
            s.append(a.x+" "+a.y+"\n");
        System.out.println(s);
    }
}
