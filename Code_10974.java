import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Code_10974
{
    static int [] array;
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int number = Integer.parseInt(buffer.readLine());
        int factorial = 1;
        array = new int[number];
        for (int i=1; i<=number; ++i)
            factorial = factorial*i;

        for (int i=0; i<number; ++i)
            array[i] = i+1;

        for (int i=0; i<factorial; ++i)
        {
            if (0 <i) search();
            builder = stringBuilder();
            System.out.println(builder);
        }
    }

    public static void search()
    {
        int i = array.length-1;
        while (0<i)
        {
            if (array[i-1] < array[i])
                break;
            --i;
        }
        if (i == 0) return;

        int j = array.length-1;
        while (0<j)
        {
            if (array[i-1] < array[j])
                break;
            --j;
        }

        swap(i-1,j);
        j=array.length- 1;
        while (i<j)
            swap(i++,j--);
    }

    public static void swap(int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static StringBuilder stringBuilder()
    {
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<array.length; ++i)
            builder.append(array[i]).append(" ");
        return builder;
    }
}
