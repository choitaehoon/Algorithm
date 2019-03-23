import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code_10819
{
    public static int [] temp;
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        temp = new int[number];
        for (int i=0; i< number; ++i)
            temp[i] = Integer.parseInt(token.nextToken());
        Arrays.parallelSort(temp);
        int answer = 0;

        do {
            int temp = calculate();
            answer = Math.max(answer, temp);
        }while (permutation());
        System.out.println(answer);
    }

    public static int calculate()
    {
        int sum = 0 ;
        for (int i=1; i< temp.length; ++i)
            sum += Math.abs(temp[i-1] - temp[i]);
        return sum;
    }

    public static void swap(int i, int j)
    {
        int change = temp[i];
        temp[i] = temp[j];
        temp[j] = change;
    }

    public static boolean permutation()
    {
        int i = temp.length-1;

        while (0<i)
        {
            if (temp[i-1] < temp[i]) break;
            --i;
        }

        if (i == 0) //바꿀게 없다면
            return false;
        int j = temp.length-1;
        while (0<j)
        {
            if (temp[i-1] < temp[j]) break;
            --j;
        }
        swap(i-1,j);
        j = temp.length-1;
        while (i<j)
        {
            swap(i,j);
            ++i; --j;
        }
        return true;
    }
}
